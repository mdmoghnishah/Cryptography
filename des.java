package cns;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
import java.util.Base64;
public class des {
private KeySpec myKeySpec;
private SecretKeyFactory mySecretKeyFactory;
private Cipher cipher;
byte[] keyAsBytes;
private String myEncryptionKey;
SecretKey key;
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
public des() throws Exception {
// TODO code application logic here
myEncryptionKey="ThisIsSecretEncryptionKey";
keyAsBytes=myEncryptionKey.getBytes();
myKeySpec=new DESKeySpec(keyAsBytes);
mySecretKeyFactory = SecretKeyFactory.getInstance("DES");
cipher = Cipher.getInstance("DES");
key = mySecretKeyFactory.generateSecret(myKeySpec);
}
public String encrypt(String unencryptedString)
{ String encryptedString = null;
try {
cipher.init(Cipher.ENCRYPT_MODE, key);
byte[] plainText = unencryptedString.getBytes();
byte[] encryptedText = cipher.doFinal(plainText);
encryptedString = Base64.getEncoder().encodeToString(encryptedText);
}
catch (Exception e)
{
e.printStackTrace();
}
return encryptedString;
}
public String decrypt(String encryptedString)
{ String decryptedText=null;
try {
	cipher.init(Cipher.DECRYPT_MODE, key);
	byte[] encryptedText = Base64.getDecoder().decode(encryptedString);
	byte[] plainText = cipher.doFinal(encryptedText);
	decryptedText=new String(plainText);
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	return decryptedText;
	}
	public static void main(String args []) throws Exception
	{
	des myEncryptor= new des();
	System.out.print("Enter the string: ");
	String stringToEncrypt = br.readLine();
	String encrypted = myEncryptor.encrypt(stringToEncrypt);
	String decrypted = myEncryptor.decrypt(encrypted);
	System.out.println("\nString To Encrypt: " +stringToEncrypt);
	System.out.println("\nEncrypted Value : " +encrypted);
	System.out.println("\nDecrypted Value : " +decrypted); System.out.println("");
	}
	}