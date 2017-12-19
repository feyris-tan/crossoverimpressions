package moe.yo3explorer.crossoverimpressions.worldgenerator;

import java.nio.charset.Charset;

/**
 * Created by ft on 17.12.17.
 */
public class Adler32
{
    private Adler32()
    {

    }

    @org.jetbrains.annotations.Contract(pure = true)
    public static int adler32(byte[] buf)
    {
       int buflength = buf.length;

       int s1 = 1;
       int s2 = 0;

       for (int n = 0; n < buflength; n++)
       {
           s1 = (s1 + buf[n]) % 65521;
           s2 = (s2 + s1) % 65521;
       }

       return (s2 << 16) | s1;
    }

    public static int adler32(String s)
    {
        return adler32(s.getBytes(Charset.forName("utf-8")));
    }
}
