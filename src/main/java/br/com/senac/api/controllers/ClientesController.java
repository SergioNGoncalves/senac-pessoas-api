package br.com.senac.api.controllers;

import br.com.senac.api.entidades.Clientes;
import br.com.senac.api.repositorios.ClientesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@Controller
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClientesRespository clientesRespository;

    @GetMapping("/listar")
    public ResponseEntity<List<Clientes>> listarClientes() {
        List<Clientes> clientesRetorno =
                clientesRespository.findAll();

        return ResponseEntity.ok().body(clientesRetorno);
    }

    @PostMapping("/criar")
    public ResponseEntity<Clientes> criarCliente(
            @RequestBody Clientes cliente
    ) {
        Clientes retorno = clientesRespository.save(cliente);

        if (retorno != null) {
            return ResponseEntity.ok().body(retorno);

        }

        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Clientes> atualizarCliente(
            @RequestBody Clientes cliente,
            @PathVariable Long id
    ) {
        Optional<Clientes> retorno = clientesRespository.findById(id).map(record -> {
            record.setNome(cliente.getNome());

            return clientesRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){   //void entre <> por que nao tem retorno

        clientesRespository.deleteById(id);

        return ResponseEntity.ok().body(null);

    }

}
