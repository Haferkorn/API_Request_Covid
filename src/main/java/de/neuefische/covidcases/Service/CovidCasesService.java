package de.neuefische.covidcases.Service;

import de.neuefische.covidcases.API.APIModel;
import de.neuefische.covidcases.API.Germany.APIService_Germany;
import de.neuefische.covidcases.Mapper.CasesPerDayMapper;
import de.neuefische.covidcases.Mapper.TotalCovidCasesMapper;
import de.neuefische.covidcases.Model.ModelCasesPerDay;
import de.neuefische.covidcases.Model.ModelTotalCovidCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidCasesService {
    private CasesPerDayMapper casesPerDayMapper;
    private TotalCovidCasesMapper totalCovidCasesMapper;
    private APIService_Germany apiServiceGermany;


    public CovidCasesService(CasesPerDayMapper casesPerDayMapper, TotalCovidCasesMapper totalCovidCasesMapper, APIService_Germany apiServiceGermany) {
        this.casesPerDayMapper = casesPerDayMapper;
        this.totalCovidCasesMapper = totalCovidCasesMapper;
        this.apiServiceGermany = apiServiceGermany;
    }

    public List<ModelTotalCovidCase> getConfirmedCases(){
        APIModel[] apiModels = apiServiceGermany.getCovidApiCountryPerDay();
        return totalCovidCasesMapper.mapToConfirmedByDay(apiModels);
    }

    public List<ModelCasesPerDay> getConfirmedCasesPerDay(){
        APIModel[] apiModels = apiServiceGermany.getCovidApiCountryPerDay();
        return casesPerDayMapper.mapAPIDataInModelPerDay(apiModels);
    }

    public List<ModelTotalCovidCase> getPermission(){
        List<ModelTotalCovidCase> cases=getConfirmedCases();
        long alert=8000;
        for(int i=0; i<cases.size()-1; i++){
            long actualCases=cases.get(i+1).getConfirmedCases()-cases.get(i).getConfirmedCases();
            if(actualCases>alert){
                /*System.out.println("On day "
                                +cases.get(i).getDate()
                                +". Schooling was impossible because of "
                                +actualCases
                                +" infections"
                        );*/
                cases.get(i).setSchoolingPermission("Distance learning");

            }else{
                cases.get(i).setSchoolingPermission("schooling possible");
            }
        }return cases;

    }




}
