package de.neuefische.covidcases.API;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService {

    private static final String API_URL="https://api.covid19api.com/country/germany";
    private final RestTemplate restTemplate=new RestTemplate();

    public APIModel[] getCovidApiCountryPerDay(){
        ResponseEntity<APIModel[]> response=restTemplate.getForEntity(API_URL, APIModel[].class);
        return response.getBody();
    }
}
