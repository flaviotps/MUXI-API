package com.flaviotps.muxi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flaviotps.muxi.Util.Constants;
import com.flaviotps.muxi.model.response.ErrorModel;
import com.flaviotps.muxi.model.domain.TerminalModel;
import com.flaviotps.muxi.repository.TerminalRepository;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalService {


    @Autowired
    TerminalRepository terminalRepository;

    public boolean validate(JSONObject obj) {
        try {
            SchemaLoader loader = SchemaLoader.builder()
                    .schemaJson(new JSONObject(Constants.JSON_SCHEMA))
                    .draftV6Support()
                    .build();
            Schema schema = loader.load().build();
            schema.validate(obj);
            return true;
        } catch (ValidationException e) {
            return false;
        }
    }

    public List<TerminalModel> findAll() {
        return terminalRepository.findAll();
    }

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


    public JSONObject save(String payload) {

        try {
            JSONObject jsonObject = parse(payload.toString());
            if (validate(jsonObject)) {
                ObjectMapper objectMapper = new ObjectMapper();
                TerminalModel terminalModel = objectMapper.readValue(jsonObject.toString(), TerminalModel.class);
                terminalRepository.save(terminalModel);
                return jsonObject;
            } else {
                return new ErrorModel(Constants.INVALID_JSON_SCHEMA);
            }

        } catch (Exception e) {
            return new ErrorModel(Constants.INVALID_PAYLOAD, e.getMessage().toString());
        }
    }

    public List<TerminalModel> findAllByLogic(int logic) {
        return terminalRepository.findAllByLogic(logic);
    }
}
