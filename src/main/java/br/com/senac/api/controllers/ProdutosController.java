package br.com.senac.api.controllers;


import br.com.senac.api.entidades.Enderecos;
import br.com.senac.api.entidades.Produtos;
import br.com.senac.api.repositorios.ProdutosRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosRespository produtosRespository;

    @GetMapping("/listar")
    public ResponseEntity<List<Produtos>> listarProdutos() {
        List<Produtos> produtosRetorno =
                produtosRespository.findAll();

        return ResponseEntity.ok().body(produtosRetorno);
    }

    @PostMapping("/criar")
    public ResponseEntity<Produtos> criarProdutos(
            @RequestBody Produtos produto
    ) {
        Produtos retorno = produtosRespository.save(produto);

        if (retorno != null) {
            return ResponseEntity.ok().body(retorno);

        }

        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/atualizarNome/{id}")
    public ResponseEntity<Produtos> atualizarNome(
            @RequestBody Produtos produto,
            @PathVariable Long id
    ) {
        Optional<Produtos> retorno = produtosRespository.findById(id).map(record -> {
            record.setNome(produto.getNome());

            return produtosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }

    @PutMapping("/atualizarDescricao/{id}")
    public ResponseEntity<Produtos> atualizarDescricao(
            @RequestBody Produtos produto,
            @PathVariable Long id
    ) {
        Optional<Produtos> retorno = produtosRespository.findById(id).map(record -> {
            record.setDescricao(produto.getDescricao());

            return produtosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }
    @PutMapping("/atualizarurlImagem/{id}")
    public ResponseEntity<Produtos> atualizarurlImagem(
            @RequestBody Produtos produto,
            @PathVariable Long id
    ) {
        Optional<Produtos> retorno = produtosRespository.findById(id).map(record -> {
            record.setUrlImagem(produto.getUrlImagem());

            return produtosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }
    @PutMapping("/atualizarAltura/{id}")
    public ResponseEntity<Produtos> atualizarAltura(
            @RequestBody Produtos produto,
            @PathVariable Long id
    ) {
        Optional<Produtos> retorno = produtosRespository.findById(id).map(record -> {
            record.setAltura(produto.getAltura());

            return produtosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }
    @PutMapping("/atualizarLargura/{id}")
    public ResponseEntity<Produtos> atualizarLargura(
            @RequestBody Produtos produto,
            @PathVariable Long id
    ) {
        Optional<Produtos> retorno = produtosRespository.findById(id).map(record -> {
            record.setLargura(produto.getLargura());

            return produtosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }

    @PutMapping("/atualizarComprimento/{id}")
    public ResponseEntity<Produtos> atualizarComprimento(
            @RequestBody Produtos produto,
            @PathVariable Long id
    ) {
        Optional<Produtos> retorno = produtosRespository.findById(id).map(record -> {
            record.setComprimento(produto.getComprimento());

            return produtosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }
    @PutMapping("/atualizarPesoLiquido/{id}")
    public ResponseEntity<Produtos> atualizarPesoLiquido(
            @RequestBody Produtos produto,
            @PathVariable Long id
    ) {
        Optional<Produtos> retorno = produtosRespository.findById(id).map(record -> {
            record.setPesoLiquido(produto.getPesoLiquido());

            return produtosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }

    @PutMapping("/atualizarPesoBruto/{id}")
    public ResponseEntity<Produtos> atualizarPesoBruto(
            @RequestBody Produtos produto,
            @PathVariable Long id
    ) {
        Optional<Produtos> retorno = produtosRespository.findById(id).map(record -> {
            record.setPesoBruto(produto.getPesoBruto());

            return produtosRespository.save(record);
        });
        if (retorno.isPresent()) {
            return ResponseEntity.ok().body(retorno.get());
        }
        return ResponseEntity.badRequest().body(null);

    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id){   //void entre <> por que nao tem retorno

        produtosRespository.deleteById(id);

        return ResponseEntity.ok().body(null);

    }
    //teste
}
