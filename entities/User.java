package entities;

public abstract class User {
    private String nome;
    private String senha;
    private String login;


    public User() {
    }


    public User(String nome, String senha, String login) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



}
