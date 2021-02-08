package com.evaluate.businesshouse.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IncorrectInputException extends Exception {
    public IncorrectInputException(String errorMessage) {
        super(errorMessage);
        log.error(errorMessage);
    }
}
