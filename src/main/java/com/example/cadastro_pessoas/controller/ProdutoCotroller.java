package com.example.cadastro_pessoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.servicer.ProdutosServicer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController

@RequestMapping("/api/produtos")
public class ProdutoCotroller {

    @Autowired

    private ProdutosServicer servicer;

    @GetMapping
    public List<ProdutosModel> listarTodos(){
        return servicer.listarTodos();
        
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutosModel> buscarPorId(@PathVariable Long id){
        return servicer.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

    }
    
    @PostMapping
    public ProdutosModel salvar(@RequestBody ProdutosModel produtosModel){
        return servicer.salvar(produtosModel);
    }
    
    @PutMapping
    public ResponseEntity <ProdutosModel> atualizar(@PathVariable Long id, @RequestBody ProdutosModel produtosModel){
        if (!servicer.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtosModel.setId(id);
        return ResponseEntity.ok(servicer.salvar(produtosModel));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        if (!servicer.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        servicer.deletar(id);
       
        return ResponseEntity.noContent().build();
        
    }
}
