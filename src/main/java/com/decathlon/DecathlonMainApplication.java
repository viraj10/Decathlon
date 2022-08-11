package com.decathlon;

import com.decathlon.input.CSVInputService;
import com.decathlon.input.InputService;
import com.decathlon.model.Athlete;
import com.decathlon.model.AthleteResult;
import com.decathlon.output.FileWriter;
import com.decathlon.output.ResultCreator;
import com.decathlon.output.SharedRankResultCreator;
import com.decathlon.output.XmlWriter;
import com.decathlon.reader.SimpleFileReader;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

public class DecathlonMainApplication {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Running DecathlonMainApplication with args: " + args);
        String defaultInputPath = Paths.get(SimpleFileReader.class.getResource("/results.csv").toURI()).toAbsolutePath().toString();
        String defaultOutputPath = Paths.get(SimpleFileReader.class.getResource("/decathlon_assignment_result.xml").toURI()).toAbsolutePath().toString();
        if(args.length >= 2) {
            defaultInputPath = args[0];
            defaultOutputPath = args[1];
        }
        InputService inputService = new CSVInputService(new SimpleFileReader());
        List<Athlete> athletes = inputService.readInput(defaultInputPath);
        ResultCreator resultCreator = new SharedRankResultCreator();
        List<AthleteResult> results = resultCreator.createResults(athletes);
        FileWriter fileWriter = new XmlWriter();
        fileWriter.writeFile(results, defaultOutputPath);
        System.out.println("Completed DecathlonMainApplication");
    }

}
