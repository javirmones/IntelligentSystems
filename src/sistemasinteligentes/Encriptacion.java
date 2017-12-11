package sistemasinteligentes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 **/
public class Encriptacion {

    public static String md5(String e) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(e.getBytes(), 0, e.length());
        return new BigInteger(1, m.digest()).toString(16);
    }

}