package Exercicio1;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    static ArrayList<Filme> filmes = new ArrayList<>();
    static ArrayList<Ator> atores = new ArrayList<>();
    static ArrayList<Diretor> diretores = new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            // Exibe o menu de opções
            String[] options = {"Adicionar Ator", "Adicionar Diretor", "Adicionar Filme", "Listar Filmes", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            // Trata a escolha do usuário
            switch (choice) {
                case 0: // Adicionar Ator
                    criarAtor();
                    break;
                case 1: // Adicionar Diretor
                    criarDiretor();
                    break;
                case 2: // Adicionar Filme
                    adicionarFilme();
                    break;
                case 3: // Listar Filmes
                    listarFilmes();
                    break;
                case 4: // Sair
                    JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        }
    }

    public static void criarAtor() {
        Ator ator = new Ator();
        atores.add(ator);
    }

    public static void criarDiretor() {
        Diretor diretor = new Diretor();
        diretores.add(diretor);
    }

    public static void adicionarFilme() {
        Filme filme = new Filme();
        filmes.add(filme);
    }

    public static void listarFilmes() {
        StringBuilder listaFilmes = new StringBuilder("Lista de Filmes:\n");

        for (Filme filme : filmes) {
            listaFilmes.append(filme).append("\n");
            // Procura os atores associados ao filme
            for (Ator ator : atores) {
                if (ator.getFilme().equals(filme.getNome())) {
                    listaFilmes.append("Ator: ").append(ator.getNome()).append("\n");
                }
            }
            listaFilmes.append("\n");
        }

        JOptionPane.showMessageDialog(null, listaFilmes.toString());
    }
}