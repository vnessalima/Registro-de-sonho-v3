package projeto.dao;

import projeto.models.Sonho;

import java.util.List;

public interface SonhoDAO{
    List<Sonho> findByEmocaoAndData(String emocao, String data);

    List<Sonho> findByEmocaoIgnoreCase(String emocao);

    void deleteById(long id);
}

//consultar sonho por emocao e data.
//excluir sonho com base no ID dele.