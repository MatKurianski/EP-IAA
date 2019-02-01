import java.util.LinkedList;
import java.text.DecimalFormat;

public abstract class IOpcao {
    LinkedList<Posicao> posicoesAndadas;
    LinkedList<Tesouro> tesouros;
    double tempo;
    int valItens;
    int pesoItens;

    public IOpcao() {
        this.posicoesAndadas = null;
        this.tempo = 0;
        this.valItens = 0;
        this.pesoItens = 0;
    }

    public abstract void atualizarMelhorCaminho(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int valItens, int pesoItens);

    protected void atualizarInformacoes(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int valItens, int pesoItens) {
        this.posicoesAndadas = new LinkedList<Posicao>(posicoesAndadas); // Clona as posições andadas.
        this.tesouros = new LinkedList<Tesouro>(tesouros); // Clona os tesouros coletados.
        this.tempo = tempo;
        this.valItens = valItens;
        this.pesoItens = pesoItens;
    }

    public void imprimirMelhorCaminho() {
        DecimalFormat tempoFormatado = new DecimalFormat("0.##"); 

        System.out.print(this.posicoesAndadas.size()+" "+tempoFormatado.format(tempo).replace(",", ".")+"\n");
        for(Posicao posicao : posicoesAndadas) {
            posicao.imprimirLinhaColuna();
        }
        System.out.println(this.tesouros.size()+" "+this.valItens+" "+this.pesoItens);
        for(Tesouro tesouro : tesouros) {
            tesouro.imprimirLinhaColuna();
        }
    }
}