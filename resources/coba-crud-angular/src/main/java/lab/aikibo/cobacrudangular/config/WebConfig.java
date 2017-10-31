package lab.aikibo.cobacrudangular.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/test-angular").setViewName("test-angular");
                registry.addViewController("/").setViewName("daftar-mahasiswa");
                registry.addViewController("/daftar-mahasiswa").setViewName("daftar-mahasiswa");
                registry.addViewController("/form").setViewName("form");
                registry.addViewController("/edit-form").setViewName("edit-form");
	}

}