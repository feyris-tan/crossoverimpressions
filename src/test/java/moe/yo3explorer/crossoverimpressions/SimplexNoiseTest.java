package moe.yo3explorer.crossoverimpressions;

import moe.yo3explorer.crossoverimpressions.worldgenerator.SimplexNoise;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by ft on 20.12.17.
 */
@Category(AllTests.class)
public class SimplexNoiseTest
{
    @Test
    public void DifferentSeed() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException {
        SimplexNoise a = new SimplexNoise("Natsume");
        SimplexNoise b = new SimplexNoise("Alexandra");

        double vA, vB, peakX, peakY;
        Random rng = new Random();
        for (int i = 0; i < 100; i++)
        {
            peakX = rng.nextDouble();
            peakY = rng.nextDouble();
            vA = a.noise(peakX,peakY);
            vB = b.noise(peakX,peakY);
            Assert.assertNotEquals(vA,vB,0.0);
        }
    }

    @Test
    public void SameSeed() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException {
        SimplexNoise a = new SimplexNoise("Azusa");
        SimplexNoise b = new SimplexNoise("Azusa");

        double vA, vB, peakX, peakY;
        Random rng = new Random();
        for (int i = 0; i < 100; i++)
        {
            peakX = rng.nextDouble();
            peakY = rng.nextDouble();
            vA = a.noise(peakX,peakY);
            vB = b.noise(peakX,peakY);
            Assert.assertEquals(vA,vB,0.0);
        }
    }
}
