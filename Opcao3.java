/*
    Nome: Matheus Aquati Kurianski
    NºUSP: 10687541
*/

import java.util.LinkedList;

public class Opcao3 extends IOpcao {
    
    @Override
    public void atualizarMelhorCaminho(LinkedList<Posicao> posicoesAndadas, LinkedList<Tesouro> tesouros, double tempo, int valItens, int pesoItens) {
        if(this.tempo == 0 || this.tempo > tempo)
            super.atualizarMelhorCaminho(posicoesAndadas, tesouros, tempo, valItens, pesoItens);
    }
}