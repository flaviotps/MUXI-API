package com.flaviotps.muxi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flaviotps.muxi.Util.Constants;
import com.flaviotps.muxi.domain.model.TerminalModel;
import com.flaviotps.muxi.domain.response.ErrorResponse;
import com.flaviotps.muxi.repository.TerminalRepository;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalService {


    @Autowired
    TerminalRepository terminalRepository;


    /**
     * Validates the json schema     *
     * @param obj JSON OBJECT
     * @return returns a boolean
     */
    public boolean validate(JSONObject jsonSchema, JSONObject obj) {

        try {
            SchemaLoader loader = SchemaLoader.builder()
                    .schemaJson(jsonSchema)
                    .draftV6Support()
                    .build();
            Schema schema = loader.load().build();
            schema.validate(obj);
            return true;
        } catch (ValidationException e) {
            return false;
        }
    }

    /**
     * List all TerminalModel entities with with pagination     *
     * @param page
     * @param size
     * @return return a list of TerminalModel
     */

    public List<TerminalModel> findAll(int page, int size) {
        return terminalRepository.findAll(PageRequest.of(page, size)).getContent();
    }


    /**
     * Parses the raw payload and saves de entity     *
     * @param payload payload text/html utf-8
     * @return Json object.
     */
    private JSONObject parse(String payload) {

        String splitedPayLoad[] = payload.split(Constants.PAYLOAD_DIVIDER);

        JSONObject objectMap = new JSONObject();


        objectMap.put(Constants.PROPERTY_LOGIC, Integer.valueOf(splitedPayLoad[Constants.INDEX_LOGIC]));
        objectMap.put(Constants.PROPERTY_SERIAL, splitedPayLoad[Constants.INDEX_SERIAL]);
        objectMap.put(Constants.PROPERTY_MODEL, splitedPayLoad[Constants.INDEX_MODEL]);
        objectMap.put(Constants.PROPERTY_SAM, Integer.valueOf(splitedPayLoad[Constants.INDEX_SAM]));
        objectMap.put(Constants.PROPERTY_PTID, splitedPayLoad[Constants.INDEX_PTID]);
        objectMap.put(Constants.PROPERTY_PLAT, Integer.valueOf(splitedPayLoad[Constants.INDEX_PLAT]));
        objectMap.put(Constants.PROPERTY_VERSION, splitedPayLoad[Constants.INDEX_VERSION]);
        objectMap.put(Constants.PROPERTY_MXR, Integer.valueOf(splitedPayLoad[Constants.INDEX_MXR]));
        objectMap.put(Constants.PROPERTY_MXF, Integer.valueOf(splitedPayLoad[Constants.INDEX_MXF]));
        objectMap.put(Constants.PROPERTY_VERFM, splitedPayLoad[Constants.INDEX_VERFM]);

        return objectMap;

    }

    /**
     * saves the entity     *
     * @param payload payload text/html utf-8
     * @return string with error ou entity (json).
     */
    public String save(String payload) {

        try {
            JSONObject jsonObject = parse(payload);
            JSONObject schema = new JSONObject(Constants.JSON_SCHEMA);
            if (validate(schema, jsonObject)) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
                TerminalModel terminalModel = objectMapper.readValue(jsonObject.toString(), TerminalModel.class);
                if (terminalRepository.findByLogic(terminalModel.getLogic()) == null) {
                    terminalRepository.save(terminalModel);
                    return jsonObject.toString();
                } else {
                    return new ErrorResponse(Constants.ENTITY_DUPLICATED).toString();
                }

            } else {
                return new ErrorResponse(Constants.INVALID_JSON_SCHEMA).toString();
            }

        } catch (Exception e) {
            return new ErrorResponse(Constants.INVALID_PAYLOAD, e.getMessage()).toString();
        }
    }

    /**
     * Find a entity
     *
     * @param logic Integer
     * @return returns the TerminalModel entity object
     */
    public TerminalModel findAllByLogic(int logic) {
        return terminalRepository.findByLogic(logic);
    }


    /**
     * Updates a exsisting entity
     *
     * @param terminalModel
     * @param logic
     * @return return a String (json) with the entity ou error.
     */
    public String update(TerminalModel terminalModel, int logic) {

        TerminalModel temp = terminalRepository.findByLogic(logic);

        if (temp == null) {
            return new ErrorResponse(Constants.ENTITY_NOT_FOUND).toString();
        }

        if (terminalModel.getLogic() != logic) {
            return new ErrorResponse("ID'S DIFERENTES").toString();
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            try {
                JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(terminalModel));
                JSONObject schema = new JSONObject(Constants.JSON_SCHEMA);
                if (validate(schema, jsonObject)) {
                    terminalRepository.save(terminalModel);
                    return jsonObject.toString();
                } else {
                    return new ErrorResponse(Constants.INVALID_JSON_SCHEMA).toString();
                }
            } catch (JsonProcessingException e) {
                return new ErrorResponse(Constants.PARSE_ERROR).toString();
            }
        }
    }
}
