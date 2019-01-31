public class Main {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Uso: java EP <arquivo com definição do labirinto> <criterio>");
            return;
        } else {
            new Mapa(args[0]);
        }
    }
}