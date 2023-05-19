import br.com.grenno.dao.CustomerMapDAO;
import br.com.grenno.dao.ICustomerDAO;
import br.com.grenno.domain.Customer;

import javax.swing.*;

public class Main {
    private static ICustomerDAO iCustomerDAO;
    public static void main(String[] args) {
        iCustomerDAO = new CustomerMapDAO();

        String option;

        option = showInputDialog(
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Acessar");

        while (!isValidOption(option)) {
            if ("".equals(option)) {
                exit();
            }
            option = showInputDialog(
                    "Opção inválida.\nDigite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Acessar");
        }

        while (isValidOption(option)) {
            if(isExitOption(option)) {
                exit();
            } else if (isRegister(option)) {
                String data = showInputDialog(
                        "Digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado.",
                        "Cadastro"
                );
                register(data);
            } else if (isFindOption(option)) {
                String doc = showInputDialog(
                        "Digite o CPF",
                        "Consultar");
                findCustomer(doc);
            }
            option = showInputDialog(
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Acessar");
        }
    }

    private static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void findCustomer(String doc) {
        // validate if doc passed can be parsed to Long
        long docAsNumber = 0;
        try {
            docAsNumber = Long.parseLong(doc);
        } catch (NumberFormatException error) {
            showMessageDialog("Dado inválido", "Erro");
        }
        Customer customer = iCustomerDAO.find(docAsNumber);
        if (customer != null) {
            showMessageDialog("Cliente encontrado:" + customer.toString(), "Sucesso");
        } else {
            showMessageDialog("Cliente não encontrado:", "Erro");
        }
    }

    private static boolean isFindOption(String option) {
        return "2".equals(option);
    }

    private static void register(String data) {
        String[] customerData = data.split(",");
        // validate all fields
        if (customerData.length != 7) {
            showMessageDialog("Dados inválidos", "Erro");
            return;
        }
        Customer newCustomer = new Customer(customerData[0], customerData[1], customerData[2], customerData[3], customerData[4], customerData[5], customerData[6]);
        Boolean isRegistered = iCustomerDAO.register(newCustomer);
        if (isRegistered) {
            showMessageDialog("Cliente cadastrado com sucesso", "Sucesso");
        } else {
            showMessageDialog("Cliente já cadastrado", "Erro");
        }
    }

    private static boolean isExitOption(String option) {
        return "5".equals(option);
    }

    private static void exit() {
        showMessageDialog( "Até logo", "Sair");
        System.exit(0);
    }

    private static boolean isValidOption(String option) {
        return "1".equals(option) || "2".equals(option) || "3".equals(option) || "4".equals(option) || "5".equals(option);
    }

    private static boolean isRegister(String option) {
        return "1".equals(option);
    }
}