public class Tesouro {
    private int valor;
    private int peso;
    private int lin;
    private int col;

    public Tesouro(int valor, int peso, int lin, int col) {
        this.valor = valor;
        this.peso = peso;
        this.lin = lin;
        this.col = col;
    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }
    
    public void imprimirLinhaColuna() {
        System.out.println(lin+" "+col);
    }
}