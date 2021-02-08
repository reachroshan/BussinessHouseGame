package com.evaluate.businesshouse.model.board.cell;


import com.evaluate.businesshouse.enums.HotelTypeEnum;
import com.evaluate.businesshouse.model.actor.Bank;
import com.evaluate.businesshouse.model.actor.Player;
import com.evaluate.businesshouse.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Slf4j
public class Hotel extends CellWithRule {

    private Player owner;
    private HotelTypeEnum hotelType ;

    public Hotel() {
        this.hotelType = HotelTypeEnum.SILVER;
    }

    @Override
    public void applyCellRule(Player visitingPlayer) {

      log.debug("Player {} is on cell of type hotel {}. It is Owned by {}", visitingPlayer.getUserId(), this.getHotelType().getType(),
              (null != this.owner)?this.owner.getUserId(): "none");
        if(null == this.owner){ // For a new visit to hotel type cell

            //When the user lands on hotel and has required money, he has to buy it by paying the bank the required money to buy a silver hotel
            if(visitingPlayer.getWallet().compareTo(this.hotelType.getValue()) >= 0){
                visitingPlayer.debitAccount(this.hotelType.getValue());
                visitingPlayer.getHotelsOwned().add(this);
                Bank.creditBank(this.hotelType.getValue());
                this.setOwner(visitingPlayer);
            }
        }else{ // Pay the rent to any exiting owner

            //when the user lands on it’s pre-owned hotel and has required money, the user needs to upgrade hotel
            if(visitingPlayer == this.owner){
                BigDecimal upgradeValue = upgradeAmount(this);
                if(upgradeValue.compareTo(BigDecimal.ZERO) > 0 && upgradeValue.compareTo(visitingPlayer.getWallet()) <0 ){
                    visitingPlayer.debitAccount(upgradeValue);
                    Bank.creditBank(upgradeValue);
                    upgradeHotel(this);
                }

            }else{
                // when any other user lands on a pre-owned hotel, the user needs to pay rent as per hotel state
                visitingPlayer.debitAccount(this.getHotelType().getRent());
                this.owner.creditAccount(this.hotelType.getRent());
            }
        }
    }

    /**
     * Use this method upgrade hotel to higher value type. For now, from Silver to Gold OR Gold to Platinum.
     * @param hotel
     */
    private void upgradeHotel(Hotel hotel){
        if(hotel.getHotelType().equals(HotelTypeEnum.SILVER)){
            hotel.setHotelType(HotelTypeEnum.GOLD);
        }else if(hotel.getHotelType().equals(HotelTypeEnum.GOLD)){
            hotel.setHotelType(HotelTypeEnum.PLATINUM);
        }

    }

    /**
     * use this method determine the upgrade value of a hotel.
     * @param hotel hotel type whose upgrade value is to be determined,
     * @return upgrade value of the hotel type.
     */
    private BigDecimal upgradeAmount(Hotel hotel){
        if(hotel.getHotelType().equals(HotelTypeEnum.SILVER)){
            return Constants.HOTEL_UPGRADE_VALUE_GOLD;
        }else if(hotel.getHotelType().equals(HotelTypeEnum.GOLD)){
            return Constants.HOTEL_UPGRADE_VALUE_PLATINUM;
        }

        return BigDecimal.ZERO;
    }
}
