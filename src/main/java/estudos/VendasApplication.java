package estudos;

import estudos.domain.entity.Cliente;
import estudos.domain.entity.Pedido;
import estudos.domain.repository.Clientes;
import estudos.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos
    ){
        return args -> {

            System.out.println("<--- Criando pedido --->");
            Cliente fulano = new Cliente("Fulano");
            clientes.save(fulano);

            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now()); //data atual
            p.setTotal(BigDecimal.valueOf(100)); //100,00

            pedidos.save(p);

            System.out.println(" <--- Salvando Pedido --->");
            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());

            System.out.println(" <--- Encontrar pedidos por cliente --->");
            pedidos.findByCliente(fulano).forEach(System.out::println);

            // TODO: comentar a partir daqui para evitar erros na aplicação
            System.out.println("<--- Salvando clientes --->");
            clientes.save(new Cliente("Daniele"));
            clientes.save(new Cliente("Bruno"));

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println); //imprimir todas os dados

            System.out.println(" <--- Encontrar por Nome - SQL --->");
            List<Cliente> encontrarPorNomeSQL = clientes.encontrarPorNomeSQL("Bruno");
            encontrarPorNomeSQL.forEach(System.out::println);
            List<Cliente> encontrarPorNomeSQLCliente = clientes.encontrarPorNomeSQL("Cliente");
            encontrarPorNomeSQLCliente.forEach(System.out::println);

            System.out.println(" <--- Encontrar por Nome - HQL --->");
            List<Cliente> encontrarDaniele = clientes.encontrarPorNomeHQL("Daniele");
            encontrarDaniele.forEach(System.out::println);
            List<Cliente> encontrarCliente = clientes.encontrarPorNomeHQL("Cliente");
            encontrarCliente.forEach(System.out::println);

            System.out.println(" <--- Localizando clientes --->");
            boolean existeDaniele = clientes.existsByNome("Daniele");
            boolean existeCliente = clientes.existsByNome("Cliente");
            System.out.println("Existe um cliente com o nome Daniele ? " + existeDaniele);
            System.out.println("Existe um cliente com o nome Cliente ? " + existeCliente);

            System.out.println("<--- Atualizando clientes --->");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado."); //para cada nome será inserido a palavra "atualizado"
                clientes.save(c);
            });

            System.out.println("<--- Listando clientes atualizados --->");
            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println); //imprimir todas os dados atualizados

            System.out.println("<--- Buscando clientes --->");
            clientes.findByNomeLike("Dan").forEach(System.out::println);

            System.out.println("<--- Deletando clientes --->");
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
