public class Posicao {
    private int lin;
    private int col;
    private boolean estaBloqueada;
    private Tesouro tesouro;

    public Posicao(char c, int lin, int col) {
        this.lin = lin;
        this.col = col;
        this.estaBloqueada = c == 'X' ? true : false;
        this.tesouro = null;
    }

    public int getLinha() {
        return this.lin;
    }

    public int getColuna() {
        return this.col;
    }

    public boolean temTesouro() {
        return tesouro != null ? true : false;
    }

    public boolean estaBloqueada() {
        return estaBloqueada ? true : false;
    }

    public void setTesouro(int valor, int peso) {
        tesouro = new Tesouro(valor, peso, getLinha(), getColuna());
    }
}