package com.evaluate.businesshouse.model.actor;

import com.evaluate.businesshouse.model.board.cell.Hotel;
import com.evaluate.businesshouse.util.Constants;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
public class Player extends User {

    private int currentBoardPosition;
    private List<Hotel> hotelsOwned;
    private BigDecimal asset;
    private BigDecimal wallet;

    public Player() {
        this.setWallet(Constants.PLAYER_INITIAL_MONEY);
        currentBoardPosition = 0;
        hotelsOwned = new ArrayList<>();
    }

    /**
     * This method debits players account @amount value
     * @param debitAmount Amount to be debited form the player.
     */
    public void debitAccount(BigDecimal debitAmount){
        if(this.getWallet().compareTo(debitAmount) < 0){
            //TODO Handle exception
           log.warn("User {} Ran out of money. We got to think what to do now ??", this.getUserId() );
        }else{
            BigDecimal newWalletAmount = this.getWallet().subtract(debitAmount);
            this.setWallet(newWalletAmount);
        }

    }

    /**
     * This method credits players account @amount value
     * @param creditAmount Amount to be credited to the player.
     */
    public void creditAccount(BigDecimal creditAmount){
            this.setWallet(this.getWallet().add(creditAmount));
    }

}
