package Exercicio1;

import javax.swing.JOptionPane;

public class Ator {
    private String nome;
    private int idade;
    private String filme;

    public Ator() {
        this.nome = JOptionPane.showInputDialog("Digite o nome do ator:");
        this.idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do ator:"));
        this.filme = JOptionPane.showInputDialog("Digite o filme do ator:");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Ator: " + nome + ", Idade: " + idade + ", Filme: " + filme;
    }
}
