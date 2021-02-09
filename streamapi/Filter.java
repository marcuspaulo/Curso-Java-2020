package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filter {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 7.8);
        Aluno aluno2 = new Aluno("Bia", 5.8);
        Aluno aluno3 = new Aluno("Daniel", 7.1);
        Aluno aluno4 = new Aluno("Rebeca", 8.1);
        Aluno aluno5 = new Aluno("Zeca", 9.1);
        Aluno aluno6 = new Aluno("Monica", 8.1);

        List<Aluno> alunos = Arrays.asList(aluno1, aluno2, aluno3, aluno4, aluno5, aluno6);


        alunos.stream()
                .filter(a -> a.nota >= 7)
                .map(a -> "Parabéns! " + a.nome + "! Você foi aprovado(a)!")
                .forEach(System.out::println);


        System.out.println("-------\n");
        System.out.println("Utilizando o Function e Predicate \n");

        Predicate<Aluno> aprovado = a -> a.nota >= 7;
        Function<Aluno, String> saudacaoAprovado = a -> "Parabéns! " + a.nome + "! Você foi aprovado(a)!";

        alunos.stream()
                //.filter(a -> a.nota >= 7)
                .filter(aprovado)
                .map(saudacaoAprovado) // Não pode inverter, por que o resultado é String, mas o Predicate espera o Aluno
                .forEach(System.out::println);

    }
}
