package de.neuefische.covidcases.Mapper;

import de.neuefische.covidcases.API.APIModel;
import de.neuefische.covidcases.Model.ModelCasesPerDay;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasesPerDayMapper {
    public List<ModelCasesPerDay> mapAPIDataInModelPerDay(APIModel[] apiModels) {
        List<ModelCasesPerDay> casesPerDayList = new ArrayList<>();

        for(int i=0; i<apiModels.length-1; i++) {
            ModelCasesPerDay casePerDay = new ModelCasesPerDay(
                    apiModels[i].getDate(),
                    apiModels[i+1].getConfirmedCases()-apiModels[i].getConfirmedCases()
            );
            casesPerDayList.add(casePerDay);
        }return casesPerDayList;
    }

}

