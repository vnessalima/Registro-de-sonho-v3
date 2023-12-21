package projeto.dao.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.dao.SonhoDAO;
import projeto.models.Sonho;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

@Repository
public interface SonhoJPADAO extends SonhoDAO, JpaRepository<Sonho, String> {

    // Métodos padrão do Spring Data JPA

    List<Sonho> findByEmocaoIgnoreCase(String emocao);

    // Consultas personalizadas

    @Query("SELECT s FROM Sonho s WHERE s.emocao = :emocao AND s.data = :data")
    List<Sonho> findByEmocaoAndData(String emocao, String data);

    // Método personalizado para excluir sonho por ID
    void deleteById(String id);
}
