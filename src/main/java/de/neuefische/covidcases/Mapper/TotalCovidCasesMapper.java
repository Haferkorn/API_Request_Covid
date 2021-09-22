package de.neuefische.covidcases.Mapper;

import de.neuefische.covidcases.API.APIModel;
import de.neuefische.covidcases.Model.ModelTotalCovidCase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TotalCovidCasesMapper {

    public List<ModelTotalCovidCase> mapToConfirmedByDay(APIModel[] apiModels) {

        List<ModelTotalCovidCase> modelTotalCovidCaseList =new ArrayList<>();

        for(APIModel model : apiModels){
            ModelTotalCovidCase modelTotalCovidCase = new ModelTotalCovidCase(
                    model.getDate(),
                    model.getConfirmedCases()
            );
            modelTotalCovidCaseList.add(modelTotalCovidCase);
        }
        return modelTotalCovidCaseList;
    }
}
