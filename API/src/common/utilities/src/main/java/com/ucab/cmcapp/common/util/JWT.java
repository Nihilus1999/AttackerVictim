package com.ucab.cmcapp.common.util;

import com.ucab.cmcapp.common.exceptions.JWTCreateException;
import com.ucab.cmcapp.common.exceptions.JWTSetKeyException;
import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import com.ucab.cmcapp.logic.dtos.dtos.AdministradorDto;
import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.properties.Registry;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

public class JWT {
    private static SecretKey _secretKey;
    private static String _issuer = Registry.getInstance().getProperty(Registry.JWT_ISSUER);
    private static String _algorithm = Registry.getInstance().getProperty(Registry.JWT_ALGORITHM);
    private static Logger _logger = LoggerFactory.getLogger(JWT.class);

    static {
        setKey();
    }

    private static void setKey() {
        //region Instrumentation DEBUG
        _logger.debug("Entering in JWT.setKey");
        //endregion

        try {
            _secretKey = Keys.secretKeyFor(SignatureAlgorithm.forName(_algorithm));
        } catch (Exception e) {
            throw new JWTSetKeyException(e.getMessage());
        }

        //region Instrumentation DEBUG
        _logger.debug("Leaving JWT.setKey");
        //endregion
    }

    /**
     * Name: verifyToken
     * Description: Method to check if JWT is valid
     *
     * @param token   Token JWT
     * @param subject Subject del JWT (User ID)
     */
    public static void verifyToken(String token, String subject) {
        //region Instrumentation DEBUG
        _logger.debug("Entering in JWT.verifyToken: token {}, subject {}", token, subject);
        //endregion

        try {
            Jwts.parser()
                    .requireSubject(subject)
                    .requireIssuer(_issuer)
                    .setSigningKey(_secretKey)
                    .parseClaimsJws(token);
        } catch (Exception e) {
            _logger.error(e.getMessage(), e);
            throw new JWTVerifyException(e.getMessage());
        }

        //region Instrumentation DEBUG
        _logger.debug("Leaving JWT.verifyToken");
        //endregion
    }

    /**
     * Name: createToken
     * Description: Method that creates a JWT based on the subject (see RFC 7519)
     *
     * @param subject JWT's Subject (User ID)
     * @return Token JWT
     */
    public static String createTokenUsuario(UsuarioDto subject) {
        String result;

        //region Instrumentation DEBUG
        _logger.debug("Entering in JWT.createToken: subject {}", subject);
        //endregion

        try {

            result = Jwts.builder()
                    .setIssuer(_issuer)
                    .setSubject(subject.get_alias())
                    .setNotBefore(new Date())
                    .setIssuedAt(new Date())
                    .setId(UUID.randomUUID().toString())
                    .signWith(_secretKey, SignatureAlgorithm.forName(_algorithm))
                    .compact();
        } catch (Exception e) {
            throw new JWTCreateException(e.getMessage());
        }

        //region Instrumentation DEBUG
        _logger.debug("Leaving JWT.createToken: token {}", result);
        //endregion

        return result;
    }

    public static String createTokenAdmin(AdministradorDto subject) {
        String result;

        //region Instrumentation DEBUG
        _logger.debug("Entering in JWT.createToken: subject {}", subject);
        //endregion

        try {

            result = Jwts.builder()
                    .setIssuer(_issuer)
                    .setSubject(subject.get_alias())
                    .setNotBefore(new Date())
                    .setIssuedAt(new Date())
                    .setId(UUID.randomUUID().toString())
                    .signWith(_secretKey, SignatureAlgorithm.forName(_algorithm))
                    .compact();
        } catch (Exception e) {
            throw new JWTCreateException(e.getMessage());
        }

        //region Instrumentation DEBUG
        _logger.debug("Leaving JWT.createToken: token {}", result);
        //endregion

        return result;
    }

    public static AdministradorDto verifyTokenAdmin(String token) {
        AdministradorDto result = new AdministradorDto();
        try {
            Jws<Claims> claims = Jwts.parser()
                    .requireIssuer(_issuer)
                    .setSigningKey(_secretKey)
                    .parseClaimsJws(token);

            String username = claims.getBody().getSubject();
            // Recuperando el tipo del usuario
            String type = (String) claims.getBody().get("type");

            result.set_alias(username);
        }catch (Exception e){
            _logger.error("Invalid token");
            _logger.error(e.getMessage(), e);
            throw new JWTVerifyException(e.getMessage());
        }

        return result;
    }

    public static UsuarioDto verifyTokenUsuario(String token) {
        UsuarioDto result = new UsuarioDto();
        try {
            Jws<Claims> claims = Jwts.parser()
                    .requireIssuer(_issuer)
                    .setSigningKey(_secretKey)
                    .parseClaimsJws(token);

            String username = claims.getBody().getSubject();
            // Recuperando el tipo del usuario
            String type = (String) claims.getBody().get("type");

            result.set_alias(username);
        }catch (Exception e){
            _logger.error("Invalid token");
            _logger.error(e.getMessage(), e);
            throw new JWTVerifyException(e.getMessage());
        }

        return result;
    }
}
