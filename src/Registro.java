import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class Registro {
  String arquivo;

  public Registro(String arquivo) {

  }

  public void registrarPedido(Pedido pedido) {
    try (BufferedWriter bw = Files.newBufferedWriter(Path.of("registro.txt"), StandardCharsets.UTF_8,
        StandardOpenOption.APPEND)) {
      bw.write(String.format("%s\n%s------\n", Instant.now(), pedido));
    } catch (IOException e) {
      System.err.println("Problema ao registrar o pedido. Por favor, tente novamente.");
    }
  }

}
