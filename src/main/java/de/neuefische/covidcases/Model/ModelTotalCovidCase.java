package de.neuefische.covidcases.Model;

import java.util.Optional;

public class ModelTotalCovidCase {

    String date;
    long confirmedCases;
    String schoolingPermission="not defined";

    public ModelTotalCovidCase(String date, long confirmedCases) {
        this.date = date;
        this.confirmedCases = confirmedCases;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getConfirmedCases() {
        return confirmedCases;
    }

    public void setConfirmedCases(long confirmedCases) {
        this.confirmedCases = confirmedCases;
    }

    public String getSchoolingPermission() {
        return schoolingPermission;
    }

    public void setSchoolingPermission(String schoolingPermission) {
        this.schoolingPermission = schoolingPermission;
    }
}
