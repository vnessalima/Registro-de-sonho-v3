package projeto.dao.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.dao.SonhoDAO;
import projeto.models.Sonho;

import java.util.List;

@Repository
@Primary
public interface SonhoMongoDAO extends SonhoDAO, MongoRepository<Sonho, String> {
    List<Sonho> findByEmocaoIgnoreCase(String emocao);
}
