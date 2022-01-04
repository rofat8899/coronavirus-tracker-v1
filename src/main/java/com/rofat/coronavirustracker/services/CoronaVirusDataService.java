package com.rofat.coronavirustracker.services;

import com.rofat.coronavirustracker.dto.ConfirmCaseDTO;
import com.rofat.coronavirustracker.dto.CovidDTO;
import com.rofat.coronavirustracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {

    List<LocationStats> ConfirmedCase = new ArrayList<>();
    List<LocationStats> DeathCase = new ArrayList<>();
    List<LocationStats> RecoveredCase = new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "* * * 1 * *")
    public void fetchConfirmedCase() throws IOException, InterruptedException {
        String NEW_VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
        fetchVirusData(NEW_VIRUS_DATA_URL,"confirm");
    }

    @PostConstruct
    @Scheduled(cron = "* * * 1 * *")
    public void fetchDeathCase() throws IOException, InterruptedException {
        String NEW_VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
        fetchVirusData(NEW_VIRUS_DATA_URL,"death");
    }

    @PostConstruct
    @Scheduled(cron = "* * * 1 * *")
    public void fetchRecoveredCase() throws IOException, InterruptedException {
        String NEW_VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";
        fetchVirusData(NEW_VIRUS_DATA_URL,"recover");
    }

    public void fetchVirusData(String url,String data) throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStats = new LocationStats();
            locationStats.setState(record.get("Province/State"));
            locationStats.setCountry(record.get("Country/Region"));
            int latestCases = Integer.parseInt(record.get(record.size()-1));
            int prevDayCases =Integer.parseInt(record.get(record.size()-2));
            locationStats.setLatestTotalCases(latestCases);
            locationStats.setDiffFromPrevDay(latestCases - prevDayCases);
            newStats.add(locationStats);
        }
        if(data.contains("confirm")){
            this.ConfirmedCase = newStats;
        }
        else if(data.contains("death"))
        {
            this.DeathCase = newStats;
        }
        else if(data.contains("recover"))
        {
            this.RecoveredCase= newStats;
        }
    }

    public CovidDTO getNewCases() {
        return new CovidDTO(ConfirmedCase,DeathCase,RecoveredCase);
    }
}
