package dw.mensalidade.control;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dw.mensalidade.model.Pagamento;
import dw.mensalidade.repository.PagamentoRepository;

@RestController
public class PagamentoController {

    @Autowired
    PagamentoRepository rep;
    
    @PostMapping("/pagamento")
    public ResponseEntity<Pagamento> createPagamento(@RequestBody Pagamento pa){
        try{
            Pagamento a = rep.save(new Pagamento(pa.getValor(),pa.getJogador(),pa.getMes(),pa.getAno()));
            return new ResponseEntity<>(a,HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pagamento")
    public ResponseEntity<List<Pagamento> > getAllPagamento(@RequestParam (required = false) Long jogadorId){
        try{
            List<Pagamento> la = new ArrayList<Pagamento>();

            if(jogadorId == null)
                rep.findAll().forEach(la::add);
            else    
                rep.findByJogador_Id(jogadorId).forEach(la::add);
            
            if(la.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    
            
            return new ResponseEntity<>(la,HttpStatus.OK);    
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pagamento/{id}")
    public ResponseEntity<Pagamento> updatePagamento(@PathVariable("id") long id, @RequestBody Pagamento a){
        Optional<Pagamento> data = rep.findById(id);

        if(data.isPresent()){
            Pagamento pa = data.get();
            pa.setValor(a.getValor());
            pa.setAno(a.getAno());
            pa.setMes(a.getMes());

            return new ResponseEntity<>(rep.save(pa), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/pagamento/{id}")
    public ResponseEntity<HttpStatus> deletePagamento(@PathVariable("id") long id){
        try{
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
