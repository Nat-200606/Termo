import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class Palavras {
    private final List<String> lista;
    private final Random random = new Random();

    // Lê palavras.txt (uma palavra por linha) da pasta do projeto
    public Palavras() throws IOException {
        lista = Files.readAllLines(Path.of("palavras.txt"));
    }

    public String sortear() {
        return lista.get(random.nextInt(lista.size())).toUpperCase();
    }

    public boolean existe(String palavra) {
        return lista.contains(palavra.toLowerCase());
    }
}