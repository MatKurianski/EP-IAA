import java.util.LinkedList;

public class Opcao1 implements IOpcao {
    LinkedList<Posicao> posicoesAndadas;
    LinkedList<Tesouro> tesouros;
    double tempo;
    int numItems;
    int valItens;
    int pesoItens;

    public Opcao1() {
        this.posicoesAndadas = null;
        this.tempo = 0;
        this.numItems = 0;
        valItens = 0;
        pesoItens = 0;
    }

    @Override
    public void atualizarMelhorCaminho(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int numItems, int valItens, int pesoItens) {
        if(this.posicoesAndadas == null || posicoesAndadas.size() < this.posicoesAndadas.size()) {
            this.posicoesAndadas = (LinkedList) posicoesAndadas.clone();
            this.tesouros = (LinkedList) tesouros.clone();
            this.tempo = tempo;
            this.numItems = numItems;
            this.valItens = valItens;
            this.pesoItens = pesoItens;
        }
    }

    @Override
    public void imprimirMelhorCaminho() {
        System.out.print(posicoesAndadas.size()+" "+tempo+"\n");
        for(Posicao posicao : posicoesAndadas) {
            posicao.imprimirLinhaColuna();
        }
        System.out.println(this.numItems+" "+this.valItens+" "+this.pesoItens);
        for(Tesouro tesouro : tesouros) {
            tesouro.imprimirLinhaColuna();
        }
    }
}