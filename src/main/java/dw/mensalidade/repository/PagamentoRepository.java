package dw.mensalidade.repository;
import java.util.List;
import dw.mensalidade.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {   
    List<Pagamento> findByJogador_Id(Long id); 
}
