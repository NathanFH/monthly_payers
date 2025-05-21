package dw.mensalidade.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import dw.mensalidade.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    List<Jogador> findByNomeContainingIgnoreCase(String nome);
    
}
