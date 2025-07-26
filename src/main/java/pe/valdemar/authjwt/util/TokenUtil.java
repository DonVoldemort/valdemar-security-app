package pe.valdemar.authjwt.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import pe.valdemar.authjwt.model.TokenProperties;

import java.time.Instant;
import java.util.Date;

@Component
public class TokenUtil {

    private final TokenProperties tokenProperties;

    /**
     *
     * @param tokenProperties
     */
    public TokenUtil(TokenProperties tokenProperties) {
        this.tokenProperties = tokenProperties;
    }

    public String generateToken(String username) {
        long expiration = tokenProperties.getExpiration();
        String secret = tokenProperties.getSecret();

        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusMillis(expiration)))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}
