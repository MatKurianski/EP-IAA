/*
    Nome: Matheus Aquati Kurianski
    NºUSP: 10687541
*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mapa {
    private Posicao[][] mapa;
    private Posicao partida;
    private Posicao destino;

    public Mapa(String arquivo) {
        gerarMapa(arquivo);
    }

    public Posicao getPosicao(int lin, int col) {
        return mapa[lin][col];
    }

    public int getMaxLin() {
        return this.mapa.length-1;
    }

    public int getMaxCol() {
        return this.mapa[0].length-1;
    }

    public Posicao getPartida() {
        return this.partida;
    }

    public Posicao getDestino() {
        return this.destino;
    }

    private void gerarMapa(String arquivo) {
        BufferedReader b;

        try {
            b = new BufferedReader(new FileReader(arquivo));
            String[] primeiraLinha = b.readLine().split(" ");
            
            int lin = Integer.parseInt(primeiraLinha[0]);
            int col = Integer.parseInt(primeiraLinha[1]);

            this.mapa = new Posicao[lin][col];

            for(int i = 0; i < lin; i++) {
                char[] colunas = b.readLine().toCharArray();
                for(int j = 0; j < col; j++) {
                    this.mapa[i][j] = new Posicao(colunas[j], i, j);
                }
            }

            int numItens = Integer.parseInt(b.readLine());

            String[] tesouro;
            
            int linTesouro;
            int colTesouro;
            int valorTesouro;
            int pesoTesouro;

            for(int i = 0; i < numItens; i++) {
                tesouro = b.readLine().split(" ");

                linTesouro = Integer.parseInt(tesouro[0]);
                colTesouro = Integer.parseInt(tesouro[1]);

                valorTesouro = Integer.parseInt(tesouro[2]);
                pesoTesouro = Integer.parseInt(tesouro[3]);

                Posicao posicao = this.mapa[linTesouro][colTesouro];
                posicao.setTesouro(valorTesouro, pesoTesouro);
            }
            
            String[] partida = b.readLine().split(" ");

            int linPartida = Integer.parseInt(partida[0]);
            int colPartida = Integer.parseInt(partida[1]);

            String[] destino = b.readLine().split(" ");

            int linDestino = Integer.parseInt(destino[0]);
            int colDestino = Integer.parseInt(destino[1]);

            this.partida = this.mapa[linPartida][colPartida];
            this.destino = this.mapa[linDestino][colDestino];
        } catch(IOException e) {}
    }
}