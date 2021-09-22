package de.neuefische.covidcases;

import de.neuefische.covidcases.API.Germany.APIService_Germany;
import de.neuefische.covidcases.Mapper.CasesPerDayMapper;
import de.neuefische.covidcases.Mapper.TotalCovidCasesMapper;
import de.neuefische.covidcases.Service.CovidCasesService_Germany;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidcasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidcasesApplication.class, args);

		TotalCovidCasesMapper mapper=new TotalCovidCasesMapper();
		APIService_Germany api=new APIService_Germany();
		CasesPerDayMapper dayMapper=new CasesPerDayMapper();

		CovidCasesService_Germany service = new CovidCasesService_Germany(dayMapper,mapper,api);

		service.getPermission();
		System.out.println();

	}


}
