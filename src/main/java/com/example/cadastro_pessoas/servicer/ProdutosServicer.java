package com.example.cadastro_pessoas.servicer;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.repository.ProdutosRepository;

@Service
public class ProdutosServicer {


    @Autowired
    private ProdutosRepository repository;

    public List<ProdutosModel> listarTodos(){
        return repository.findAll();

    }
    
    public Optional<ProdutosModel> buscarPorId(Long id){
        return repository.findById(id);

    }

    public ProdutosModel salvar(ProdutosModel produtosModel){
        return repository.save(produtosModel);

    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
