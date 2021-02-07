package com.evaluate.businesshouse.enums;

import com.evaluate.businesshouse.util.Constants;

import java.math.BigDecimal;

public enum HotelTypeEnum {
    SILVER("SILVER", Constants.VALUE_SILVER, Constants.RENT_SILVER),
    GOLD("GOLD",Constants.VALUE_GOLD, Constants.RENT_GOLD),
    PLATINUM("PLATINUM",Constants.VALUE_PLATINUM, Constants.RENT_PLATINUM);

    private String Type;
    private BigDecimal value;
    private BigDecimal rent;


    HotelTypeEnum(String type, BigDecimal value, BigDecimal rent) {
        Type = type;
        this.value = value;
        this.rent = rent;
    }

    public String getType() {
        return Type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getRent() {
        return rent;
    }
}
