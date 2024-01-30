package estudos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //todos os pacotes são escaneados para o Spring Boot e irá ficar dentro do container
@RestController
public class VendasApplication {

    @Value("${application.name}") //irá utilizar o valor customizado no application.properties
    private String applicationName;

    //@Autowired
    //@Qualifier("gato") //qualificar a injeção
    @Gato //injetar gato
    private Animal animal;

    @Bean(name = "executarAnimal")
    public CommandLineRunner executar(){
        return args -> {
            this.animal.fazerBarulho();
        };
    }

    @GetMapping("/application")
    public String application(){
        return applicationName;
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello world";
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }
}
