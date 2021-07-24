package com.vehicles.project.excepciones;

import java.util.InputMismatchException;

public class RevisioTipus extends InputMismatchException {
    /**
     * Constructs an {@code InputMismatchException} with {@code null}
     * as its error message string.
     */
    public RevisioTipus() {
    }

    /**
     * Constructs an {@code InputMismatchException}, saving a reference
     * to the error message string {@code s} for later retrieval by the
     * {@code getMessage} method.
     *
     * @param s the detail message.
     */
    public RevisioTipus(String s) {
        super(s);
    }
}
