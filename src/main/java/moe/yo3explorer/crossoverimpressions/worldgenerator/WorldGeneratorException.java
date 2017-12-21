package moe.yo3explorer.crossoverimpressions.worldgenerator;

import moe.yo3explorer.crossoverimpressions.CrossoverImpressionException;

/**
 * Created by ft on 21.12.17.
 */
public class WorldGeneratorException extends CrossoverImpressionException
{
    public WorldGeneratorException() {
        super();
    }

    public WorldGeneratorException(String message) {
        super(message);
    }

    public WorldGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorldGeneratorException(Throwable cause) {
        super(cause);
    }

    protected WorldGeneratorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
