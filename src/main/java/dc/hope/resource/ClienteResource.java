package dc.hope.resource;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.Clientes;
import dc.hope.request.ClienteRequest;
import dc.hope.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "cliente")
@AllArgsConstructor
public class ClienteResource {

    private final ClienteService clienteService;

    @PostMapping(path="cadastrar")
    public Clientes cadastrarCliente(@RequestBody @Valid ClienteRequest clienteRequest){
        return clienteService.cadastrar(clienteRequest);
    }

    @GetMapping("/{id}")
    public Clientes findById(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PutMapping(path = "{id}")
    public Clientes update(@PathVariable Long id, @RequestBody ClienteRequest clienteRequest){
        return clienteService.atualizarClientes(id, clienteRequest);
    }

    @DeleteMapping(path = "{id}")
        public void deletar(@PathVariable Long id){
            clienteService.deletar(id);
    }
    
}
