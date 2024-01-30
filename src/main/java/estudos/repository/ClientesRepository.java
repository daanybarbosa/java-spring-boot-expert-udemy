package estudos.repository;

import estudos.model.Cliente;
import org.springframework.stereotype.Repository;

//acessa o banco de dados
@Repository //classe irá acessar a base de dados
public class ClientesRepository {

    public void persistir(Cliente cliente){
        //acessa a base e salva o cliente
    }
}
