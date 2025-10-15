package model;

public class ContaBanco {

    public int numConta;
    protected String tipo;
    public DonoConta dono;
    private float saldo;
    private boolean status;

    public ContaBanco(DonoConta dono) {
        this.dono = dono;
        this.saldo = 0;
        this.status = false;
    }

    // Getters e Setters
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public DonoConta getDono() {
        return dono;
    }

    public void setDono(DonoConta dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Métodos
    // Exibição
    public void exibirConta() {
        System.out.println("Número da Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono().getNome());
        System.out.printf("Saldo: R$ %.2f\n", this.getSaldo());
        System.out.println("-----------------------------");
    }

    // Abre uma conta
    public void abrirConta(String tipo) {
        this.setTipo(tipo);
        this.setStatus(true);

        if (this.getTipo().equalsIgnoreCase("CC")) {
            setSaldo(50);
        } else if (this.getTipo().equalsIgnoreCase("CP")) {
            setSaldo(150);
        }

        System.out.println("Conta aberta com sucesso!");
    }

    // Fecha uma conta
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta com dinheiro!");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta em débito!");
        } else {
            this.setStatus(false);
        }

        System.out.println("Conta fechada com sucesso!");
    }

    // Deposita na conta bancária
    public void depositar(float deposito) {
        if (!this.isStatus()) {
            throw new IllegalStateException("Conta inválida!");
        }
        if (deposito <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }

        this.setSaldo(this.getSaldo() + deposito);
    }

    // Saque na conta bancária
    public void sacar(float saque) {
        if (!this.isStatus()) {
            throw new IllegalStateException("Conta inválida!");
        }
        if (saque <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        if (this.getSaldo() < saque) {
            throw new IllegalArgumentException("Saldo insuficiente!");
        }

        this.setSaldo(this.getSaldo() - saque);
    }
    
}
