package com.nitro.falcon.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.nitro.falcon.models.User;
import com.sun.istack.Nullable;
import java.io.UnsupportedEncodingException;
import org.abstractj.kalium.crypto.Password;
import org.abstractj.kalium.crypto.Random;
import org.abstractj.kalium.encoders.Hex;

/**
 * UserService
 * @author leops
 */
public class UserService {
    public static @Nullable String getToken(final User user) {
        try {
            return JWT.create()
                    .withSubject(user.username)
                    .sign(Algorithm.HMAC256("secret"));
        } catch(final JWTCreationException | UnsupportedEncodingException err) {
            err.printStackTrace();
            return null;
        }
    }
    
    public static @Nullable User fromToken(final String token) {
        try {
            JWT.decode(token).getSubject();
            return null;
        } catch (final JWTDecodeException err){
            err.printStackTrace();
            return null;
        }
    }
    
    public static byte[] genSalt() {
        final Random rand = new Random();
        return rand.randomBytes();
    }
    
    public static String hashPassword(final String value, final byte[] salt) {
        final Password passwd = new Password();
        return passwd.hash(
            value.getBytes(),
            new Hex(), salt,
            (int) Math.pow(2, 20),
            (int) Math.pow(2, 24)
        );
    }
}
