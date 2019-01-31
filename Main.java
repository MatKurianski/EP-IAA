public class Main {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Uso: java EP <arquivo com definição do labirinto> <criterio>");
            return;
        } else {
            Viajante viajante = new Viajante(args[0], Integer.parseInt(args[1]));
            viajante.visitarPosicao(3, 2);
            viajante.visitarPosicao(1, 2);
            viajante.visitarPosicao(3, 1);
            viajante.imprimirCaminho();
        }
    }
}