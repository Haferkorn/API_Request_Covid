package de.neuefische.covidcases;

import de.neuefische.covidcases.API.APIService;
import de.neuefische.covidcases.Mapper.CasesPerDayMapper;
import de.neuefische.covidcases.Mapper.TotalCovidCasesMapper;
import de.neuefische.covidcases.Service.CovidCasesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidcasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidcasesApplication.class, args);

		TotalCovidCasesMapper mapper=new TotalCovidCasesMapper();
		APIService api=new APIService();
		CasesPerDayMapper dayMapper=new CasesPerDayMapper();

		CovidCasesService service = new CovidCasesService(dayMapper,mapper,api);

		service.getPermission();
		System.out.println();

	}


}
