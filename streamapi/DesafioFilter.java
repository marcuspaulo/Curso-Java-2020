package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {

    public static void main(String[] args) {
        Produto produto1 = new Produto("Televisão", 2500, 0.35, 0);
        Produto produto2 = new Produto("Video game", 2500, 0.12, 0);
        Produto produto3 = new Produto("Smartphone iPhone", 2500, 0.12, 0);
        Produto produto4 = new Produto("Smartphone Samsung", 2500, 0.45, 0);
        Produto produto5 = new Produto("Tablet", 2500, 0.4, 0);
        Produto produto6 = new Produto("Bicicleta", 2500, 0, 10);
        Produto produto7 = new Produto("Televisão 55", 2500, 0.31, 0);
        Produto produto8 = new Produto("Televisão 80", 2500, 0.35, 0);
        Produto produto9 = new Produto("Home theater", 2500, 0.70, 0);

        List<Produto> produtos =
                Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7, produto8, produto9);

        Predicate<Produto> superPromocao = p -> p.desconto >=0.20;
        Predicate<Produto> freteGratis = p -> p.valorFrete == 0;
        Predicate<Produto> precoRelevante = p -> p.preco >= 500;
        Function<Produto, String> chamadaPromocional = p -> "Aproveite! " + p.nomeProduto + "por R$ " + p.preco + " e frete por R$ " + p.valorFrete;

        //Pipeline de Execução
        produtos.stream()
            .filter(superPromocao)
            .filter(freteGratis)
            .filter(precoRelevante)
            .map(chamadaPromocional)
        .forEach(System.out::println);
        ;
    }
}
