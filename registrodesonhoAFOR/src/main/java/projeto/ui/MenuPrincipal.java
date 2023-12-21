package projeto.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import lombok.extern.slf4j.Slf4j;

import javax.swing.JOptionPane;

@EntityScan("projeto.models")
@SpringBootApplication(scanBasePackages = "projeto")
//@EnableJpaRepositories("projeto.dao.jpa")
@EnableMongoRepositories("projeto.dao.mongo")
@Slf4j
public class MenuPrincipal implements CommandLineRunner {

    @Autowired
    private MenuUsuario menuUsuario;
    
    @Autowired
    private MenuSonho menuSonho;
    
    @Autowired
    private MenuHistorico menuHistorico;

    public static void main(String[] args) {
        new SpringApplicationBuilder(MenuPrincipal.class)
                .headless(false)
                .run(args);
    }

    @Override
    public void run(String... args) {
        StringBuilder menu = new StringBuilder("Menu Principal\n")
                .append("1 - Usuários\n")
                .append("2 - Sonhos\n")
                .append("3 - Histórico de Sonhos\n")
                .append("4 - Sair");

        char opcao = '0';
        do {
            try {
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1': // Usuários
                        menuUsuario.menu();
                        break;
                    case '2': // Sonhos
                        menuSonho.menu();
                        break;
                    case '3': // Histórico de Sonhos
                        menuHistorico.menu();
                        break;
                    case '4': // Sair
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        } while (opcao != '4');
    }

}

/*
consultas tipo:
JPQL
Native Query
Named Query
 */