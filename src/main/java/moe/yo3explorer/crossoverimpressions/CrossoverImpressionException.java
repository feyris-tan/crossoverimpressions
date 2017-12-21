package moe.yo3explorer.crossoverimpressions;

/**
 * Created by ft on 21.12.17.
 */
public class CrossoverImpressionException extends RuntimeException
{
    public CrossoverImpressionException() {
        super();
    }

    public CrossoverImpressionException(String message) {
        super(message);
    }

    public CrossoverImpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrossoverImpressionException(Throwable cause) {
        super(cause);
    }

    protected CrossoverImpressionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
