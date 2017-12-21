package moe.yo3explorer.crossoverimpressions;

import moe.yo3explorer.crossoverimpressions.graphicProcessing.GraphicUtils;
import moe.yo3explorer.crossoverimpressions.graphicProcessing.MinimapGenerator;
import moe.yo3explorer.crossoverimpressions.worldgenerator.SimplexNoise;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by ft on 21.12.17.
 */
@Category(AllTests.class)
public class WorldGeneratorTest
{
    @Test
    public void generateMinimap()
    {
        //good seed: im9go8ggg7c6m1so61sl
        String SEED = new BigInteger(100,new Random()).toString(32);
        System.out.println("Using seed: " + SEED);

        SimplexNoise world = new SimplexNoise(SEED);
        MinimapGenerator minimap = new MinimapGenerator(world,1000,1000,640,480);
        GraphicUtils.exportImage("testmap.png",minimap);
    }
}
