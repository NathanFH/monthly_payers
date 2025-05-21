package dw.mensalidade.control;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import dw.mensalidade.repository.JogadorRepository;
import dw.mensalidade.model.Jogador;

@RestController
public class JogadorController {
    
    @Autowired
    JogadorRepository rep;

    @PostMapping("/")
    public ResponseEntity<Jogador> createJogador(@RequestBody Jogador jo){
        try{
            Jogador a = rep.save(new Jogador(jo.getNome(),jo.getEmail(),jo.getDataNasc()));
            return new ResponseEntity<>(a, HttpStatus.CREATED);
        }catch(Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Jogador> > getAllJogador(@RequestParam(required = false) String nome){
        try{
            List<Jogador> la = new ArrayList<Jogador>();

            if(nome == null)
                rep.findAll().forEach(la::add);
            else
                rep.findByNomeContainingIgnoreCase(nome).forEach(la::add);    

            if(la.isEmpty())    
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(la,HttpStatus.OK);    
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> updateJogador(@PathVariable("id") long id, @RequestBody Jogador a){
        Optional<Jogador> data = rep.findById(id);

        if(data.isPresent()){
            Jogador jo = data.get();
            jo.setNome(jo.getNome());
            jo.setEmail(jo.getEmail());
            jo.setDataNasc(jo.getDataNasc());

            return new ResponseEntity<>(rep.save(jo), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteJogador(@PathVariable("id")long id){
        try{
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
