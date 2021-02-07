package com.evaluate.businesshouse;

import com.evaluate.businesshouse.exception.IncorrectInputException;
import com.evaluate.businesshouse.model.Game;
import com.evaluate.businesshouse.model.actor.Bank;
import com.evaluate.businesshouse.model.actor.Player;
import com.evaluate.businesshouse.model.board.Dice;
import com.evaluate.businesshouse.util.BusinessUtil;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameService {


    public Game playGame(String diceOutput, String cellPatternString, Integer numberOfPlayers) throws IncorrectInputException {

        BusinessUtil.validateInput(diceOutput,  cellPatternString, numberOfPlayers);

        Game game = initializeGame(diceOutput,  cellPatternString, numberOfPlayers);
        game.play();
        declareResult(game);

        return game;


    }

    /**
     * This method initializes the game by reading the cellPatternString, diceOutput and number of players - which are provided as inout to this game.
     * @param diceOutput String containing the dice outcome as rolled by players.
     * @param cellPatternString String containing the cells of the board; as comma separated
     * @param numberOfPlayers number of players participating in the game
     * @return Initialized game object
     */
    private Game initializeGame(String diceOutput, String cellPatternString, Integer numberOfPlayers){

        Game game = new Game();
        game.setBoard(BoardService.buildTheBoard(cellPatternString));
        game.setDice(buildPlayerDiceRoll(diceOutput));
        game.setNumberOfPlayers(numberOfPlayers);
        for (int iterator = 1; iterator <= numberOfPlayers; iterator++) {
            Player player = new Player();
            player.setUserId(iterator);
            game.getPlayers().add(player);
        }

        return game;
    }

    /**
     * This method converts the dice pattern, which is provided as a string, to List of Dice.
     * @param diceOutput String containing the dice outcome as rolled by players.
     * @return list of die's rolled.
     */
    private List<Dice> buildPlayerDiceRoll(String diceOutput){
        return Stream.of(diceOutput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Dice::new)
                .collect(Collectors.toList());
    }

    /**
     * This method prints the result, according to requirement.
     * @param game A completed business game object
     */
    private void declareResult(Game game){

        System.out.println("Game is complete");
        int playerNumber = 0;
        for(Player player: game.getPlayers()){
            playerNumber++;
            System.out.println("Player "+ playerNumber +" has total money :"+ player.getWallet());
        }
        System.out.println("Balance at Bank: "+ Bank.getBankCash());
        System.out.println("Winner is " + decideTheWinner(game).getUserId());
    }

    /**
     * This method gives back the player who has the most money in his/her wallet.
     * @param game A completed business game object
     * @return Winner of the game
     */
    private Player decideTheWinner(Game game){

        return game.getPlayers()
                .stream()
                .max(Comparator.comparing(Player::getWallet)).get();

    }
}
