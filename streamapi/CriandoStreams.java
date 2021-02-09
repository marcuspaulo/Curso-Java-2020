package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams {

    public static void main(String[] args) {

        Consumer<String> print = System.out::print;
        Consumer<Integer> println = System.out::println;

        Stream<String> languages = Stream.of("Java ", "Go ", "JS \n");
        languages.forEach(print);

        //Outra forma para Criar um Stream
        String[] moreLanguages = {"Python ", "Lisp ", "Perl \n"};

        Stream.of(moreLanguages).forEach(print);

        //Outra forma de Criar Stream com Arrays
        Arrays.stream(moreLanguages).forEach(print);

        //Sub Conjunto
        // Faz o filtro, selecionado o elemento de índice 1 e excluíndo o de índice 3
        Arrays.stream(moreLanguages, 1, 3).forEach(print);

        // Outra forma de Criar Streams, a partir das Collectoions

        List<String> otherLanguages = Arrays.asList("C ", "PHP ", "Kotlin \n");
        otherLanguages.stream().forEach(print);

        // Nesse caso, os valores aparecem de formas diferentes a cada execução.
        otherLanguages.parallelStream().forEach(print);

        // Generate - Gera uma Stream Inifinta, que não tem uma ordenação
        // Supplier é uma função que não retorna parâmetro, mas recebe alguma coisa
        //Stream.generate(() -> "a").forEach(print);

        // Gerar uma iteração de números inteiros, começando pelo valor 0
        // Stream potencialmente infinita
        // Stream.iterate(0, n -> n + 1).forEach(println);
    }
}
