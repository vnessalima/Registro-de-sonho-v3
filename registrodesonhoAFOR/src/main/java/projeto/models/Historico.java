package projeto.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.*;
import lombok.Data;

@Document
@Entity
@Table(name = "historico")
@Data
public class Historico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @DBRef
    private Usuario usuario;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historico")
    private List<Sonho> sonhos;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Sonho> getSonhos() {
        return sonhos;
    }
    
    public void setSonhos(List<Sonho> sonhos) {
        this.sonhos = sonhos;
    }
}