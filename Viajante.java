/*
    Nome: Matheus Aquati Kurianski
    NºUSP: 10687541
*/

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
        this.tesouros = new LinkedList<Tesouro>();
        this.posicoesVisitadas = new LinkedList<Posicao>();
        this.opcao = opcao;
        this.mapa = new Mapa(mapa);
        
        this.tempoPassado = 0;
        this.pesoTesouros = 0;
        this.dinheiroTesouros = 0;

        Posicao partida = this.mapa.getPartida();
        if(partida != null) {
            visitarPosicao(partida.getLinha(), partida.getColuna());
        } else {
            System.out.println("O mapa não foi encontrado ou é inválido. Verifique o arquivo e tente novamente");
            System.exit(126);
        }
    }

    public double tempoParaChegar() {
        double num = 1.0 +  (pesoTesouros / 10.0);
        double intervalo = Math.pow(num, 2);

        return intervalo;
    }

    public int getPesoTesouros() {
        return this.pesoTesouros;
    }

    public double getTempoPassado() {
        return this.tempoPassado;
    }

    public int getValorItens() {
        return this.dinheiroTesouros;
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
            opcao.atualizarMelhorCaminho(posicoesVisitadas, tesouros, getTempoPassado(), getValorItens(), getPesoTesouros());
        } else {
            visitarPosicao(lin-1, col);
            visitarPosicao(lin, col+1);
            visitarPosicao(lin+1, col);
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
        this.tempoPassado -= posicao.getTempoParaChegar();
        this.posicoesVisitadas.remove(posicao);
    }
}