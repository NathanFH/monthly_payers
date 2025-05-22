package dw.mensalidade.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="jogador")
public class Jogador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    @JsonProperty("datanasc")
    private LocalDate datanasc;

    @OneToMany(mappedBy = "jogador", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private List<Pagamento> pagamentos;

    public Jogador(){

    }

    public Jogador(long id, String nome, String email, LocalDate dataNasc){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.datanasc = dataNasc;
    }
    
    public Jogador(String nome, String email, LocalDate dataNasc){
        
        this.nome = nome;
        this.email = email;
        this.datanasc = dataNasc;
    }

    public Jogador(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    //nome
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    //email
     public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    //datanasc
     public void setDatanasc(LocalDate dataNasc){
        this.datanasc = dataNasc;
    }

    public LocalDate getDatanasc(){
        return datanasc;
    }
}
