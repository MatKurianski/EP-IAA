public class Main {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Uso: java EP <arquivo com definição do labirinto> <criterio>");
            return;
        } else {
            IOpcao opcao = new Opcao1();
            Viajante viajante = new Viajante(args[0], opcao);
            
            opcao.imprimirMelhorCaminho();
        }
    }
}