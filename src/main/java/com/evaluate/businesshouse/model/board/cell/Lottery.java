package com.evaluate.businesshouse.model.board.cell;

import com.evaluate.businesshouse.model.actor.Bank;
import com.evaluate.businesshouse.model.actor.Player;
import com.evaluate.businesshouse.util.Constants;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class Lottery extends CellWithRule {

    @Override
    public void applyCellRule(Player visitingPlayer) {

        log.debug("Player {} hit the jackpot", visitingPlayer.getUserId());
        visitingPlayer.creditAccount(Constants.LOTTERY_PRICE);
        Bank.debitBank(Constants.LOTTERY_PRICE);

    }
}
