package com.nitro.falcon.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.nitro.falcon.models.User;
import com.sun.istack.Nullable;
import java.io.UnsupportedEncodingException;
import org.abstractj.kalium.crypto.Password;
import org.abstractj.kalium.crypto.Random;
import org.abstractj.kalium.encoders.Encoder;
import org.abstractj.kalium.encoders.Hex;

/**
 * TokenUtils
 * @author leops
 */
public final class TokenUtils {
    private TokenUtils() {
        // Prevent instantiation
    }
    
    public static @Nullable String getToken(final User user) {
        try {
            return JWT.create()
                    .withSubject(user.getUsername())
                    .sign(Algorithm.HMAC256("secret"));
        } catch(final JWTCreationException | UnsupportedEncodingException err) {
            err.printStackTrace();
            return null;
        }
    }
    
    public static @Nullable String fromToken(final String token) {
        try {
            return JWT.decode(token).getSubject();
        } catch (final JWTDecodeException err){
            err.printStackTrace();
            return null;
        }
    }
    
    private static final Random RAND = new Random();
    public static byte[] genSalt() {
        return RAND.randomBytes();
    }
    
    private static final Password PASSWD = new Password();
    private static final Encoder ENCODER = new Hex();
    private static final int OPS_LIMIT = (int) Math.pow(2, 20);
    private static final long MEM_LIMIT = (long) Math.pow(2, 24);
    public static String hashPassword(final String value, final byte[] salt) {
        return PASSWD.hash(
            value.getBytes(),
            ENCODER, salt,
            OPS_LIMIT,
            MEM_LIMIT
        );
    }
}
