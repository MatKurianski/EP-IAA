public class Main {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Uso: java EP <arquivo com definição do labirinto> <criterio>");
            return;
        } else {
            Viajante viajante = new Viajante(args[0]);
            viajante.visitarPosicao(6, 2);
            viajante.visitarPosicao(5, 2);
            viajante.visitarPosicao(4, 2);
            viajante.visitarPosicao(3, 2);
            viajante.visitarPosicao(2, 2);
            viajante.visitarPosicao(1, 2);
            viajante.visitarPosicao(0, 2);

            System.out.println(viajante.getTamanhoCaminho()+" "+viajante.getTempoPassado());

            viajante.imprimirCaminho();

            System.out.println(viajante.getNumItens()+" "+viajante.getValorItens()+" "+viajante.getPesoTesouros());
            viajante.imprimirItensColetados();
        }
    }
}