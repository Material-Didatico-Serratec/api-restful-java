package org.serratec.musicmanager.config;

import org.serratec.musicmanager.security.JwtAuthenticationFilter;
import org.serratec.musicmanager.security.JwtAuthorizationFilter;
import org.serratec.musicmanager.security.JwtUtil;
import org.serratec.musicmanager.security.UsuarioDetalheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioDetalheService usuarioDetalheService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		  .headers().frameOptions().disable().and()//para o h2
		  .cors().and()
		  .csrf().disable()
		  .authorizeRequests()
		  .antMatchers(HttpMethod.POST, "/login").permitAll()
		  .antMatchers(HttpMethod.GET, "/album", "/musica", "/artista").permitAll()
		  .antMatchers("/usuario").hasAuthority("ROLE_ADMIN")
		  .antMatchers(HttpMethod.POST, "/album", "/musica", "/artista").hasAuthority("ROLE_ADMIN")
		  .antMatchers(HttpMethod.PUT, "/album", "/musica", "/artista").hasAuthority("ROLE_ADMIN")
		  .antMatchers(HttpMethod.DELETE, "/album", "/musica", "/artista").hasAuthority("ROLE_ADMIN")
		  .antMatchers("/swagger-ui/**").permitAll()
		  .antMatchers("/swagger-resources/**").permitAll()
		  .antMatchers("/v2/api-docs/**").permitAll()
		  .antMatchers("/h2-console/**").permitAll()
		  
		  
		  .anyRequest().authenticated();
		
		http.addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtUtil, usuarioDetalheService));
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDetalheService);
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
