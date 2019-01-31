import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Mapa {
    private Posicao[][] mapa;

    public Mapa(String arquivo) {
        gerarMapa(arquivo);
    }

    public Posicao getPosicao(int lin, int col) {
        return mapa[lin][col];
    }

    public void imprimirMapa() {
        for(Posicao[] colunas : this.mapa) {
            for(Posicao posicao : colunas) {
                Character charPosicao = posicao.estaBloqueada() ? 'X' : '.';
                System.out.print(charPosicao.toString());
            }
            System.out.println();
        }
    }

    void gerarMapa(String arquivo) {
        BufferedReader b;

        try {
            b = new BufferedReader(new FileReader(arquivo));
            String[] primeiraLinha = b.readLine().split(" ");
            
            int lin = Integer.parseInt(primeiraLinha[0]);
            int col = Integer.parseInt(primeiraLinha[1]);

            this.mapa = new Posicao[lin][col];

            System.out.println("Linha: "+lin+"\n"+
                                "Coluna: "+col);

            for(int i = 0; i < lin; i++) {
                char[] colunas = b.readLine().toCharArray();
                for(int j = 0; j < col; j++) {
                    this.mapa[i][j] = new Posicao(colunas[j], i, j);
                }
            }

            imprimirMapa();

        } catch(IOException e) {}
    }
}