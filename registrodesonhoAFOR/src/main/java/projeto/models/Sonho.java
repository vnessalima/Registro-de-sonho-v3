package projeto.models;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.*;
import lombok.Data;

@Document
@Entity
@Table (name = "sonho")
@Data
public class Sonho {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String tema;
    @Column(nullable = false)

    private String descricao;
    @Column(nullable = false)

    private String data;
    @Column(nullable = false)

    private String hora;
    @Column(nullable = false)

    private String emocao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")  
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "historico_id") 
    private Historico historico;

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getEmocoes() {
        return emocao;
    }
    public void setEmocoes(String emocao) {
        this.emocao = emocao;
    }
}
