package com.evaluate.businesshouse.model.board.cell;

import com.evaluate.businesshouse.model.actor.Bank;
import com.evaluate.businesshouse.model.actor.Player;
import com.evaluate.businesshouse.util.Constants;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Jail extends CellWithRule {

    public Jail() {
    }

    @Override
    public void applyCellRule(Player visitingPlayer) {

        log.debug("Player {} visited Jail", visitingPlayer.getUserId());
        if(visitingPlayer.getWallet().compareTo(Constants.JAIL_FINE)>=0){
            visitingPlayer.debitAccount(Constants.JAIL_FINE);
            Bank.creditBank(Constants.JAIL_FINE);
        }else{
            log.error("Player {} doesn't have money to pay the Jail fine.");
        }
    }
}
