/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Usuário
 */
public class md5 {
public String md5 (String senha){
    MessageDigest md = null;
    try {
        md = MessageDigest.getInstance("md5");

    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
    return hash.toString(16);
}

}
