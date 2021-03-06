package moe.yo3explorer.crossoverimpressions.worldgenerator;


import moe.yo3explorer.crossoverimpressions.NotImplementedException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by ft on 17.12.17.
 */
public class AesRandomProxy extends Random
{
    private final static String ALGORITHM = "AES/CTR/NoPadding";

    public AesRandomProxy(byte[] key)
    {
        byte[] finalKey = new byte[16];
        System.arraycopy(key,0,finalKey,0,Math.min(16,key.length));

        adler = Adler32.adler32(key);
        byte[] nonce = ByteBuffer.allocate(16).putInt(adler).array();
        IvParameterSpec ips = new IvParameterSpec(nonce);

        try {
            SecretKeySpec sks = new SecretKeySpec(finalKey, "AES");

            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, sks, ips);
        }
        catch (NoSuchAlgorithmException nsae)
        {
            throw new WorldGeneratorException("The current JVM does not support " + ALGORITHM + ".",nsae);
        } catch (NoSuchPaddingException e) {
            throw new WorldGeneratorException("The current JVM does not support unpadded Ciphers.",e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new WorldGeneratorException("The current JVMs implementation does not support the required Cipher parameters.",e);
        } catch (InvalidKeyException e) {
            throw new WorldGeneratorException("The current JVMs does not support keys of size " + finalKey.length,e);
        }
    }

    public AesRandomProxy(String key) throws UnsupportedEncodingException {
        this(key.getBytes("utf-8"));
    }

    Cipher cipher;
    long insecureSeed;
    int adler;

    public AesRandomProxy() {
        throw new NotImplementedException();
    }

    public AesRandomProxy(long seed)
    {
        this(ByteBuffer.allocate(8).putLong(seed).array());
    }

    @Override
    public synchronized void setSeed(long seed) {
        insecureSeed = seed;
    }

    @Override
    protected int next(int bits) {
        byte[] data = cipher.update(new byte[4]);
        int seed = ByteBuffer.wrap(data).getInt(0);
        int result = (int) (seed >>> (48 - bits));
        return result;
    }

    @Override
    public void nextBytes(byte[] bytes) {
        throw new NotImplementedException();
    }

    @Override
    public int nextInt() {
        byte[] data = cipher.update(new byte[4]);
        int result = ByteBuffer.wrap(data).getInt(0);
        if (result < 0) result /= -1;
        return result;
    }

    @Override
    public int nextInt(int bound) {
        if (bound < 0)
            throw new IllegalArgumentException("bound must be positive.");

        int temp = nextInt();
        return temp % bound;
    }

    @Override
    public long nextLong() {
        throw new NotImplementedException();
    }

    @Override
    public boolean nextBoolean() {
        throw new NotImplementedException();
    }

    @Override
    public float nextFloat() {
        throw new NotImplementedException();
    }

    @Override
    public double nextDouble() {
        throw new NotImplementedException();
    }

    @Override
    public synchronized double nextGaussian() {
        throw new NotImplementedException();
    }

    @Override
    public IntStream ints(long streamSize) {
        throw new NotImplementedException();
    }

    @Override
    public IntStream ints() {
        throw new NotImplementedException();
    }

    @Override
    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        throw new NotImplementedException();
    }

    @Override
    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        throw new NotImplementedException();
    }

    @Override
    public LongStream longs(long streamSize) {
        throw new NotImplementedException();
    }

    @Override
    public LongStream longs() {
        throw new NotImplementedException();
    }

    @Override
    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        throw new NotImplementedException();
    }

    @Override
    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        throw new NotImplementedException();
    }

    @Override
    public DoubleStream doubles(long streamSize) {
        throw new NotImplementedException();
    }

    @Override
    public DoubleStream doubles() {
        throw new NotImplementedException();
    }

    @Override
    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        throw new NotImplementedException();
    }

    @Override
    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        throw new NotImplementedException();
    }
}
