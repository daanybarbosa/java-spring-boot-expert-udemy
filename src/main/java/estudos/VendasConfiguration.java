package estudos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VendasConfiguration {

    @Bean(name = "applicationName") //crie o objeto no contexto da aplicação
    public String applicationName(){
        return "Sistema de Vendas";
    }

    @Bean(name = "otherApplicationName")
    public String otherApplicationName(){
        return "Outro Sistema de Vendas";
    }
}
