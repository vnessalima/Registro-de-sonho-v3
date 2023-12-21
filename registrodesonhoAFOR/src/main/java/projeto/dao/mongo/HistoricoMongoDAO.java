package projeto.dao.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.dao.HistoricoDAO;
import projeto.models.Historico;


import java.util.List;

@Repository
@Primary
public interface HistoricoMongoDAO extends HistoricoDAO, MongoRepository<Historico, String> {
    
    @Query("{'usuario.nome' : { $regex: ?0, $options: 'i' }}")
    List<Historico> findHistoricoByNomeUsuario(String nomeUsuario);
    
    @Query("{'usuario.nome' : ?0}")
    int contarSonhosPorUsuario(String nomeUsuario);
}
