package br.com.senac.api.controllers;


import br.com.senac.api.entidades.Enderecos;
import br.com.senac.api.repositorios.EnderecosRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/enderecos")
public class EnderecosController {
    @Autowired
    private EnderecosRespository enderecosRespository;

    @GetMapping("/listar")
    public ResponseEntity<List<Enderecos>> listarEnderecos() {
        List<Enderecos> enderecosRetorno =
                enderecosRespository.findAll();

        return ResponseEntity.ok().body(enderecosRetorno);
    }

    @PostMapping("/criar")
    public ResponseEntity<Enderecos> criarEndereco(
            @RequestBody Enderecos endereco
    ) {
        Enderecos retorno = enderecosRespository.save(endereco);

        if (retorno != null) {
            return ResponseEntity.ok().body(retorno);

        }

        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/atualizarRua/{id}")
    public ResponseEntity<Enderecos> atualizarRua(
            @RequestBody Enderecos endereco,
            @PathVariable Long id
    ) {
        Optional<Enderecos> retorno = enderecosRespository.findById(id).map(record -> {
            record.setRua(endereco.getRua());

            return enderecosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }

    @PutMapping("/atualizarBairro/{id}")
    public ResponseEntity<Enderecos> atualizarBairro(
            @RequestBody Enderecos endereco,
            @PathVariable Long id
    ) {
        Optional<Enderecos> retorno = enderecosRespository.findById(id).map(record -> {
            record.setBairro(endereco.getBairro());

            return enderecosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }
    @PutMapping("/atualizarCidade/{id}")
    public ResponseEntity<Enderecos> atualizarCidade(
            @RequestBody Enderecos endereco,
            @PathVariable Long id
    ) {
        Optional<Enderecos> retorno = enderecosRespository.findById(id).map(record -> {
            record.setCidade(endereco.getCidade());

            return enderecosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }
    @PutMapping("/atualizarUf/{id}")
    public ResponseEntity<Enderecos> atualizarUf(
            @RequestBody Enderecos endereco,
            @PathVariable Long id
    ) {
        Optional<Enderecos> retorno = enderecosRespository.findById(id).map(record -> {
            record.setUf(endereco.getUf());

            return enderecosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }
    @PutMapping("/atualizarResponsavel/{id}")
    public ResponseEntity<Enderecos> atualizarResposavel(
            @RequestBody Enderecos endereco,
            @PathVariable Long id
    ) {
        Optional<Enderecos> retorno = enderecosRespository.findById(id).map(record -> {
            record.setResponsavel(endereco.getResponsavel());

            return enderecosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id){   //void entre <> por que nao tem retorno

        enderecosRespository.deleteById(id);

        return ResponseEntity.ok().body(null);

    }

}
