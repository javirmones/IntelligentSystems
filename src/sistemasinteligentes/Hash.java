/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

/**
 *
 * @author absit
 */
public class Hash {

    public static String md5(String e) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(e.getBytes(), 0, e.length());
        return new BigInteger(1, m.digest()).toString(16);
    }

}
