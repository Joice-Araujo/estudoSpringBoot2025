package br.gov.sp.fatec.estudoSpringBoot2025.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.estudoSpringBoot2025.entity.Usuario;
import br.gov.sp.fatec.estudoSpringBoot2025.repository.UsuarioRepository;

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<Usuario> listarTodos(){
        return usuarioRepo.findAll();
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isPresent()) {
            return usuarioOp.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado!");
    }

    public Usuario novo(Usuario usuario){
        if(usuario == null ||
        usuario.getNome()== null ||
        usuario.getNome().isBlank() ||
        usuario.getSenha() == null || 
        usuario.getSenha().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        return usuarioRepo.save(usuario);
    }
    
}
