public class EP {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Uso: java EP <arquivo com definição do labirinto> <criterio>");
            return;
        } else {
            IOpcao opcao = null;
            int opcaoArgs = Integer.parseInt(args[1]);

            switch(opcaoArgs) {
                case 1:
                    opcao = new Opcao1();
                    break;
                case 2:
                    opcao = new Opcao2();
                    break;
                case 3:
                    opcao = new Opcao3();
                    break;
                default:
                    throw new IllegalArgumentException("O segundo argumento esta errado!");
            }
            
            Viajante viajante = new Viajante(args[0], opcao);
            opcao.imprimirMelhorCaminho();
        }
    }
}