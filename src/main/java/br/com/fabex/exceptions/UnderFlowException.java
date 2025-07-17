package br.com.fabex.exceptions;

public abstract class UnderFlowException extends RuntimeException {
    protected UnderFlowException() {
    }

    protected UnderFlowException(String message) {
        super(message);
    }

    protected UnderFlowException(String message, Throwable cause) {
        super(message, cause);
    }

    protected UnderFlowException(Throwable cause) {
        super(cause);
    }

    protected UnderFlowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
