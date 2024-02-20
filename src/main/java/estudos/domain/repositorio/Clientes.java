package estudos.domain.repositorio;

import estudos.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    // select c from Cliente c where c.nome like :nome;
    List<Cliente> findByNomeLike(String nome); //query methods

    List<Cliente> findByNomeOrId(String nome, Integer id); //buscar por nome ou id

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id); //buscar por nome ou id e ordernar por id, e a declaração deve ser na mesma ordem

    Cliente findOneByNome(String nome); //se o nome do cliente for unico, vai retornar apenas com registro

    boolean existsByNome(String nome);
}
