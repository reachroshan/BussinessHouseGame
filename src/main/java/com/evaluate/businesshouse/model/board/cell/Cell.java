package com.evaluate.businesshouse.model.board.cell;

import com.evaluate.businesshouse.model.actor.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell {

    private Integer position;
    private Character cellType;

    public void calculateCell(Player player){
        //TODO: Any cell level calculation
    }
}
