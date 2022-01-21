package com.rofat.coronavirustracker.dto;

public class ConfirmCaseDTO {
    private String name;
    private int TotalConfirmedCases;
    private int NewConfirmedCase;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConfirmCaseDTO(String name, int totalConfirmedCases, int newConfirmedCase) {
        this.name = name;
        TotalConfirmedCases = totalConfirmedCases;
        NewConfirmedCase = newConfirmedCase;
    }
}
