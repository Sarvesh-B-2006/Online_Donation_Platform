package com.donationplatform.donation_platform.security;



import io.jsonwebtoken.*;

import io.jsonwebtoken.security.Keys;


import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;


import java.util.Date;



@Service
public class JwtService {



private final SecretKey SECRET_KEY =
        Keys.secretKeyFor(
                SignatureAlgorithm.HS256
        );




public String generateToken(String email){



return Jwts.builder()


        .setSubject(email)


        .setIssuedAt(
                new Date()
        )


        .setExpiration(
                new Date(
                System.currentTimeMillis()
                + 1000*60*60
                )
        )


        .signWith(
                SECRET_KEY
        )


        .compact();



}





public String extractEmail(String token){


return Jwts.parserBuilder()

        .setSigningKey(
                SECRET_KEY
        )

        .build()

        .parseClaimsJws(token)

        .getBody()

        .getSubject();


}




public boolean validateToken(String token){


try{


Jwts.parserBuilder()

.setSigningKey(
        SECRET_KEY
)

.build()

.parseClaimsJws(token);



return true;


}

catch(Exception e){

return false;

}


}



}