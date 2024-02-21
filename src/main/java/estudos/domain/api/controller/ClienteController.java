package estudos.domain.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //defini essa classe como um controlador REST
@RequestMapping("/api/clientes") //defini as urls de acesso aos controllers
public class ClienteController {

    @RequestMapping(value = "/hello/{nome}", method = RequestMethod.GET) //{} variavel que será recebida por url
    @ResponseBody
    public String helloCliente(@PathVariable("nome") String nomeCliente){ // @PathVariable - defini que irá receber uma variavel via url
        return String.format("Hello %s ", nomeCliente);
    }
}
