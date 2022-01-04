package com.rofat.coronavirustracker.dto;

import com.rofat.coronavirustracker.models.LocationStats;

public class DeathCaseDTO {
    private String Country;
    private int TotalDeathCases;
    private int NewDeathCase;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getTotalDeathCases() {
        return TotalDeathCases;
    }

    public void setTotalDeathCases(int totalDeathCases) {
        TotalDeathCases = totalDeathCases;
    }

    public int getNewDeathCase() {
        return NewDeathCase;
    }

    public void setNewDeathCase(int newDeathCase) {
        NewDeathCase = newDeathCase;
    }
    public DeathCaseDTO(LocationStats locationStats) {
        this.Country = locationStats.getCountry();
        this.TotalDeathCases = locationStats.getLatestTotalCases();
        this.NewDeathCase = locationStats.getDiffFromPrevDay();
    }
}
