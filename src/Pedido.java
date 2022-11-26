import java.util.ArrayList;
import java.util.List;

public class Pedido {
  public List<Pizza> pizzas;
  public List<Bebida> bebidas;

  public Pedido() {
    pizzas = new ArrayList<Pizza>();
    bebidas = new ArrayList<Bebida>();
  }

  public void addPizza(Pizza pizza) {
    pizzas.add(pizza);
  }

  public void addBebida(Bebida bebida) {
    bebidas.add(bebida);
  }

  public double valorConta() {
    double valor = 0.0;

    for (Pizza pizza : pizzas) {
      valor += pizza.getPreco();
    }

    for (Bebida bebida : bebidas) {
      valor += bebida.getPreco();
    }

    return valor;
  }

  @Override
  public String toString() {
    String p = "";

    for (Pizza pizza : pizzas) {
      p += String.format("Pizza %-10s (%s)\tR$%.2f\n", pizza.getSabor(), pizza.getTamanho(), pizza.getPreco());
    }

    for (Bebida bebida : bebidas) {
      p += String.format("%-20s\tR$%.2f\n", bebida.getNome(), bebida.getPreco());
    }

    return p;
  }
}
