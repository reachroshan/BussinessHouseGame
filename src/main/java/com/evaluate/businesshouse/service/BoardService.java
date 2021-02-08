package com.evaluate.businesshouse.service;

import com.evaluate.businesshouse.model.board.Board;
import com.evaluate.businesshouse.model.board.cell.Cell;
import com.evaluate.businesshouse.model.board.cell.Hotel;
import com.evaluate.businesshouse.model.board.cell.Jail;
import com.evaluate.businesshouse.model.board.cell.Lottery;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class BoardService {

    /**
     * Use this method to build a Board object with the cell pattern provided as a comma separated string.
     * Pattern and input should be validated before using this.
     * @param cellPatternString String containing the cells of the board; as comma separated values.
     * @return board with the cells initialized to their respective type.
     */
    public static Board buildTheBoard(String cellPatternString){


        log.info("Building the Board for cell Pattern {}", cellPatternString);
        AtomicInteger counter = new AtomicInteger(1);
        Map<Integer, Cell> cells = Arrays.stream(cellPatternString.split(","))
                .map(s ->{
                    switch (s){
                        case "J" : return new Jail();
                        case "H" : return new Hotel();
                        case "L" : return new Lottery();
                        default: return new Cell();
                    }
                })
                .collect(Collectors.toMap(s -> counter.getAndIncrement(),  Function.identity()));

        return new Board(new HashMap<>(cells));
    }
}
