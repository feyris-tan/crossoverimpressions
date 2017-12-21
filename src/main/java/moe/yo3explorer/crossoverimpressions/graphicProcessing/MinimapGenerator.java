package moe.yo3explorer.crossoverimpressions.graphicProcessing;

import com.sun.javafx.iio.ImageStorage;
import moe.yo3explorer.crossoverimpressions.worldgenerator.SimplexNoise;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ft on 21.12.17.
 */
public class MinimapGenerator extends BufferedImage
{
    private static double SCALE = 100.0;
    private static Color SEA = new Color(65,105,225);
    private static Color GRASS = new Color(34,139,34);
    private static Color BEACH = new Color(238,214,175);
    private static Color SNOW = new Color(255,250,250);
    private static Color MOUNTAIN = new Color(139,137,137);

    public MinimapGenerator(SimplexNoise noise, int xOffset, int yOffset, int w, int h)
    {
        super(w,h, BufferedImage.TYPE_INT_RGB);
        double minimumValue = Double.MAX_VALUE;
        double maxmimumValue = Double.MIN_VALUE;
        double raw = -1.0;
        for (int y = 0; y < h; y++)
        {
            for (int x = 0; x < w; x++)
            {
                raw = noise.noise((double)(xOffset + x) / SCALE,(double)(yOffset + y) / SCALE);
                if (raw < minimumValue)
                    minimumValue = raw;
                if (raw > maxmimumValue)
                    maxmimumValue = raw;
                if (raw < -0.05)
                    setRGB(x,y,SEA.getRGB());
                else if (raw < 0)
                    setRGB(x,y,BEACH.getRGB());
                else if (raw < 0.5)
                    setRGB(x,y,GRASS.getRGB());
                else if (raw < 0.75)
                    setRGB(x,y,MOUNTAIN.getRGB());
                else if (raw < 1.0)
                    setRGB(x,y,SNOW.getRGB());
            }
        }
        flush();
        System.out.println("Maximum value: " + maxmimumValue);
        System.out.println("Minimum value: " + minimumValue);
    }
}
