package com.cafem.CafeMenu.core.exception.exceptionhandler;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class ContactNotFoundException extends BaseBusinessException {
    public ContactNotFoundException(String message) {
        super(message);
    }
}
