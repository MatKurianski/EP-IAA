import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class Viajante {
    private LinkedList<Tesouro> tesouros;
    private LinkedList<Posicao> posicoesVisitadas;
    private IOpcao opcao;
    private Mapa mapa;

    private double tempoPassado;
    private int pesoTesouros;
    private int dinheiroTesouros;

    public Viajante(String mapa, IOpcao opcao) {
        this.tesouros = new LinkedList<>();
        this.posicoesVisitadas = new LinkedList<>();
        this.mapa = new Mapa(mapa);
        this.opcao = opcao;
        
        this.tempoPassado = 0;
        this.pesoTesouros = 0;
        this.dinheiroTesouros = 0;

        Posicao partida = this.mapa.getPartida();
        visitarPosicao(partida.getLinha(), partida.getColuna());
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

    public void visitarPosicao(int lin, int col) {
        if(lin > this.mapa.getMaxLin() || 
           col > this.mapa.getMaxCol() ||
           col < 0                     ||
           lin < 0
        ) return;

        Posicao posicao = mapa.getPosicao(lin, col);
        if(posicao.estaBloqueada() || posicao.foiVisitada()) return;

        if(posicao != this.mapa.getPartida()) {
            posicao.setTempoParaChegar(this.tempoParaChegar());
            this.tempoPassado += tempoParaChegar();
        }

        posicoesVisitadas.add(posicao);
        posicao.setFoiVisitada(true);

        if(posicao.temTesouro()) {
            Tesouro tesouro = posicao.getTesouro();
            this.pesoTesouros += tesouro.getPeso();
            this.dinheiroTesouros += tesouro.getValor();

            this.tesouros.add(tesouro);
        }

        boolean ehDestino = this.mapa.getDestino() == posicao ? true : false;
        
        if(ehDestino) {
            opcao.atualizarMelhorCaminho(posicoesVisitadas, tesouros, getTempoPassado(), getNumItens(), getValorItens(), getPesoTesouros());
        } else {
            visitarPosicao(lin+1, col);
            visitarPosicao(lin-1, col);
            visitarPosicao(lin, col+1);
            visitarPosicao(lin, col-1);
        }
        deixarPosicao(posicao);
    }

    public void deixarPosicao(Posicao posicao) {
        if(posicao.temTesouro()) {
            Tesouro tesouro = posicao.getTesouro();
            this.dinheiroTesouros -= tesouro.getValor();
            this.pesoTesouros -= tesouro.getPeso();
            
            this.tesouros.remove(tesouro);
        }
        posicao.setFoiVisitada(false);
        this.posicoesVisitadas.remove(posicao);
    }
}