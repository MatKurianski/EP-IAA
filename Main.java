public class Main {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Uso: java EP <arquivo com definição do labirinto> <criterio>");
            return;
        } else {
            new Viajante(args[0], Integer.parseInt(args[1]));
        }
    }
}