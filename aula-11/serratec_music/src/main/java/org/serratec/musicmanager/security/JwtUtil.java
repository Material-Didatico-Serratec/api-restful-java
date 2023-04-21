package org.serratec.musicmanager.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	@Value("${auth.secrekey}")
	private String secretkey;
	
	@Value("${auth.timeout}")
	private Long timeout;
	
	@Autowired
	private UsuarioDetalheService usuarioDetalheService;
	
	public String generateToken(String username) {
		UserDetails userDetails = usuarioDetalheService.loadUserByUsername(username);
		String perfil = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
		return Jwts.builder()
				   .setSubject(username)
				   .claim("perfil", perfil)
				   .setExpiration(new Date(System.currentTimeMillis() + (timeout * 1000 * 60 )))
				   .signWith(SignatureAlgorithm.HS512, secretkey.getBytes())
				   .compact();
	}
	
	public boolean isValid(String token) {
		Claims claims = getClaim(token);
		if (claims==null) {
			return false;
		}
		String username = claims.getSubject();
		Date expirationDate = claims.getExpiration();
		Date now = new Date(System.currentTimeMillis());
		if (username!=null && now.before(expirationDate)) {
			return true;
		}
		return false;
	}
	
	public String getPerfil(String token) {
		Claims claims = getClaim(token);
		if (claims==null) {
			return null;
		}
		return claims.get("perfil", String.class);
		
	}
	
	
	public Claims getClaim(String token) {
		
		try {
			return Jwts.parser()
						.setSigningKey(secretkey.getBytes())
						.parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	
	
	

}
