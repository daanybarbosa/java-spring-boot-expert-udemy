package estudos.domain.repository;

import estudos.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    //SQL Nativo
    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNomeSQL(@Param("nome") String nome);

    //HQL - Hibernate Query Language
    @Query(value = " select c from Cliente c where c.nome like :nome")
    List<Cliente> encontrarPorNomeHQL(@Param("nome") String nome);

    @Query(value = " delete from Cliente c where c.nome = :nome")
    @Modifying //esse método fará uma transição no banco de dados - delete/update
    void deleteByNome(String nome);

    // select c from Cliente c where c.nome like :nome;
    List<Cliente> findByNomeLike(String nome); //query methods

    List<Cliente> findByNomeOrId(String nome, Integer id); //buscar por nome ou id

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id); //buscar por nome ou id e ordernar por id, e a declaração deve ser na mesma ordem

    Cliente findOneByNome(String nome); //se o nome do cliente for unico, vai retornar apenas com registro

    boolean existsByNome(String nome);
}