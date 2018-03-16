package com.test.dockertest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(SwaggerConfiguration.class);
	@Autowired
	private Environment env;

	public SwaggerConfiguration springSwaggerConfig;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LocaleChangeInterceptor());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("Adding Resource Handlers for Swagger");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		logger.info("Getting API Info..");
		String termsOfServiceUrl = "http://" + env.getProperty("hostname") + ":" + env.getProperty("port") + "/"
				+ env.getProperty("context-name");

		String licenceUrl = "http://" + env.getProperty("hostname") + ":" + env.getProperty("port") + "/"
				+ env.getProperty("context-name") + "/v2/api-docs";

		return new ApiInfoBuilder().title("Spring - Docker").description("Spring Boot Gradle Docker Application").version("1.0")
				.termsOfServiceUrl(termsOfServiceUrl).license("LICENSE").licenseUrl(licenceUrl).build();
	}

	@Autowired
	public void setSpringSwaggerConfig(SwaggerConfiguration springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}
}
