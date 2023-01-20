package org.triggerise.checkoutystem.exception;

public class InvalidProductException extends RuntimeException{
    public InvalidProductException() {
        super("Invalid product");
    }
}
