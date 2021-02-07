package com.evaluate.businesshouse.util;

import com.evaluate.businesshouse.exception.IncorrectInputException;

public class BusinessUtil {

    public static void validateInput(String diceOutput, String cellPatternString, Integer numberOfPlayers) throws IncorrectInputException {
        if(numberOfPlayers <= 1){
            throw new IncorrectInputException("Number of Players cannot be less than 2");
        }
        if(diceOutput.split(",").length%numberOfPlayers != 0){
            throw new IncorrectInputException("Number of dice rolled do not match for the number of players.");
        }

    }
}
