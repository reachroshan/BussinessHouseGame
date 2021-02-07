package com.evaluate.businesshouse.model;

import com.evaluate.businesshouse.model.actor.Player;
import com.evaluate.businesshouse.model.board.Board;
import com.evaluate.businesshouse.model.board.Dice;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Game {

    private List<Player> players;
    private Board board;
    private List<Dice> dice;
    private Integer numberOfPlayers;

    public Game() {
        this.players = new ArrayList<>();
        this.board = new Board();
    }

    public void play(){
        Integer diceRoll = 0;
        for(int numOfChances = 1; numOfChances <= this.getDice().size()/numberOfPlayers; numOfChances ++){
            for (int i = 0; i < numberOfPlayers; i++) {
                this.getBoard().playDice( this.getPlayers().get(i), this.getDice().get(diceRoll++));
            }
        }
    }


}
