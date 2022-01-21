package com.rofat.coronavirustracker.dto;

import com.rofat.coronavirustracker.models.LocationStats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CovidDTO {
    private Map<String, Object> confirmCase = new HashMap<>();
    private Map<String, Object> deathCase = new HashMap<>();
    private Map<String, Object> recoveredCase = new HashMap<>();

    public Map<String, Object> getConfirmCase() {
        return confirmCase;
    }

    public void setConfirmCase(Map<String, Object> confirmCase) {
        this.confirmCase = confirmCase;
    }

    public Map<String, Object> getDeathCase() {
        return deathCase;
    }

    public void setDeathCase(Map<String, Object> deathCase) {
        this.deathCase = deathCase;
    }

    public Map<String, Object> getRecoveredCase() {
        return recoveredCase;
    }

    public void setRecoveredCase(Map<String, Object> recoveredCase) {
        this.recoveredCase = recoveredCase;
    }

    public CovidDTO(List<LocationStats> confirmedCase, List<LocationStats> deathCase, List<LocationStats> recoveredCase) {
        String[] countries = {"Cambodia", "Thailand", "Vietnam", "Laos", "Singapore", "Brunei", "Malaysia", "Indonesia", "Philippines", "Burma"};
        for (LocationStats eachCase : confirmedCase) {
            for (String eachCountry : countries) {
                if (eachCase.getCountry().contains(eachCountry)) {
                    this.confirmCase.put(eachCase.getCountry(), new ConfirmCaseDTO(eachCase.getCountry(), eachCase.getLatestTotalCases(), eachCase.getDiffFromPrevDay()));
                }
            }
        }

        for (LocationStats eachCase : deathCase) {
            for (String eachCountry : countries) {
                if (eachCase.getCountry().contains(eachCountry)) {
                    this.deathCase.put(eachCase.getCountry(), new DeathCaseDTO(eachCase));
                }
            }
        }

        for (LocationStats eachCase : recoveredCase) {
            for (String eachCountry : countries) {
                if (eachCase.getCountry().contains(eachCountry)) {
                    this.recoveredCase.put(eachCase.getCountry(), new RecoverCasesDTO(eachCase));
                }
            }
        }
    }
}
