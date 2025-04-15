package br.gov.sp.fatec.estudoSpringBoot2025.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.estudoSpringBoot2025.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

    public List<Livro> findByTituloContainsAndDataLancamentoGreaterThan(String titulo, LocalDate data);


    @Query("select l from Livro l where l.titulo like %?1% and l.dataLancamento > ?2")
    public List<Livro> buscarPorTituloEData(String titulo, LocalDate data);
    
}
