package com.avijeet.contacts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avijeet.contacts.constants.HealthConstants;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping(HealthConstants.HEALTH_PING)
    public ResponseEntity<String> getMethodName() {
        return new ResponseEntity<>(HealthConstants.HEALTH_PONG, HttpStatus.OK);
    }

}
