package io.github.alexslopes.clientes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class internacionalizacaoConfig {

    @Bean//registra no contexto
    public MessageSource messageSource() {//Define a fonte das mensagens do sistema
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();//Responsa'vel por carregar o arquivo de mensagens 'messages.properties
        messageSource.setBasename("classpath:messages");//Não necessita colocar messages.properties, pois ja tá sub-entendido e o arquiva está na raiz
        messageSource.setDefaultEncoding("ISO-8859-1");//Enconde para entender mensagens com catacteres brasileiros
        messageSource.setDefaultLocale( Locale.getDefault() );
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean(){//Faz a integração entre as mensagens
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
