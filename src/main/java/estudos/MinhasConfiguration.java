package estudos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
//@Profile("development") //ira rodar apenas no ambiente de desenvolvimento
@Development //annotation customizada de configuração
public class MinhasConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando a configuração de Desenvolvimento");
        };
    }
}
