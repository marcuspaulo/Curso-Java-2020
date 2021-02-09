package streamapi;

import java.util.Arrays;
import java.util.List;

public class FilterFilmesDesafio {

    public static void main(String[] args) {
        // Dois filter
        // Depois um map

        Filmes filmes1 = new Filmes("Filme 1", 5, 1990);
        Filmes filmes2 = new Filmes("Filme 2", 10, 1990);
        Filmes filmes3 = new Filmes("Filme 3", 1, 2000);
        Filmes filmes4 = new Filmes("Filme 4", 2, 2010);
        Filmes filmes5 = new Filmes("Filme 5", 4, 2020);
        Filmes filmes6 = new Filmes("Filme 6", 7, 2021);

        List<Filmes> filmes = Arrays.asList(filmes1, filmes2, filmes3, filmes4, filmes5, filmes6);

        filmes.stream()
                .filter(f -> f.ano >= 1990)
                .filter(f -> f.avaliacao >= 4)
                .map(s -> s.nome)
                .forEach(System.out::println);
    }
}
