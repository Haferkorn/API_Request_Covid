package de.neuefische.covidcases.Service;

import de.neuefische.covidcases.API.France.APIService_France;
import de.neuefische.covidcases.Mapper.CasesPerDayMapper;
import de.neuefische.covidcases.Mapper.TotalCovidCasesMapper;
import org.springframework.stereotype.Service;

@Service
public class CovidCasesService_France {
    TotalCovidCasesMapper totalCovidCasesMapper;
    CasesPerDayMapper casesPerDayMapper;
    APIService_France apiService_france;

    public CovidCasesService_France(TotalCovidCasesMapper totalCovidCasesMapper, CasesPerDayMapper casesPerDayMapper, APIService_France apiService_france) {
        this.totalCovidCasesMapper = totalCovidCasesMapper;
        this.casesPerDayMapper = casesPerDayMapper;
        this.apiService_france = apiService_france;
    }


}
