import java.util.LinkedList;

public class Opcao2 extends IOpcao {

    @Override
    public void atualizarMelhorCaminho(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int valItens, int pesoItens) {
        if(this.valItens == 0 || this.valItens < valItens) 
            atualizarInformacoes(posicoesAndadas, tesouros, tempo, valItens, pesoItens);
    }
}