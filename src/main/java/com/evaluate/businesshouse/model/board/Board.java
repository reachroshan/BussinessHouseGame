package com.evaluate.businesshouse.model.board;

import com.evaluate.businesshouse.model.board.cell.Cell;
import com.evaluate.businesshouse.model.actor.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    HashMap<Integer, Cell> cells;

    public void playDice(Player player, Dice dice){

        Integer positionOnBoard = player.getCurrentBoardPosition() + dice.getOutcome();
        if(positionOnBoard > cells.size()){
            positionOnBoard = positionOnBoard % cells.size();
        }
        player.setCurrentBoardPosition(positionOnBoard);
        if(positionOnBoard != 0) {
            this.getCells().get(positionOnBoard).calculateCell(player);
        }


    }

}
