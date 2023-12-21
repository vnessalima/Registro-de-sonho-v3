package projeto.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.*;
import lombok.Data;

//@Document
@Entity
@EntityScan(basePackages = "registrodesonhoatt.registrodesonhoatt.models")
@Table (name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String login;

    @OneToMany
    private List<Sonho> historico = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString(){
        return "Usuario [id= "+ id + ", nome=" + nome + ", login=" + login + "]";
    }

    public Object getEmail() {
        return null;
    }
    
    public void setEmail(String email) {
    }
}