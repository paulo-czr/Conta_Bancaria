package model;
public class DonoConta {

    public String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereço;

    public DonoConta(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
    }

    // Métodos

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome.trim();
        } else {
            throw new IllegalArgumentException("Insira um nome válido!");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("Insira um CPF válido.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException(
                    "E-mail inválido! Insira um e-mail no formato correto (ex: exemplo@dominio.com).");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone != null && telefone.matches("\\d{9,11}")) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException(
                    "Telefone inválido! Deve conter apenas números e ter entre 9 e 11 dígitos.");
        }
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
}