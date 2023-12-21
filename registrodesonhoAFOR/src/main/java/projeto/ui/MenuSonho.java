package projeto.ui;

import lombok.extern.slf4j.Slf4j;
import projeto.dao.SonhoDAO;
import projeto.models.Sonho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Slf4j
@Component
public class MenuSonho {

    @Autowired
    private SonhoDAO sonhoDAO;

    public void consultarSonhoPorEmocao() {
        String emocao = JOptionPane.showInputDialog("Digite a emoção desejada");
        List<Sonho> sonhos = sonhoDAO.findByEmocaoIgnoreCase(emocao);
        listaSonhos(sonhos);
    }

    public void consultarSonhoPorTurno() {
        String turno = JOptionPane.showInputDialog("Digite o turno desejado (manhã, tarde, noite)");
        List<Sonho> sonhos = sonhoDAO.findByEmocaoIgnoreCase(turno);
        listaSonhos(sonhos);
    }

    public void excluirSonhoPorId() {
        try {
            long id = Long.parseLong(JOptionPane.showInputDialog("Digite o ID do sonho a ser excluído"));
            sonhoDAO.deleteById(id);
            JOptionPane.showMessageDialog(null, "Sonho excluído com sucesso.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Certifique-se de digitar um número válido.");
        }
    }

    private void listaSonhos(List<Sonho> sonhos) {
        StringBuilder listagem = new StringBuilder();
        for (Sonho sonho : sonhos) {
            listagem.append(sonho.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum sonho encontrado" : listagem);
    }

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu Sonhos\n")
                .append("1 - Consultar Sonho por Emoção\n")
                .append("2 - Consultar Sonho por Turno\n")
                .append("3 - Excluir Sonho por ID\n")
                .append("4 - Sair");

        char opcao = '0';
        do {
            try {
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1': // Consultar Sonho por Emoção
                        consultarSonhoPorEmocao();
                        break;
                    case '2': // Consultar Sonho por Turno
                        consultarSonhoPorTurno();
                        break;
                    case '3': // Excluir Sonho por ID
                        excluirSonhoPorId();
                        break;
                    case '4': // Sair
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        } while (opcao != '4');
    }

    public void executar() {
    }
}

//consultar sonho por emocao e turno.
//excluir sonho com base no ID dele.