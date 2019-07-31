package com.flaviotps.muxi.controller;

import com.flaviotps.muxi.domain.model.InitDTO;
import com.flaviotps.muxi.domain.model.Step1DTO;
import com.flaviotps.muxi.domain.model.Step1Form;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/api")
@Api(value = "TERMINAL API")
public class TerminalController {


    @PostMapping(value = {"/init"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public InitDTO init() {
        InitDTO initDTO = new InitDTO();
        initDTO.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIn0.dozjgNryP4J3jVmNHl0w5N_XgL0n3I9PlFUP0THsR8U");
        return initDTO;
    }


    @PostMapping(value = {"/step1"}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Step1DTO step1(@RequestBody @NotNull Step1Form body) {
        Step1DTO dto = new Step1DTO();
        dto.setAccount("124567");
        dto.setBcpfSessionId("KJK123");
        dto.setBcpfUrl("www.google.com");
        dto.setBranch("3877");
        dto.setCpf("312938129");
        dto.setDigit("2");
        dto.setHolder("1");
        return dto;

    }


}
