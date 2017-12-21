package moe.yo3explorer.crossoverimpressions.graphicProcessing;

import moe.yo3explorer.crossoverimpressions.CrossoverImpressionException;

/**
 * Created by ft on 21.12.17.
 */
public class GraphicProcessingException extends CrossoverImpressionException
{
    public GraphicProcessingException() {
        super();
    }

    public GraphicProcessingException(String message) {
        super(message);
    }

    public GraphicProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public GraphicProcessingException(Throwable cause) {
        super(cause);
    }

    protected GraphicProcessingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
