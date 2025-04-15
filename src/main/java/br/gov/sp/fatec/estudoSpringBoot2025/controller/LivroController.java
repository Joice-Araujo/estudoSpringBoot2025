package br.gov.sp.fatec.estudoSpringBoot2025.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.estudoSpringBoot2025.entity.Livro;
import br.gov.sp.fatec.estudoSpringBoot2025.service.LivroService;

@RestController
@CrossOrigin
@RequestMapping(value = "/livro")
public class LivroController {

     @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> buscarTrabalhos(){
        return service.listarTodos();
    }

    @PostMapping
    public Livro novoLivro(@RequestBody Livro livro){
        return service.novo(livro);
    }

     @GetMapping(value = "/{titulo}/{dataLancamento}")
    public List<Livro> buscarTituloEDataLancamento(@PathVariable("titulo") String titulo, @PathVariable("dataLancamento") LocalDate data){
        return service.buscarPorTituloEDataLancamento(titulo, data);
    }
    
}
