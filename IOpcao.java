import java.util.LinkedList;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class IOpcao {
    LinkedList<Posicao> posicoesAndadas;
    LinkedList<Tesouro> tesouros;
    double tempo;
    int numItems;
    int valItens;
    int pesoItens;

    public IOpcao() {
        this.posicoesAndadas = null;
        this.tempo = 0;
        this.numItems = 0;
        valItens = 0;
        pesoItens = 0;
    }

    public abstract void atualizarMelhorCaminho(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int numItems, int valItens, int pesoItens);

    protected void atualizarInformacoes(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int numItems, int valItens, int pesoItens) {
        this.posicoesAndadas = (LinkedList) posicoesAndadas.clone();
        this.tesouros = (LinkedList) tesouros.clone();
        this.tempo = tempo;
        this.numItems = numItems;
        this.valItens = valItens;
        this.pesoItens = pesoItens;
    }
    public void imprimirMelhorCaminho() {
        BigDecimal tempoFormatado = new BigDecimal(Double.toString(this.tempo));
        tempoFormatado = tempoFormatado.setScale(2, RoundingMode.HALF_DOWN);
        
        System.out.print(this.posicoesAndadas.size()+" "+tempoFormatado.toString()+"\n");
        for(Posicao posicao : posicoesAndadas) {
            posicao.imprimirLinhaColuna();
        }
        System.out.println(this.numItems+" "+this.valItens+" "+this.pesoItens);
        for(Tesouro tesouro : tesouros) {
            tesouro.imprimirLinhaColuna();
        }
    }
}