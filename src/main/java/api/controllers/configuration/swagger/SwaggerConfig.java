package api.controllers.configuration.swagger;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "api_key", in = SecuritySchemeIn.HEADER)
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI ()
                .components(new Components())
                .info(new Info()
                        .title("Green Heart API")
                        .description("Rest API para gerenciamento e padronização dos dados de nossos clientes."));
    }
}