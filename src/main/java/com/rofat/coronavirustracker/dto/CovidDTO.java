package com.rofat.coronavirustracker.dto;

import com.rofat.coronavirustracker.models.LocationStats;

import java.util.ArrayList;
import java.util.List;

public class CovidDTO {
    private List<ConfirmCaseDTO> confirmedCase;
    private List<DeathCaseDTO> deathCase;
    private List<RecoverCasesDTO> recoveredCase;
    public List<ConfirmCaseDTO> getConfirmedCase() {
        return confirmedCase;
    }

    public List<DeathCaseDTO> getDeathCase() {
        return deathCase;
    }

    public List<RecoverCasesDTO> getRecoveredCase() {
        return recoveredCase;
    }

    public CovidDTO(List<LocationStats> confirmedCase, List<LocationStats> deathCase, List<LocationStats> recoveredCase) {
        String[] countries={"Cambodia","Thailand","Vietnam","Laos","Singapore","Brunei","Malaysia","Indonesia","Philippines","Burma"};
        List<ConfirmCaseDTO> finalConfirmCase = new ArrayList<>();
        for (LocationStats eachCase : confirmedCase) {
            for(String eachCountry : countries) {
                if (eachCase.getCountry().contains(eachCountry)) {
                    ConfirmCaseDTO eachConfirmCase = new ConfirmCaseDTO(eachCase);
                    finalConfirmCase.add(eachConfirmCase);
                }
            }
        }
        this.confirmedCase = finalConfirmCase;

        List<DeathCaseDTO> finalDeathCase = new ArrayList<>();
        for (LocationStats eachCase : deathCase) {
            for(String eachCountry : countries){
                if(eachCase.getCountry().contains(eachCountry)){
                    DeathCaseDTO eachDeathCase = new DeathCaseDTO(eachCase);
                    finalDeathCase.add(eachDeathCase);
                }
            }
        }
        this.deathCase = finalDeathCase;

        List<RecoverCasesDTO> finalRecoveredCase = new ArrayList<>();
        for (LocationStats eachCase : recoveredCase) {
            for(String eachCountry : countries){
                if(eachCase.getCountry().contains(eachCountry)){
                    RecoverCasesDTO eachRecoveredCase = new RecoverCasesDTO(eachCase);
                    finalRecoveredCase.add(eachRecoveredCase);
                }
            }
        }
        this.recoveredCase = finalRecoveredCase;
    }
}
