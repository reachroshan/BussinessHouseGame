package com.evaluate.businesshouse.model.board.cell;

import com.evaluate.businesshouse.model.actor.Bank;
import com.evaluate.businesshouse.model.actor.Player;
import com.evaluate.businesshouse.util.Constants;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Lottery extends CellWithRule {

    @Override
    public void applyCellRule(Player visitingPlayer) {

        visitingPlayer.creditAccount(Constants.LOTTERY_PRICE);
        Bank.debitBank(Constants.LOTTERY_PRICE);

    }
}
