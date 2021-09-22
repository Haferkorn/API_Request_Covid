package de.neuefische.covidcases.Model;

public class ModelCasesPerDay {

    String date;
    long casesPerDay;

    public ModelCasesPerDay(String date, long casesPerDay) {
        this.date = date;
        this.casesPerDay = casesPerDay;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getCasesPerDay() {
        return casesPerDay;
    }

    public void setCasesPerDay(long casesPerDay) {
        this.casesPerDay = casesPerDay;
    }
}
