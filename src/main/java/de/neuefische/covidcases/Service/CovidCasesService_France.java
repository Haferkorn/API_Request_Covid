package de.neuefische.covidcases.Service;

import de.neuefische.covidcases.API.APIModel;
import de.neuefische.covidcases.API.France.APIService_France;
import de.neuefische.covidcases.Mapper.CasesPerDayMapper;
import de.neuefische.covidcases.Mapper.TotalCovidCasesMapper;
import de.neuefische.covidcases.Model.ModelCasesPerDay;
import de.neuefische.covidcases.Model.ModelTotalCovidCase;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ModelTotalCovidCase> getFrenchCasesPerDay(){
        APIModel[] apiModels=apiService_france.getCovidApiCountryPerDay();
        return totalCovidCasesMapper.mapToConfirmedByDay(apiModels);
    }



}
