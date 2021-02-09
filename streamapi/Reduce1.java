package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce1 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        BinaryOperator<Integer> soma = (acumulador, n) -> acumulador + n;

        // Aqui o retorno é um Optional de Integer
        var total = numeros.stream().reduce(soma).get();
        System.out.println(total);

        // Nesse caso, como já tem o valor inicial, ele será Integer nesse caso
        Integer total2 = numeros.stream().reduce(100, soma);
        System.out.println(total2);

        // outra forma, só tem que tomar cuidado, que o resultado é diferente. Já que ele considera o valor inicial múltiplas vezes
        Integer total3 = numeros.parallelStream().reduce(100, soma);
        System.out.println(total3);

        // -----

        // Resultado foi o Optional de Integer
        numeros.stream()
                .filter(n -> n > 5)
                .reduce(soma)
                .ifPresent(System.out::print); //Optional tem essa opção para verificar se é Opcional
    }
}
