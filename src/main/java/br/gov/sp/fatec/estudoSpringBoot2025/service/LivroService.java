package br.gov.sp.fatec.estudoSpringBoot2025.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.estudoSpringBoot2025.entity.Livro;
import br.gov.sp.fatec.estudoSpringBoot2025.repository.LivroRepository;

@Service
public class LivroService {
    
      @Autowired
      private LivroRepository livroRepo;

       public List<Livro> listarTodos(){
        return livroRepo.findAll();
    }


    public Livro novo(Livro livro) {
    if (livro.getDataLancamento() == null) {
        livro.setDataLancamento(LocalDate.now());
    }

    if (livro.getEdicao() == null || livro.getEdicao() <= 0) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Edição deve ser superior a zero.");
    }

    if (livro.getPaginas() != null && livro.getPaginas() <= 50) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Número de páginas deve ser superior a 50.");
    }

    return livroRepo.save(livro);
}

public List<Livro> buscarPorTituloEDataLancamento( String titulo, LocalDate data){
    return livroRepo.buscarPorTituloEData(titulo, data);
}

    
}
