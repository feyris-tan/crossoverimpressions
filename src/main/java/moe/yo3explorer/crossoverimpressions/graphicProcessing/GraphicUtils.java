package moe.yo3explorer.crossoverimpressions.graphicProcessing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ft on 21.12.17.
 */
public final class GraphicUtils
{
    private GraphicUtils() {}

    public static byte[] bufferedImageToByteArray(BufferedImage bi)
    {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);
            return baos.toByteArray();
        }
        catch(IOException ioe)
        {
            throw new GraphicProcessingException("Could not convert a BufferedImage to a byte[]",ioe);
        }
    }

    public static void writeAllBytes(String fname, byte[] bytes)
    {
        try {
            FileOutputStream fos = new FileOutputStream(fname);
            fos.write(bytes, 0, bytes.length);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            throw new GraphicProcessingException(e.getMessage(),e);
        }
    }

    public static void exportImage(String fname, BufferedImage bi)
    {
        byte[] temp = bufferedImageToByteArray(bi);
        writeAllBytes(fname,temp);
    }
}
