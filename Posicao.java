public class Posicao {
    private int lin;
    private int col;
    private boolean estaBloqueada;
    private Tesouro tesouro;

    Posicao(char c, int lin, int col) {
        this.lin = lin;
        this.col = col;
        this.estaBloqueada = C == 'X' ? true : false;
        this.tesouro = null;
    }

    class Tesouro {
        private int valor;
        private int peso;

        Tesouro(int valor, int peso) {
            this.valor = valor;
            this.peso = peso;
        }

        int getPeso() {
            return peso;
        }

        int getValor() {
            return valor;
        }
    }
}