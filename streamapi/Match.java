package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Match {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 7.1);
        Aluno aluno2 = new Aluno("Luna", 6.1);
        Aluno aluno3 = new Aluno("Gui", 8.1);
        Aluno aluno4 = new Aluno("Gabi", 10);

        List<Aluno> alunos = Arrays.asList(aluno1, aluno2, aluno3, aluno4);

        Predicate<Aluno> aprovado = a -> a.nota >= 7; //Utilizando quando se quer filtra
        Predicate<Aluno> reprovado = aprovado.negate();

        System.out.println("All Match " + alunos.stream().allMatch(aprovado)); //Todos os alunos passaram, o caso é false;
        System.out.println("Any Match " + alunos.stream().anyMatch(aprovado)); //Alguém passou? no caso é true
        System.out.println("None Match " + alunos.stream().noneMatch(aprovado)); //Ninguém passou? No caso é false;
        System.out.println("None Match " + alunos.stream().noneMatch(aprovado.negate())); //Ninguém passou? No caso é false;
        System.out.println("None Match " + alunos.stream().noneMatch(reprovado)); //Ninguém passou? No caso é false;
    }
}
