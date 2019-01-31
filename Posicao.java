public class Posicao {
    private int lin;
    private int col;
    private boolean estaBloqueada;
    private Tesouro tesouro;

    private double tempoParaChegar;

    public Posicao(char c, int lin, int col) {
        this.lin = lin;
        this.col = col;

        this.estaBloqueada = c == 'X' ? true : false;
        this.tesouro = null;
        this.tempoParaChegar = 0; // Porque o viajante ainda não acessou essa posição.
    }

    public int getLinha() {
        return this.lin;
    }

    public int getColuna() {
        return this.col;
    }

    public boolean estaBloqueada() {
        return estaBloqueada ? true : false;
    }

    public void setTesouro(int valor, int peso) {
        tesouro = new Tesouro(valor, peso, getLinha(), getColuna());
    }

    public boolean temTesouro() {
        return tesouro != null ? true : false;
    }

    public Tesouro getTesouro() {
        return temTesouro() ? tesouro : null;
    }

    public void setTempoParaChegar(double tempo) {
        this.tempoParaChegar = tempo;
    }

    public double getTempoParaChegar() {
        return this.tempoParaChegar;
    }

    public void imprimirLinhaColuna() {
        System.out.println(getLinha()+" "+getColuna());
    }

}