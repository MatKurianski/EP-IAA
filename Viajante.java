import java.util.LinkedList;

public class Viajante {
    private LinkedList<Tesouro> tesouros;
    private LinkedList<Posicao> posicoesVisitadas;
    private Mapa mapa;
    private int opcao;

    private float tempo;
    private int pesoTesouros;
    private int dinheiroTesouros;

    public Viajante(String mapa, int opcao) {
        this.tesouros = new LinkedList<>();
        this.posicoesVisitadas = new LinkedList<>();
        this.mapa = new Mapa(mapa);
        this.opcao = opcao;
        
        this.tempo = 0;
        this.pesoTesouros = 0;
        this.dinheiroTesouros = 0;
    }

    public void imprimirCaminho() {
        System.out.println("\nCaminho percorrido:\n");
        for (Posicao posicao : posicoesVisitadas) {
            posicao.imprimirLinhaColuna();
        }
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