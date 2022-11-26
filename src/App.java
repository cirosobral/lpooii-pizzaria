public class App {
    public static void main(String[] args) throws Exception {
        Pedido p = null;
        Registro registro = new Registro("registro.txt");

        menuInicial: while (true) {
            System.out.println("Escolha uma das seguintes opções:");
            if (p == null) {
                System.out.println("1 - Iniciar pedido");
                System.out.println("2 - Sair");
            } else {
                System.out.println("1 - Pedir conta");
                System.out.println("2 - Sair");
            }
            // System.console() é a chamada para um objeto que interage com o console/linha
            // de comando
            String entrada = System.console().readLine("Digite o número da opção [1 ou 2]: ");

            switch (entrada) {
                case "2":
                    break menuInicial;
                case "1":
                    if (p == null) {
                        p = iniciarPedido();
                        registro.registrarPedido(p);
                    } else {
                        pedirConta(p);
                        p = null;
                    }
            }
        }
    }

    private static Pedido iniciarPedido() {
        Pedido p = new Pedido();

        pedido: while (true) {
            System.out.println("Escolha uma das seguintes opções:");
            System.out.println("1 - Pedir pizza");
            System.out.println("2 - Pedir bebida");
            System.out.println("3 - Finalizar pedido");
            String entrada = System.console().readLine("Digite o número da opção [1 a 3]: ");

            switch (entrada) {
                case "1":
                    pedirPizza(p);
                    break;
                case "2":
                    pedirBebida(p);
                    break;
                case "3":
                    System.out.println("Seu pedido foi finalizado.");
                    break pedido;
            }
        }

        return p;
    }

    private static void pedirPizza(Pedido pedido) {
        System.out.println("Escolha um dos sabores a seguir");

        int i = 0;

        for (Sabor sabor : Sabor.values())
            System.out.println(String.format("%d - %s", ++i, sabor.name()));

        String entrada = System.console().readLine("Digite o número do sabor [1 a %d]: ", i);

        try {
            int escolha = Integer.parseInt(entrada);

            if (escolha <= 0 || escolha > i)
                throw new RuntimeException("Sabor inválido");

            Sabor sabor = Sabor.values()[escolha - 1];

            String tamanho = System.console().readLine("Escolha o tamanho [P, M ou G]: ");
            // ------------------------ transformaEmMaiusuclas -- pega só a primeira letra
            Pizza pizza = new Pizza(sabor, tamanho.toUpperCase().substring(0, 1));

            pedido.addPizza(pizza);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void pedirBebida(Pedido pedido) {
        String entrada = System.console().readLine("Digite o nome da bebida: ");

        try {
            Bebida bebida = new Bebida(entrada.toLowerCase());

            pedido.addBebida(bebida);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void pedirConta(Pedido pedido) {
        System.out.println("\nSua conta");
        System.out.println(pedido);
        System.out.println(String.format("Sua conta ficou: R$%.2f\n", pedido.valorConta()));
    }
}
