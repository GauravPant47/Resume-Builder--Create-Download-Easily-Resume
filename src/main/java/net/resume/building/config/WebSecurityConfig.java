package net.resume.building.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig {
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private static final String[] WHITELST = {
			"/registra",
			"/js/**",
			"/images/**",
			"/css/**",
			"/.slider/**",
			"/home"
	};
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
			.authorizeRequests()
			.antMatchers(WHITELST).permitAll()
			.antMatchers(HttpMethod.GET, "/home").permitAll()
			.anyRequest().authenticated();

    	http
    		.formLogin()
    		.loginPage("/login")
    		.loginProcessingUrl("/login")
    		.usernameParameter("email")
    		.passwordParameter("password")
    		.defaultSuccessUrl("/home", true)
    		.failureUrl("/login?error")
			.permitAll()
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout")
			.and()
			.httpBasic();

    	return http.build();
    }
}