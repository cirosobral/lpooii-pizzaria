public class Bebida {
  private String nome;

  public Bebida(String nome) {
    switch (nome) {
      case "coca":
      case "coca-cola":
        nome = "coca-cola";
        break;
      case "pepsi":
      case "fanta":
      case "guarana":
      case "guaraná":
        nome = "guaraná";
        break;
      case "agua":
      case "água":
        nome = "água";
        break;
      default:
        throw new RuntimeException("Bebida não disponível");
    }

    this.nome = nome;
  }

  public double getPreco() {
    switch (nome) {
      case "coca-cola":
      case "pepsi":
      case "fanta":
      case "guaraná":
        return 7.0;
      case "água":
        return 5.0;
    }

    return 0.0;
  }

  public String getNome() {
    return nome;
  }
}
