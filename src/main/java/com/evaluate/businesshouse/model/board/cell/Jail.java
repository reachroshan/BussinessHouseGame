package com.evaluate.businesshouse.model.board.cell;

import com.evaluate.businesshouse.model.actor.Bank;
import com.evaluate.businesshouse.model.actor.Player;
import com.evaluate.businesshouse.util.Constants;


public class Jail extends CellWithRule {

    public Jail() {
    }

    @Override
    public void applyCellRule(Player visitingPlayer) {

        if(visitingPlayer.getWallet().compareTo(Constants.JAIL_FINE)>=0){
            visitingPlayer.debitAccount(Constants.JAIL_FINE);
            Bank.creditBank(Constants.JAIL_FINE);
        }else{
            //TODO error
        }
    }
}
