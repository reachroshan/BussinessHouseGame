package com.evaluate.businesshouse.model.board;

import com.evaluate.businesshouse.exception.IncorrectInputException;
import com.evaluate.businesshouse.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dice {
    private Integer outcome;

    public void setOutcome(Integer outcome) throws IncorrectInputException {
        if(outcome < 1 || outcome > Constants.DICE_OUTCOME_MAX){
            throw new IncorrectInputException("incorrect Dice Outcome");
        }
        this.outcome = outcome;
    }
}
