package estudos.domain.repositorio;

import estudos.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class Clientes { //base que acessa o banco de dados, podendo trazer as exceptions que ocorrem no banco

    private static String INSERT = "insert into cliente (nome) values (?) "; //irá inserir na coluna nome
    private static String SELECT_ALL = "select * from Cliente";

    @Autowired
    private JdbcTemplate jdbcTemplate; //configuração com banco de dados, utiliza o sql nativo

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()}); //sql e os parametros
        return cliente;
    }

    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome"); //pegar a String da coluna nome e vai retornar o resultado

                //return new Cliente(resultSet.getString("nome"));
                return new Cliente(id, nome);
            }
        });
    }
}
