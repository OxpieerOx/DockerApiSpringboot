package ApiAnuncioAlbergue.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACTO = new Contact("Pieer Rodas Vereau", "https://nttdata.com", "pie_er1@hotmail.com");

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Api AnuncioAlbergue", "Api de la tabla AnuncioAlbergue la cual con tiene un CRUD sobre este", "0.0.1",
                "http://localhost:8080", DEFAULT_CONTACTO, "MIT", "http://localhost:9000", Collections.emptyList());
    }

}
