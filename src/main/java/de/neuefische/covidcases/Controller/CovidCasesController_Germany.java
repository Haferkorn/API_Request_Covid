package de.neuefische.covidcases.Controller;

import de.neuefische.covidcases.Model.ModelCasesPerDay;
import de.neuefische.covidcases.Model.ModelTotalCovidCase;
import de.neuefische.covidcases.Service.CovidCasesService_Germany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("covidCases/Germany")
public class CovidCasesController_Germany {

    private final CovidCasesService_Germany covidCasesServiceGermany;

    @Autowired
    public CovidCasesController_Germany(CovidCasesService_Germany covidCasesServiceGermany) {
        this.covidCasesServiceGermany = covidCasesServiceGermany;
    }

    @GetMapping
    public List<ModelTotalCovidCase> getAllConfirmedCases() {
        return covidCasesServiceGermany.getConfirmedCases();
    }
    @GetMapping("permission")
    public List<ModelTotalCovidCase> getSchoolingPermission(){
        return covidCasesServiceGermany.getPermission();
    }
    @GetMapping("actualCasesByDay")
    public List<ModelCasesPerDay> getCasesByDay(){
        return covidCasesServiceGermany.getConfirmedCasesPerDay();
    }



}
