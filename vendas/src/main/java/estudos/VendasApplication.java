package estudos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //todos os pacotes são escaneados para o Spring Boot e irá ficar dentro do container
@ComponentScan( // Especificar quais sao os componentes/classes/objetos que serão escaneadas
        basePackages = {
                "estudos/repository",
                "estudos/service",
                "estudos/com/umaoutrabiblioteca/projeto"
        })
@RestController
public class VendasApplication {

    @Autowired //injestão
    @Qualifier("applicationName")
    private String applicationName;

    @Autowired //injestão
    @Qualifier("otherApplicationName")
    private String otherApplicationName;

    @GetMapping("/application")
    public String application(){
        return applicationName;
    }

    @GetMapping("/otherApplication")
    public String otherApplication(){
        return otherApplicationName;
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello world";
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }
}
