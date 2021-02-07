package com.evaluate.businesshouse.model.actor;

import com.evaluate.businesshouse.util.Constants;

import java.math.BigDecimal;

public class Bank{

    private static BigDecimal bankCash = Constants.BANK_INITIAL_MONEY;

    public static BigDecimal getBankCash() {
        return bankCash;
    }

    public static void debitBank(BigDecimal amount) {
        bankCash = bankCash.subtract(amount);
    }

    public static void creditBank(BigDecimal amount) {

        bankCash = bankCash.add(amount);
    }


}
