import java.util.LinkedList;

interface IOpcao {
    void atualizarMelhorCaminho(LinkedList<Posicao> posicoes, LinkedList<Tesouro> tesouros, double tempo, int numItems, int valItens, int pesoItens);
    void imprimirMelhorCaminho();
}