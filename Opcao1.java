/*
    Nome: Matheus Aquati Kurianski
    NºUSP: 10687541
*/

import java.util.LinkedList;

public class Opcao1 extends IOpcao {
    
    @Override
    public void atualizarMelhorCaminho(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int valItens, int pesoItens) {
        if(this.posicoesAndadas == null || posicoesAndadas.size() < this.posicoesAndadas.size())
            super.atualizarMelhorCaminho(posicoesAndadas, tesouros, tempo, valItens, pesoItens);
    }
}