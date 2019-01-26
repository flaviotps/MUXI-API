package com.flaviotps.muxi.controller;

import com.flaviotps.muxi.model.domain.TerminalModel;
import com.flaviotps.muxi.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class TerminalController {

    @Autowired
    TerminalService terminalService;

    @GetMapping(value = {"/v1/terminal"})
    @ResponseStatus(HttpStatus.OK)
    public List<TerminalModel> getAll() {
        return terminalService.findAll();
    }


    @GetMapping(value = {"/v1/terminal/{logic}"})
    @ResponseStatus(HttpStatus.OK)
    public List<TerminalModel> findAllyLogic(@PathVariable("logic") int logic) {
        return terminalService.findAllByLogic(logic);
    }


    @PostMapping(value = "/v1/terminal", consumes = {"text/html; charset=utf-8"})
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody String body) {
        return terminalService.save(body).toString();
    }


}
