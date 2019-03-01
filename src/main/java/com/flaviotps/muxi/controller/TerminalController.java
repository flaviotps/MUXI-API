package com.flaviotps.muxi.controller;

import com.flaviotps.muxi.Util.Constants;
import com.flaviotps.muxi.domain.model.TerminalModel;
import com.flaviotps.muxi.service.TerminalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/rest/api/v1")
@Api(value = "TERMINAL API")
public class TerminalController {

    @Autowired
    TerminalService terminalService;

    @ApiOperation(Constants.API_GET_ALL)
    @GetMapping(value = {"/terminal"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<TerminalModel> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        return terminalService.findAll(page, size);
    }
    
    
    
    )
    @GetMapping(value = {"/test"})
    @ResponseStatus(HttpStatus.OK)
    public String TestScopus() {
        return "TEST";
    }

    @ApiOperation(Constants.API_GET)
    @GetMapping(value = {"/terminal/{logic}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public TerminalModel findAllByLogic(@PathVariable("logic") int logic) {
        return terminalService.findAllByLogic(logic);
    }


    @ApiOperation(Constants.API_UPDATE)
    @PutMapping(value = {"/terminal/{logic}"}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestBody @Valid @NotNull TerminalModel terminalModel, @PathVariable("logic") int logic) {
        return terminalService.update(terminalModel, logic);
    }

    @ApiOperation(Constants.API_CREATE)
    @PostMapping(value = {"/terminal"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody @NotNull String body) {
        return terminalService.save(body);
    }


}
