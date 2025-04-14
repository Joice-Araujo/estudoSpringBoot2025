package br.gov.sp.fatec.estudoSpringBoot2025.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.estudoSpringBoot2025.entity.Usuario;
import br.gov.sp.fatec.estudoSpringBoot2025.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> buscUsuarios(){
        return service.listarTodos();
    }

    @GetMapping(value = "/{usuario}")
    public Usuario buscarPorIdUsuario(@PathVariable("usuario") Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario){
        return service.novo(usuario);
    }
}
