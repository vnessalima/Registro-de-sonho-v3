package projeto.dao.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.dao.HistoricoDAO;
import projeto.models.Historico;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

@Repository
public interface HistoricoJPADAO extends HistoricoDAO, JpaRepository<Historico, String> {

    // Métodos padrão do Spring Data JPA

    List<Historico> findByUsuario_Nome(String nomeUsuario);

    // Consultas personalizadas

    @Query("SELECT h.usuario.nome as Usuario, COUNT(h) as quantidadeSonhos FROM Historico h WHERE h.usuario.nome = :nomeUsuario GROUP BY h.usuario.nome")
    int contarSonhosPorUsuario(String nomeUsuario);
}
