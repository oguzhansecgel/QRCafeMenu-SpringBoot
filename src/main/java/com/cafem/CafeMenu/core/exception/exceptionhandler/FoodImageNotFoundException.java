package com.cafem.CafeMenu.core.exception.exceptionhandler;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class FoodImageNotFoundException extends BaseBusinessException {
    public FoodImageNotFoundException(String message) {
        super(message);
    }
}
