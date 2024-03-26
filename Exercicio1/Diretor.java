package Exercicio1;

import java.util.Scanner;

public class Diretor {
    private String nome;
    private int idade;
    private String nomeFilme; // Adicione um campo para o nome do filme

    public Diretor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do diretor: ");
        this.nome = scanner.nextLine();

        System.out.print("Digite a idade do Exercicio1.Diretor: ");
        this.idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o filme do diretor: ");
        this.nomeFilme = scanner.nextLine();
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

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    @Override
    public String toString() {
        return "Diretor: " + nome + ", Idade: " + idade + ", Filme: " + nomeFilme;
    }
}
