package dw.mensalidade.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private LocalDate datanasc;

    public Jogador(){

    }

    public Jogador(long id, String nome, String email, LocalDate datanasc){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.datanasc = datanasc;
    }
    
    public Jogador(String nome, String email, LocalDate datanasc){
        
        this.nome = nome;
        this.email = email;
        this.datanasc = datanasc;
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
     public void setDataNasc(LocalDate datanasc){
        this.datanasc = datanasc;
    }

    public LocalDate getDataNasc(){
        return datanasc;
    }
}
