package com.evaluate.businesshouse;

import com.evaluate.businesshouse.exception.IncorrectInputException;
import com.evaluate.businesshouse.model.Game;
import com.evaluate.businesshouse.model.actor.Player;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class GameServiceTest {

    GameService gameService;
    @Before
    public void setUp() throws Exception {
        gameService = new GameService();
    }

    @Test
    public void test_InputOne_potive_outcome() throws IncorrectInputException {

        Game game = gameService.playGame( "2,2,1, 4,4,2, 4,4,2, 2,2,1, 4,4,2, 4,4,2, 2,2,1" , "J,H,L,H,E,L,H,L,H,J", 3 );
        List<Player> players = game.getPlayers();
        assertEquals(BigDecimal.valueOf(1100), players.get(0).getWallet());
        assertEquals(BigDecimal.valueOf(600), players.get(1).getWallet());
        assertEquals(BigDecimal.valueOf(1150), players.get(2).getWallet());
    }

    @Test
    public void test_InputTwo_potive_outcome() throws IncorrectInputException {

        Game game = gameService.playGame( "2,2,1, 4,2,3, 4,1,3, 2,2,7, 4,7,2, 4,4,2, 2,2,2"  , "J,H,L,H,E,L,H,L,H,J", 3 );
        List<Player> players = game.getPlayers();
        assertEquals(BigDecimal.valueOf(650), players.get(0).getWallet());
        assertEquals(BigDecimal.valueOf(750), players.get(1).getWallet());
        assertEquals(BigDecimal.valueOf(850), players.get(2).getWallet());
    }

    @Test(expected = NumberFormatException.class)
    public void WhenIncorrectDiceOutPut_ThenThrowException() throws IncorrectInputException {

        Game game = gameService.playGame( "2,2,1, 4,2,3, 4,1,3, 2,2,7, 4,7,2, 4,4,K, 2,2,2"  , "J,H,L,H,E,L,H,L,H,J", 3 );
        List<Player> players = game.getPlayers();
        assertEquals(BigDecimal.valueOf(650), players.get(0).getWallet());
        assertEquals(BigDecimal.valueOf(750), players.get(1).getWallet());
        assertEquals(BigDecimal.valueOf(850), players.get(2).getWallet());
    }

    @Test(expected = IncorrectInputException.class)
    public void WhenIncorrectNumberOfPlayers_ThenThrowException() throws IncorrectInputException {

        Game game = gameService.playGame( "2,2,1, 4,2,3, 4,1,3, 2,2,7, 4,7,2, 4,4,2, 2,2,2"  , "J,H,L,H,E,L,H,L,H,J", 1 );

    }

    @Test(expected = IncorrectInputException.class)
    public void WhenNumberOfPlayers_Negative_ThenThrowException() throws IncorrectInputException {

        Game game = gameService.playGame( "2,2,1, 4,2,3, 4,1,3, 2,2,7, 4,7,2, 4,4,2, 2,2,2"  , "J,H,L,H,E,L,H,L,H,J", -11 );


    }

    @Test(expected = IncorrectInputException.class)
    public void WhenIncorrectDiceOutcome_ThenThrowException() throws IncorrectInputException {

        Game game = gameService.playGame( "22,2,1, 4,2,3, 4,1,3, 2,2,7, 4,7,2, 4,4,2, 2,2,2"  , "J,H,L,H,E,L,H,L,H,J", -11 );

    }
}