package com.music_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringCloudApplication
@EnableZuulProxy
@EnableSwagger2
public class MusicApiGateway_Zuul {

	public static void main(String[] args) {
		SpringApplication.run(MusicApiGateway_Zuul.class, args);
	}

	@Component
	@Primary
	class DocumentationConfig implements SwaggerResourcesProvider {
		@Override
		public List<SwaggerResource> get() {
			List resources = new ArrayList<>();
			resources.add(swaggerResource("service-user-feign",
					"/api-user/v2/api-docs", "1.0"));
			resources.add(swaggerResource("service-music",
					"/api-music/v2/api-docs", "1.0"));
			resources.add(swaggerResource("service-favorite",
					"/api-favorite/v2/api-docs", "1.0"));
			resources.add(swaggerResource("service-like",
					"/api-like/v2/api-docs", "1.0"));
			return resources;
		}

		private SwaggerResource swaggerResource(String name, String location, String version) {
			SwaggerResource swaggerResource = new SwaggerResource();
			swaggerResource.setName(name);
			swaggerResource.setLocation(location);
			swaggerResource.setSwaggerVersion(version);
			return swaggerResource;
		}
	}

}
