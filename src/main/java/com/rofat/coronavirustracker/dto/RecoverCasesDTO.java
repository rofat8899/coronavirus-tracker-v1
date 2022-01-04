package com.rofat.coronavirustracker.dto;

import com.rofat.coronavirustracker.models.LocationStats;

public class RecoverCasesDTO {
    private String Country;
    private int TotalRecoverCases;
    private int NewRecoverCase;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getTotalRecoverCases() {
        return TotalRecoverCases;
    }

    public void setTotalRecoverCases(int totalRecoverCases) {
        TotalRecoverCases = totalRecoverCases;
    }

    public int getNewRecoverCase() {
        return NewRecoverCase;
    }

    public void setNewRecoverCase(int newRecoverCase) {
        NewRecoverCase = newRecoverCase;
    }

    public RecoverCasesDTO(LocationStats locationStats) {
        this.Country = locationStats.getCountry();
        this.TotalRecoverCases = locationStats.getLatestTotalCases();
        this.NewRecoverCase = locationStats.getDiffFromPrevDay();
    }
}
