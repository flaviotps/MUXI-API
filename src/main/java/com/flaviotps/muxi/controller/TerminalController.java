package com.flaviotps.muxi.controller;

import com.flaviotps.muxi.domain.model.TerminalModel;
import com.flaviotps.muxi.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/rest/api/v1")
public class TerminalController {

    @Autowired
    TerminalService terminalService;

    @GetMapping(value = {"/terminal"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<TerminalModel> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        return terminalService.findAll(page, size);
    }

    @GetMapping(value = {"/terminal/{logic}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public TerminalModel findAllByLogic(@PathVariable("logic") int logic) {
        return terminalService.findAllByLogic(logic);
    }

    @PutMapping(value = {"/terminal/{logic}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestBody @Valid TerminalModel terminalModel, @PathVariable("logic") int logic) {
        return terminalService.update(terminalModel, logic);
    }


    @PostMapping(value = {"/terminal"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody @NotNull String body) {
        return terminalService.save(body);
    }


}
