package estudos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Classe que irá inicializar o spring boot
public class VendasApplication {

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args); //classe que irá inicar a aplicação / argumentos
    }
}
