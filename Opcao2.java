import java.util.LinkedList;

public class Opcao2 extends IOpcao {

    @Override
    public void atualizarMelhorCaminho(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int numItems, int valItens, int pesoItens) {
        if(this.valItens < valItens) 
            atualizarInformacoes(posicoesAndadas, tesouros, tempo, numItems, valItens, pesoItens);
    }
}