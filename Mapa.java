import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Mapa {
    private char[][] mapa;

    public Mapa(String arquivo) {
        gerarMapa(arquivo);
    }

    private void imprimirMapa() {
        for(char[] mapa1 : this.mapa) {
            for(char mapa2 : mapa1) {
                System.out.print(""+mapa2);
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

            this.mapa = new char[lin][col];

            System.out.println("Linha: "+lin+"\n"+
                                "Coluna: "+col);

            for(int i = 0; i < lin; i++) {
                char[] colunas = b.readLine().toCharArray();
                for(int j = 0; j < col; j++) {
                    this.mapa[i][j] = colunas[j];
                }
            }

            imprimirMapa();

        } catch(IOException e) {}
    }
}