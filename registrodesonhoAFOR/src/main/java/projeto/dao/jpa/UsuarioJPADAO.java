package projeto.dao.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.dao.UsuarioDAO;
import projeto.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

@Repository
public interface UsuarioJPADAO extends UsuarioDAO, JpaRepository<Usuario, String> {

    // Métodos padrão do Spring Data JPA

    List<Usuario> findByNomeStartingWithIgnoreCase(String str);

    // Consultas personalizadas

    @Query("select u from Usuario u where lower(u.nome) like lower(concat('%', :nome, '%'))")
    List<Usuario> buscaPorNomeContendoString(String nome);

    @Query(value = "select count(*) from usuarios u", nativeQuery=true)
    int conta();

    // Método personalizado para buscar usuário por login
    @Query("select u from Usuario u where u.login = :login")
    Usuario findByLogin(String login);
}
