import br.com.grenno.register.DAO.CustomerDAO;
import br.com.grenno.register.DAO.ProductDAO;
import br.com.grenno.register.DAO.generic.GenericDAO;
import br.com.grenno.register.domain.Customer;
import br.com.grenno.register.domain.IPersistent;

import javax.swing.*;

public class App {

    private static GenericDAO genericDAO;

    public static void main(String[] args) {
        String firstOption = JOptionPane.showInputDialog(null,
                "Opções de gerenciamento: 1 - Cliente e 2 - Produto",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        if(firstOption.equals("1")) {
            genericDAO = new CustomerDAO();
        } else {
            genericDAO = new ProductDAO();
        }

        String option = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isValidOption(option)) {
            if ("".equals(option)) {
                sair();
            }
            option = JOptionPane.showInputDialog(null,
                    "Opção inválida digite 1 para cadastro, 2 para consulta, 3 para cadastro, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isValidOption(option)) {
            if (isExitOption(option)) {
                sair();
            } else if (isRegisterOption(option)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                register(dados);
            } else if(isFindOption(option)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o cpf",
                        "Consultar", JOptionPane.INFORMATION_MESSAGE);

                find(dados);
            }

            option = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para cadastro, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void find(String dados) {
        //Validar se foi passado somente o cpf
        IPersistent entity = genericDAO.find(Long.parseLong(dados));
        if (entity != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + entity, "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isFindOption(String opcao) {
        return "2".equals(opcao);
    }

    private static void register(String dados) {
        String[] dadosSeparados = dados.split(",");
        //Tentar validar se todos os campos estão preenchidos.
        //Se não tiver, passr null no construtor onde o valor é nulo
        //Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],null,dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6])
        Customer cliente = new Customer(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        Boolean isCadastrado = genericDAO.register(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isRegisterOption(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isExitOption(String opcao) {
        return "5".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo.", "Sair",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isValidOption(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao)
                || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }
}