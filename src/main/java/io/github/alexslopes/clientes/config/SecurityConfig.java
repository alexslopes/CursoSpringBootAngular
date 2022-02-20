package io.github.alexslopes.clientes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override//AuthenticationManagerBuilder: classe cria o gerenciamento de autenticaçao na aplição
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                inMemoryAuthentication()
                .withUser("fulano")
                .password("123")
                .roles("USER");//Perfil de usuário
    }

    @Bean//Faz o gerenciamento e autenticação de usuários
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override//Faz autoprizaçao de url, configurar sessao, cors....
    protected void configure(HttpSecurity http) throws Exception {
        http.
            csrf().disable()//csrf usada quando a aplicação web é aclopada ao springboot, vem habilitado por padrão
                .cors()//habilita o cors
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//Significa que a aplicação não vai guardar sessão, ja que vai manter com token
    }
}
