package com.cafem.CafeMenu.core.exception.exceptionhandler;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class FoodNotFoundException extends BaseBusinessException {


    public FoodNotFoundException(String message) {
        super(message);
    }
}