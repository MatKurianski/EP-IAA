import java.util.LinkedList;

public class Viajante {
    private LinkedList<Tesouro> tesouros;
    private LinkedList<Posicao> posicoesVisitadas;
    private Mapa mapa;
    private int opcao;
    int pesoTesouros;
    int dinheiroTesouros;

    public Viajante(String mapa, int opcao) {
        this.tesouros = new LinkedList<>();
        this.mapa = new Mapa(mapa);
        this.opcao = opcao;

        pesoTesouros = 0;
        dinheiroTesouros = 0;
    }

    public void visitarPosicao(int lin, int col) {
        Posicao posicao = mapa.getPosicao(lin, col);
        if(posicao.estaBloqueada()) return;
        posicoesVisitadas.add(posicao);

        if(posicao.temTesouro()) {
            Tesouro tesouro = posicao.getTesouro();
            this.pesoTesouros += tesouro.getPeso();
            this.dinheiroTesouros += tesouro.getValor();

            this.tesouros.add(tesouro);
        }
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