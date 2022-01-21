package com.rofat.coronavirustracker.controllers;

import com.rofat.coronavirustracker.dto.CovidDTO;
import com.rofat.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class HomeController {

    @Autowired
    private CoronaVirusDataService coronaVirusDataService;
    
    @ResponseBody
    @GetMapping("/api/covid")
    public ResponseEntity<CovidDTO>  getNewCases()  {
        try {
            CovidDTO covid = coronaVirusDataService.getNewCases();
            return new ResponseEntity<>(covid, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/message")
    public String getMessage(){
        return "hello world";
    }
}
