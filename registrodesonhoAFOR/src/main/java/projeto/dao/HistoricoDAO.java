package projeto.dao;

import projeto.models.Historico;

import java.util.List;

public interface HistoricoDAO {

    List<Historico> findHistoricoByNomeUsuario(String nomeUsuario);

    int contarSonhosPorUsuario(String nomeUsuario);

}

//mostra quantos sonhos o usuario ja cadastrou.
