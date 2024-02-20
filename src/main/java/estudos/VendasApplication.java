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

            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Daniele"));
            clientes.save(new Cliente("Bruno"));

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println); //imprimir todas os dados

            System.out.println("Atualizando clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado."); //para cada nome será inserido a palavra "atualizado"
                clientes.save(c);
            });

            System.out.println("Listando clientes atualizados");
            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println); //imprimir todas os dados atualizados

            System.out.println("Buscando clientes");
            clientes.findByNomeLike("Dan").forEach(System.out::println);

            System.out.println("Deletando clientes");
            clientes.findAll().forEach(c -> {
                clientes.delete(c); //deletar cada cliente encontrado
            });

            todosClientes = clientes.findAll();
            if (todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado!");
            } else {
                todosClientes.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }
}
