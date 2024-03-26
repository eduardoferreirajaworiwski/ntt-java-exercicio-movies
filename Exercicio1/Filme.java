package Exercicio1;

import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Filme {
    private String nome;
    private String localFilmagem;
    private String nomeDiretor;
    private int tempoFilmagem;
    private Date dataInicio;
    private Date dataFim;

    public Filme() {
        this.nome = JOptionPane.showInputDialog("Digite o nome do filme:");
        // Solicita o nome do diretor até que um nome válido seja fornecido
        do {
            this.nomeDiretor = JOptionPane.showInputDialog("Digite o nome do diretor:");
            if (this.nomeDiretor == null || this.nomeDiretor.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome do diretor inválido. Por favor, digite novamente.");
            }
        } while (this.nomeDiretor == null || this.nomeDiretor.trim().isEmpty());

        this.localFilmagem = JOptionPane.showInputDialog("Digite o local de filmagem:");
        this.tempoFilmagem = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de filmagem (em dias):"));
        this.dataInicio = obterData("Digite a data de início (dd/mm/aaaa):");
        this.dataFim = obterData("Digite a data de fim (dd/mm/aaaa):");
    }

    private Date obterData(String mensagem) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String dataStr = JOptionPane.showInputDialog(mensagem);
                return formatter.parse(dataStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/mm/aaaa");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalFilmagem() {
        return localFilmagem;
    }

    public void setLocalFilmagem(String localFilmagem) {
        this.localFilmagem = localFilmagem;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public int getTempoFilmagem() {
        return tempoFilmagem;
    }

    public void setTempoFilmagem(int tempoFilmagem) {
        this.tempoFilmagem = tempoFilmagem;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "Filme: " + nome + ", Diretor: " + nomeDiretor + ", Local de Filmagem: " + localFilmagem +
                ", Tempo de Filmagem: " + tempoFilmagem + " dias, Data de Início: " + formatter.format(dataInicio) +
                ", Data de Fim: " + formatter.format(dataFim);
    }
}
