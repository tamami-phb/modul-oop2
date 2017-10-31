package lab.aikibo.cobacrudangular.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import javax.sql.DataSource;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import lab.aikibo.cobacrudangular.util.CsrfHeaderFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String SQL_LOGIN = "select username, password, enabled from users " +
			"where username = ?";

	private static final String SQL_PERMISSION = "select u.username, r.role as authority " +
			"from users u " +
			"join user_role ur on u.username = ur.username " +
			"join roles r on r.id = ur.id_role " +
			"where u.username = ?";

	@Autowired
	private DataSource ds;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(ds)
			.usersByUsernameQuery(SQL_LOGIN)
			.authoritiesByUsernameQuery(SQL_PERMISSION);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				//.antMatchers("/add-user/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/")
			.and()
				.logout()
			.and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
				.csrf().csrfTokenRepository(csrfTokenRepository());
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository tokenRepo = new HttpSessionCsrfTokenRepository();
		tokenRepo.setHeaderName("X-XSRF-TOKEN");
		return tokenRepo;
	}

}
