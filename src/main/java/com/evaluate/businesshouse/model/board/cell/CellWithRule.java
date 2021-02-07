package com.evaluate.businesshouse.model.board.cell;

import com.evaluate.businesshouse.model.actor.Player;

public class CellWithRule extends Cell implements ICellWithRule{

    @Override
    public void calculateCell(Player player){
        this.applyCellRule(player);
    }

    @Override
    public void applyCellRule(Player player) {

    }
}
