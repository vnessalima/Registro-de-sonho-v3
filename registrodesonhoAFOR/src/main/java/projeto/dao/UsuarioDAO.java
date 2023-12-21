package projeto.dao;

import java.util.List;

import projeto.models.Usuario;

public interface UsuarioDAO{
    List<Usuario> findByNome(String nome);

    Usuario findByLogin(String login);

    List<Usuario> findByNomeStartingWithIgnoreCase(String nome);

    void save(Usuario usuario);

    List<Usuario> findAll();
}

//salvar novo usuario
//listar todos os usuários
//buscar usuario por nome