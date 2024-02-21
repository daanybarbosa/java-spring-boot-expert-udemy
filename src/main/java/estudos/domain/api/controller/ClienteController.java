package estudos.domain.api.controller;

import estudos.domain.entity.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //defini essa classe como um controlador REST
@RequestMapping("/api/clientes") //defini as urls de acesso aos controllers
public class ClienteController {

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
    public String helloClienteGET(@PathVariable("nome") String nomeCliente){ // @PathVariable - defini que irá receber uma variavel via url
        return String.format("Hello %s ", nomeCliente);
    }
}
