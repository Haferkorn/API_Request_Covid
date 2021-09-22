package de.neuefische.covidcases.API;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIModel {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Confirmed")
    private long confirmedCases;


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


}
