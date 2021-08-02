package disney.challenge.security;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import disney.challenge.services.implementation.UserDetailsServiceImp;
import disney.challenge.services.implementation.UsuarioServiceImp;



	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		  @Autowired
		    private UserDetailsServiceImp userDetailsService;

		    @Autowired
		    private JwtFilter jwtFilter;

		    @Override
		    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		    }
		    @Bean
		    public PasswordEncoder passwordEncoder(){
		        return new BCryptPasswordEncoder(); //NoOpPasswordEncoder.getInstance();
		    }

		    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
		    @Override
		    public AuthenticationManager authenticationManagerBean() throws Exception {
		        return super.authenticationManagerBean();
		    }

		    @Override
		    protected void configure(HttpSecurity http) throws Exception {
		        http.csrf().disable().authorizeRequests().antMatchers("/auth/**")
		                .permitAll().anyRequest().authenticated()
		                .and().exceptionHandling().and().sessionManagement()
		                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
		    }
	}

