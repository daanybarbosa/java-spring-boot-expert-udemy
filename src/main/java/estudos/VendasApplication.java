package estudos;

import estudos.domain.entity.Cliente;
import estudos.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            //exemplo 1
            Cliente cliente = new Cliente("Daniele");
            clientes.salvar(cliente);

            //exemplo 2
            clientes.salvar(new Cliente("Bruno"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println); //imprimir todas os dados
        };
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }
}
