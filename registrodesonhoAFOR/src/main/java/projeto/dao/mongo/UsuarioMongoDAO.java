package projeto.dao.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.dao.UsuarioDAO;
import projeto.models.Usuario;

import java.util.List;

@Repository
@Primary
public interface UsuarioMongoDAO extends UsuarioDAO, MongoRepository<Usuario, String> {
    List<Usuario> findByNomeStartingWithIgnoreCase(String nome);

}