package com.rofat.coronavirustracker.controllers;

import com.rofat.coronavirustracker.dto.CovidDTO;
import com.rofat.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/api/covid")
    public CovidDTO getNewCases() {
        return coronaVirusDataService.getNewCases();
    }
}
