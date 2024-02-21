package estudos.domain.api.controller;

import estudos.domain.entity.Cliente;
import estudos.domain.repository.Clientes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller //defini essa classe como um controlador REST
//@RequestMapping("/api/clientes") //defini as urls de acesso aos controllers
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/api/clientes/{id}") //é equivalente ao @RequestMapping
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id){

        Optional<Cliente> cliente = clientes.findById(id);

        // exemplo 1
        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get()); //código HTTP
        }

        // exemplo 2
        /*if (cliente.isPresent()){
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", "token");
            ResponseEntity<Cliente> responseEntity = new ResponseEntity<>(cliente.get(),headers, HttpStatus.OK);
        }*/

        return ResponseEntity.notFound().build();
    }



    @RequestMapping(
            value = {"/hello/{nome}", "/api/hello"}, //{} variavel que será recebida por url, podendo reconhecer as duas requisições
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"}, //conteudo que essa requisição pode receber - json/xml
            produces = {"application/json", "application/xml"} //conteudo que essa requisição vai retornar o objeto
    )
    @ResponseBody
    public String helloClientePOST(@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente){ // @PathVariable - defini que irá receber uma variavel via url
        return String.format("Hello %s ", nomeCliente);
    }

    @RequestMapping(
            value = {"/hello/{nome}", "/api/hello"}, //{} variavel que será recebida por url, podendo reconhecer as duas requisições
            method = RequestMethod.GET
    )
    @ResponseBody
    public String helloClienteGET(@PathVariable("nome") String nomeCliente){ // @PathVariable - defini que irá receber uma variavel via url, entre () se a variavel estiver diferente do parametro, nesse caso, nomeCliente != nome
        return String.format("Hello %s ", nomeCliente);
    }
}
