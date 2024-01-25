package estudos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //Classe que irá inicializar o spring boot
@RestController
public class VendasApplication {

    @GetMapping("/hello") //mapeando para o browser acessar essa url
    public String helloWorld(){
        return "hello world";
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args); //classe que irá inicar a aplicação / argumentos
    }
}
