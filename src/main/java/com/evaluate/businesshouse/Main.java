package com.evaluate.businesshouse;


import com.evaluate.businesshouse.exception.IncorrectInputException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IncorrectInputException {
	// write your code here

        
       String inFile= "";
        if (0 < args.length) {
             inFile = args[0];
        }
//TODO : add validation
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        // read as a file
        File file = new File(classloader.getResource(inFile).getFile());
        Map<String, String> inputData;
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(file.toPath())) {

            inputData = stream
                    .map(s -> s.split("="))
                    .collect(Collectors.toMap(s ->s[0], s->s[1]));

            //TODO : add validation for inputData

            if(null == inputData.get("DiceOutput") ||null == inputData.get("CellsPattern") ||null == inputData.get("Players") ){
                throw new IncorrectInputException("The provided input is not in the right format. Right Format is -");
            }
             GameService gameService = new GameService();
             gameService.playGame(inputData.get("DiceOutput"),  inputData.get("CellsPattern") , Integer.valueOf(inputData.get("Players").trim()) );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
