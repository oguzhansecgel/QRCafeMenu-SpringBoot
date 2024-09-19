package com.cafem.CafeMenu.core.exception.exceptionhandler;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class AboutNotFoundException extends BaseBusinessException {
    public AboutNotFoundException(String message) {
        super(message);
    }
}
