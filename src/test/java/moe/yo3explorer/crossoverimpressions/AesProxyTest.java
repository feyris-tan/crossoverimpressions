package moe.yo3explorer.crossoverimpressions;

import moe.yo3explorer.crossoverimpressions.worldgenerator.AesRandomProxy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ft on 17.12.17.
 */
@Category(AllTests.class)
public class AesProxyTest
{
    @Test
   public void construct() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException {
       AesRandomProxy arp = new AesRandomProxy("NothingAtAll");
   }

   @Test
    public void sameKeySameFirstNumber() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException {
       AesRandomProxy arp1 = new AesRandomProxy("Natsume");
       AesRandomProxy arp2 = new AesRandomProxy("Natsume");

       int firstNumber = arp1.nextInt();
       int secondNumber = arp2.nextInt();

       Assert.assertEquals(firstNumber,secondNumber);
   }

   @Test
    public void differentKeyUnequalNumber() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException {
       AesRandomProxy amiProxy = new AesRandomProxy("Ami");
       AesRandomProxy mamiProxy = new AesRandomProxy("Mami");

       int amiNumber = amiProxy.nextInt();
       int mamiNumber = mamiProxy.nextInt();

       Assert.assertNotEquals(amiNumber,mamiNumber);
   }

   @Test
    public void longDifferentKey() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException {
       AesRandomProxy amiProxy = new AesRandomProxy("My favorite Idol is Ami");
       AesRandomProxy mamiProxy = new AesRandomProxy("My favorite Idol is Mami");

       int amiNumber = amiProxy.nextInt();
       int mamiNumber = mamiProxy.nextInt();

       Assert.assertNotEquals(amiNumber,mamiNumber);
   }
}
