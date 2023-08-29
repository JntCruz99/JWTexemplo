package org.example;



import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

public class JwtExample {
    private static final String SECRET = "seuSegredoAqui";

    public static String generateToken(String subject) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 1); // Token expira em 1 hora

        Date expirationDate = calendar.getTime();

        String token = JWT.create()
                .withSubject(subject)
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    public static boolean validateToken(String token) {
        try {
            DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token);

            Date expirationDate = jwt.getExpiresAt();
            return expirationDate.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

}

