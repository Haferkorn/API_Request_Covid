package de.neuefische.covidcases.Controller;

import de.neuefische.covidcases.Model.ModelCasesPerDay;
import de.neuefische.covidcases.Model.ModelTotalCovidCase;
import de.neuefische.covidcases.Service.CovidCasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("covidCases")
public class CovidCasesController {

    private final CovidCasesService covidCasesService;

    @Autowired
    public CovidCasesController(CovidCasesService covidCasesService) {
        this.covidCasesService = covidCasesService;
    }

    @GetMapping
    public List<ModelTotalCovidCase> getAllConfirmedCases() {
        return covidCasesService.getConfirmedCases();
    }
    @GetMapping("permission")
    public List<ModelTotalCovidCase> getSchoolingPermission(){
        return covidCasesService.getPermission();
    }
    @GetMapping("actualCasesByDay")
    public List<ModelCasesPerDay> getCasesByDay(){
        return covidCasesService.getConfirmedCasesPerDay();
    }


}
