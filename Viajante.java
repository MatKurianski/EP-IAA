import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class Viajante {
    private LinkedList<Tesouro> tesouros;
    private LinkedList<Posicao> posicoesVisitadas;
    private Mapa mapa;

    private double tempoPassado;
    private int pesoTesouros;
    private int dinheiroTesouros;

    public Viajante(String mapa) {
        this.tesouros = new LinkedList<>();
        this.posicoesVisitadas = new LinkedList<>();
        this.mapa = new Mapa(mapa);
        
        this.tempoPassado = 0;
        this.pesoTesouros = 0;
        this.dinheiroTesouros = 0;
    }

    public int getPesoTesouros() {
        return this.pesoTesouros;
    }

    public double tempoParaChegar() {
        double intervalo = Math.pow(1 + (this.pesoTesouros / 10.0), 2.0);

        return BigDecimal
        .valueOf(intervalo)
        .setScale(3, RoundingMode.HALF_UP)
        .doubleValue();
    }

    public double getTempoPassado() {
        return this.tempoPassado;
    }

    public int getNumItens() {
        return this.tesouros.size();
    }

    public int getTamanhoCaminho() {
        return this.posicoesVisitadas.size();
    }

    public int getValorItens() {
        return this.dinheiroTesouros;
    }

    public void imprimirCaminho() {
        for (Posicao posicao : posicoesVisitadas) {
            posicao.imprimirLinhaColuna();
        }
    }

    public void imprimirItensColetados() {
        for(Tesouro tesouro : this.tesouros) {
            tesouro.imprimirLinhaColuna();
        }
    }

    public boolean visitarPosicao(int lin, int col) {
        Posicao posicao = mapa.getPosicao(lin, col);
        if(posicao.estaBloqueada()) return false;

        if(posicao != this.mapa.getPartida()) {
            posicao.setTempoParaChegar(this.tempoParaChegar());
            this.tempoPassado += tempoParaChegar();
        }

        posicoesVisitadas.add(posicao);

        if(posicao.temTesouro()) {
            Tesouro tesouro = posicao.getTesouro();
            this.pesoTesouros += tesouro.getPeso();
            this.dinheiroTesouros += tesouro.getValor();

            this.tesouros.add(tesouro);
        }

        return mapa.getDestino() == posicao ? true : false;

    }

    public void deixarPosicao(Posicao posicao) {
        if(posicao.temTesouro()) {
            Tesouro tesouro = posicao.getTesouro();
            this.dinheiroTesouros -= tesouro.getValor();
            this.pesoTesouros -= tesouro.getPeso();
            
            this.tesouros.remove(tesouro);
        }
        this.posicoesVisitadas.remove(posicao);
    }
}