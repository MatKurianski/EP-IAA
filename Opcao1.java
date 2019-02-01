import java.util.LinkedList;

public class Opcao1 extends IOpcao {
    
    @Override
    public void atualizarMelhorCaminho(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int numItems, int valItens, int pesoItens) {
        if(this.posicoesAndadas == null || posicoesAndadas.size() < this.posicoesAndadas.size())
            atualizarInformacoes(posicoesAndadas, tesouros, tempo, numItems, valItens, pesoItens);
    }
}