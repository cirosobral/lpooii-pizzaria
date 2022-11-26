import java.util.HashMap; // Concreto
import java.util.Map; // Abstrato

public class Pizza {
  // Relação dos ingredientes e quantidade de cada ingrediente
  private Sabor sabor;
  private String tamanho;
  private Map<Ingrediente, Double> ingredientes;
  private double preco;

  public Pizza(Sabor sabor, String tamanho) throws RuntimeException {
    // Ingrediente(n,p) / qtd
    ingredientes = new HashMap<Ingrediente, Double>();
    ingredientes.put(new Ingrediente("Massa", 4.5), ajustaQuantidade(1.0, tamanho));
    ingredientes.put(new Ingrediente("Molho", 1.5), ajustaQuantidade(0.5, tamanho));
    ingredientes.put(new Ingrediente("Queijo", 45.0), ajustaQuantidade(0.2, tamanho));

    switch (sabor) {
      case Calabresa:
        ingredientes.put(new Ingrediente("Calabresa", 15), 0.3);
        ingredientes.put(new Ingrediente("Azeitona", 20), 0.05);

        switch (tamanho) {
          case "P":
            preco = 30;
            break;
          case "M":
            preco = 32;
            break;
          case "G":
            preco = 35;
            break;
        }
        break;
      case Bacon:
        ingredientes.put(new Ingrediente("Bacon", 20), 0.2);

        switch (tamanho) {
          case "P":
            preco = 30;
            break;
          case "M":
            preco = 32;
            break;
          case "G":
            preco = 35;
            break;
        }
        break;
      case Portuguesa:
        ingredientes.put(new Ingrediente("Presunto", 30), 0.2);
        ingredientes.put(new Ingrediente("Milho", 5), 0.5);
        ingredientes.put(new Ingrediente("Pimentão", 7), 0.1);
        ingredientes.put(new Ingrediente("Ovo", 0.3), 2.0);

        switch (tamanho) {
          case "P":
            preco = 40;
            break;
          case "M":
            preco = 42;
            break;
          case "G":
            preco = 45;
            break;
        }
        break;
      case Milho:
        ingredientes.put(new Ingrediente("Milho", 5), 0.5);

        switch (tamanho) {
          case "P":
            preco = 25;
            break;
          case "M":
            preco = 27;
            break;
          case "G":
            preco = 30;
            break;
        }
        break;
      case Mussarela:

        switch (tamanho) {
          case "P":
            preco = 25;
            break;
          case "M":
            preco = 27;
            break;
          case "G":
            preco = 30;
            break;
        }
        break;
      case Frango:
        ingredientes.put(new Ingrediente("Frango", 15), 0.2);

        switch (tamanho) {
          case "P":
            preco = 25;
            break;
          case "M":
            preco = 27;
            break;
          case "G":
            preco = 30;
            break;
        }
        break;
      // Caso padrão
      default:
        throw new RuntimeException("Sabor não disponível");
    }

    this.sabor = sabor;
    this.tamanho = tamanho;
  }

  public static double ajustaQuantidade(double quantidade, String tamanho) throws RuntimeException {
    int raio;

    switch (tamanho) {
      case "P":
        raio = 20;
        break;
      case "M":
        raio = 30;
        break;
      case "G":
        raio = 40;
        break;
      default:
        throw new RuntimeException("Tamanho não disponível");
    }

    return quantidade * (Math.pow(raio, 2) * Math.PI) / (Math.pow(30, 2) * Math.PI);
  }

  public double custoTotal() {
    double total = 0;

    for (var entry : ingredientes.entrySet()) {
      Ingrediente i = entry.getKey();
      total += i.preco() * entry.getValue();
    }

    return Math.ceil(total * 100) / 100;
  }

  public double getPreco() {
    return preco;
  }

  public String getSabor() {
    return sabor.name();
  }

  public String getTamanho() {
    return tamanho;
  }
}