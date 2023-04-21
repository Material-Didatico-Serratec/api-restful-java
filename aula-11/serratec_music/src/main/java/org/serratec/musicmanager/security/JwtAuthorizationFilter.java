package org.serratec.musicmanager.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
	private JwtUtil jwtUtil;
	private UsuarioDetalheService usuarioDetalheService;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UsuarioDetalheService usuarioDetalheService) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
		this.usuarioDetalheService=usuarioDetalheService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String header = request.getHeader("Authorization");
		if (header !=null && header.startsWith("Bearer ")) {
			String token = header.replaceFirst("Bearer ", "");
			UsernamePasswordAuthenticationToken auth = getAuthentication(token);
			if (auth!=null) {
				SecurityContextHolder.getContext().setAuthentication(auth);
				String username = ((String)auth.getPrincipal());
				String novoToken = jwtUtil.generateToken(username);
				response.addHeader("Authorization", "Bearer " + novoToken);
				response.addHeader("access-control-expose-headers", "Authorization");
			}
		}
		
		
		chain.doFilter(request, response);
	}
	
	
	private UsernamePasswordAuthenticationToken getAuthentication(String token) {
		if (jwtUtil.isValid(token)) {
			String username = jwtUtil.getClaim(token).getSubject();
			UserDetails userDetails = usuarioDetalheService.loadUserByUsername(username);
			return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
		}
		return null;
	}

}
