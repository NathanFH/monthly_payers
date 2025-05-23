package dw.mensalidade.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pagamento")
public class Pagamento {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private int mes;

    @Column(nullable = false)
    private float valor;

    @ManyToOne
    @JoinColumn(name = "cod_jogador", nullable = false)
    private Jogador jogador;

    public Pagamento(){

    }

    public Pagamento(long id, int ano, int mes, float valor,Jogador jogador){
        this.id = id;
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
        this.jogador = jogador;
    }

     public Pagamento(float valor,Jogador jogador, int mes,int ano){
    
        this.valor = valor;
        this.jogador = jogador;
        this.mes = mes;
        this.ano = ano;
        
    }

    public Pagamento(long id){
        this.id = id;
    }

    public Pagamento(long id,Jogador jogador){
        this.id = id;
        this.jogador = jogador;
    }

    public long getId(){
        return id;
    }

     //ano
    public void setAno(int ano){
        this.ano = ano;
    }

    public int getAno(){
        return ano;
    }

     //mes
    public void setMes(int mes){
        this.mes = mes;
    }

    public int getMes(){
        return mes;
    }

     //valor
    public void setValor(float valor){
        this.valor = valor;
    }

    public float getValor(){
        return valor;
    }

    //jogador
    public void setJogador(Jogador jogador){
        this.jogador = jogador;
    }

    public Jogador getJogador(){
        return jogador;
    }
}
