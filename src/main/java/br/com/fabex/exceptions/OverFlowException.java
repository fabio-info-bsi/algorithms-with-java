package br.com.fabex.exceptions;

public abstract class OverFlowException extends RuntimeException {
    protected OverFlowException() {
    }

    protected OverFlowException(String message) {
        super(message);
    }

    protected OverFlowException(String message, Throwable cause) {
        super(message, cause);
    }

    protected OverFlowException(Throwable cause) {
        super(cause);
    }

    protected OverFlowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
