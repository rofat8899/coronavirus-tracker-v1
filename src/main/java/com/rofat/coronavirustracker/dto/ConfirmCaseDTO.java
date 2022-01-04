package com.rofat.coronavirustracker.dto;

import com.rofat.coronavirustracker.models.LocationStats;

public class ConfirmCaseDTO {
    private String Country;
    private int TotalConfirmedCases;
    private int NewConfirmedCase;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getTotalConfirmedCases() {
        return TotalConfirmedCases;
    }

    public void setTotalConfirmedCases(int totalConfirmedCases) {
        TotalConfirmedCases = totalConfirmedCases;
    }

    public int getNewConfirmedCase() {
        return NewConfirmedCase;
    }

    public void setNewConfirmedCase(int newConfirmedCase) {
        NewConfirmedCase = newConfirmedCase;
    }

    public ConfirmCaseDTO(LocationStats locationStats) {
        this.Country = locationStats.getCountry();
        this.TotalConfirmedCases = locationStats.getLatestTotalCases();
        this.NewConfirmedCase = locationStats.getDiffFromPrevDay();
    }
}
