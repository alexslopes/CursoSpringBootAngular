package io.github.alexslopes.clientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration//Usar notaçao já que EnableResourceServer nao possui
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override//Configuraçao  de acesso as API's
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/api/usuarios").permitAll()//é possível delimitar perfil de usuário usando hasRole("Perfil)/hasAnyRole em vez de permitAll
            .antMatchers("api/clientes/**",
                                    "/api/servicos-prestados").authenticated()
                .anyRequest().denyAll();
    }
}
