package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Map {
    public static void main(String[] args) {
        Consumer<String> print = System.out::print;

        List<String> marcas = Arrays.asList("BMW ", "Audi ", "Honda ");

        marcas.stream().map(m -> m.toUpperCase(Locale.ROOT)).forEach(print);

        // Composição - Recebe String e retorna String
        // Se quiser retornar um número, precisa de uma Function
        UnaryOperator<String> maiscula = n -> n.toUpperCase();
        UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + "";
        UnaryOperator<String> grito = n -> n + "!!! ";

        System.out.println(maiscula.andThen(primeiraLetra).andThen(grito).apply("BMW"));

        System.out.println("\n\nUsando composição");
        marcas.stream().map(maiscula).forEach(print);

        marcas.stream().map(maiscula).map(primeiraLetra).forEach(print);

        // O Stream sempre continua com os mesmos dados, ele sempre gera uma nova Stream
        // Você pode utilizar em outra classe ou interface.
        marcas.stream()
                .map(Utilitarios.maiscula)
                .map(primeiraLetra)
                .map(Utilitarios::grito)
                .forEach(print);
    }
}
