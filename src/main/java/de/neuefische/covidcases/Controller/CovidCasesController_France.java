package de.neuefische.covidcases.Controller;

import de.neuefische.covidcases.Model.ModelCasesPerDay;
import de.neuefische.covidcases.Model.ModelTotalCovidCase;
import de.neuefische.covidcases.Service.CovidCasesService_France;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("covidCases/France")
public class CovidCasesController_France {

    private final CovidCasesService_France covidCasesService_france;

    @Autowired
    public CovidCasesController_France(CovidCasesService_France covidCasesService_france) {
        this.covidCasesService_france = covidCasesService_france;
    }

    @GetMapping
    public List<ModelTotalCovidCase>getAllFrenchConfirmedCases(){
        return covidCasesService_france.getFrenchConfirmedCases();
    }

    @GetMapping("actualperDay")
    public List<ModelCasesPerDay>getFrenchCasesPerDay(){
        return covidCasesService_france.getFrenchCasesPerDay();
    }

}
