package br.gov.sp.fatec.estudoSpringBoot2025.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.estudoSpringBoot2025.entity.Trabalho;
import br.gov.sp.fatec.estudoSpringBoot2025.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public List<Trabalho> listarTodos(){
        return trabalhoRepo.findAll();
    }


    public Trabalho novo(Trabalho trabalho){
        if(trabalho == null ||
        trabalho.getTitulo()== null ||
        trabalho.getTitulo().isBlank() ||
        trabalho.getGrupo() == null || 
        trabalho.getGrupo().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(trabalho.getDataHoraEntrega() == null){
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }
        return trabalhoRepo.save(trabalho);
    }

    public List<Trabalho> buscarPorTituloENota(String titulo, Integer nota){
        return trabalhoRepo.buscarPorTituloENota(titulo, nota);
    }

    
}
