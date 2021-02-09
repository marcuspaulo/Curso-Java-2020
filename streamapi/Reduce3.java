package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce3 {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 7.1);
        Aluno aluno2 = new Aluno("Luna", 6.1);
        Aluno aluno3 = new Aluno("Gui", 8.1);
        Aluno aluno4 = new Aluno("Gabi", 10);

        List<Aluno> alunos = Arrays.asList(aluno1, aluno2, aluno3, aluno4);

        Predicate<Aluno> aprovado = a -> a.nota >= 7; //Utilizando quando se quer filtra
        Function<Aluno, Double> apenasNota = a -> a.nota;
        BiFunction<Media, Double, Media> calcularMedia = (media, nota) -> media.adicionar(nota);

        // Outra forma
//        BiFunction<Media, Double, Media> calcularMedia1 = (media, nota) -> {
//            media.adicionar(nota);
//            return media;
//        };
        BinaryOperator<Media> combinarMedia = (media1, media2) -> Media.combinar(media1, media2);

        Media media = alunos.stream()
                .filter(aprovado)
                .map(apenasNota)
        .reduce(new Media(), calcularMedia, combinarMedia);

        System.out.println("A média da turma é " + media.getValor());
    }
}
