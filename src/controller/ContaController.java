package controller;

import java.util.ArrayList;
import java.util.List;

import model.ContaBanco;
import model.DonoConta;

public class ContaController {

    private List<ContaBanco> contas = new ArrayList<>();

    // Constutor que cria uma nova conta com os dados do dono
    public ContaBanco criarConta(String nome, String cpf, String email, String telefone, String endereco) {
        DonoConta dono = new DonoConta(nome, cpf);

        if (email != null && !email.isEmpty()) {
            dono.setEmail(email);
        }
        if (telefone != null && !telefone.isEmpty()) {
            dono.setTelefone(telefone);
        }
        if (endereco != null && !endereco.isEmpty()) {
            dono.setEndereço(endereco);
        }

        ContaBanco conta = new ContaBanco(dono);
        conta.setNumConta((int) (Math.random() * 9000) + 1000);
        conta.abrirConta("CC");

        contas.add(conta);
        return conta;
    }

    // Realiza depósito
    public void depositar(ContaBanco conta, float valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        conta.depositar(valor);
    }

    // Realiza saque
    public void sacar(ContaBanco conta, float valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        conta.sacar(valor);
    }

    public List<ContaBanco> getContas() {
        return contas;
    }

}
