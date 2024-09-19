package com.cafem.CafeMenu.core.exception.exceptionhandler;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class CategoryNotFoundException extends BaseBusinessException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
