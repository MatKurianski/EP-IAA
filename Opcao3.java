import java.util.LinkedList;

public class Opcao3 extends IOpcao {
    
    @Override
    public void atualizarMelhorCaminho(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int numItems, int valItens, int pesoItens) {
        if(this.tempo == 0 || this.tempo > tempo)
            atualizarInformacoes(posicoesAndadas, tesouros, tempo, numItems, valItens, pesoItens);
    }
}