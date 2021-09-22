package de.neuefische.covidcases.Service;

import de.neuefische.covidcases.API.APIModel;
import de.neuefische.covidcases.API.APIService;
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
    private APIService apiService;


    public CovidCasesService(CasesPerDayMapper casesPerDayMapper, TotalCovidCasesMapper totalCovidCasesMapper, APIService apiService) {
        this.casesPerDayMapper = casesPerDayMapper;
        this.totalCovidCasesMapper = totalCovidCasesMapper;
        this.apiService = apiService;
    }

    public List<ModelTotalCovidCase> getConfirmedCases(){
        APIModel[] apiModels = apiService.getCovidApiCountryPerDay();
        return totalCovidCasesMapper.mapToConfirmedByDay(apiModels);
    }

    public List<ModelCasesPerDay> getConfirmedCasesPerDay(){
        APIModel[] apiModels = apiService.getCovidApiCountryPerDay();
        return casesPerDayMapper.mapAPIDataInModelPerDay(apiModels);
    }

    public List<ModelTotalCovidCase> getPermission(){
        List<ModelTotalCovidCase> cases= getConfirmedCases();
        long alert=8000;
        for(int i=0; i<cases.size()-1; i++){
            long actualCases=cases.get(i+1).getConfirmedCases()-cases.get(i).getConfirmedCases();
            if(actualCases>alert){
                System.out.println("On day "
                                +cases.get(i).getDate()
                                +". Schooling was impossible because of "
                                +actualCases
                                +" infections"
                        );
                cases.get(i).setSchoolingPermission("Distance learning");

            }else{
                cases.get(i).setSchoolingPermission("schooling possible");
            }
        }return cases;

    }




}
