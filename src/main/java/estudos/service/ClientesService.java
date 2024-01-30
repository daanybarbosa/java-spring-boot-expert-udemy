package estudos.service;

import estudos.model.Cliente;
import estudos.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//regras de negocio / solicita a informação ao banco de dados via repository
@Service
public class ClientesService {

    //Exemplo 1 - injeção direto na declaração do repository
    //@Autowired
    private ClientesRepository repository; //referencia

    //Exemplo 2  - construtor com injeção
    @Autowired
    public ClientesService( ClientesRepository repository ){
        this.repository = repository;
    }

    //Exemplo 3 - método Set
    /*@Autowired
    public void setRepository(ClientesRepository repository){
        this.repository = repository;
    }*/

    //public void salvarCliente(Object cliente){
    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);

        //instanciar todas as vezes no banco de dados pode ser pesado, tornando ideal delegar essa instancia ao container de injeção de dependencias, que irá fazer de forma automatica
        //ClientesRepository clientesRepository = new ClientesRepository();
        //clientesRepository.persistir(cliente);
        this.repository.persistir(cliente); //com injeção de dependencias
    }

    //public void validarCliente(Object cliente){
    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}
