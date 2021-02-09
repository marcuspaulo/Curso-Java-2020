# Stream API

O Iterator possui dois métodos:
 - Tem próximo?
 - Pula para o outro

```java
public static void main(String[] args) {
        List<String> aprovados = Arrays.asList("Lu", "Gui", "Luca", "Ana");

        System.out.println("Usando o foreach..");
        for (String nome: aprovados) {
            System.out.println(nome);
        }

        System.out.println("\nUsando o Iterator..");
        Iterator<String> iterator = aprovados.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nUsando o Stream..");
        Stream<String> streamAprovados = aprovados.stream();
        streamAprovados.forEach(System.out::println); //Laço interno
    }
```

## Grupos de operadores (30+ operações, 7 Static)

 - Built Ops - Forma para criar o Stream, a partir de métodos estáticos, a partir de uma lista (aprovados.stream()); --> Resultado Stream();
 - Intermedium Ops - A partir da criação, você já tem as operações intermdiárias (de preferência 1 responsabilidade só) - Sempre retorna uma nova Stream, inclusive, pode chamar outra operação intermediária. (Ex. extrair somente os preços dos produtos), a partir dai, calcular o imposto;
 - Terminal Ops - Após isso, você tem uma operação terminal, pode gerar algo diferente de um Stream, exemplo, gerar um média do carrinho de compra. (Resultado Double e a partir dai, não pode encadear outras Stream.)


Existem Streams: 
 - Ordenadas - Seguir uma sequência ordenada
 - Não Ordenada - Não segue uma ordem específica
 - Stream sequencial (Processa um dado por vez);
 - Parallel Stream - Processa de forma paralela;

# Criando uma Stream
``java
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
```

----
# MAP
O MAP pega uma Stream de 9 elementos, por exemplo e gera um outro Stream de 9 elementos
``` java
MAP(e -> e*2) // Itera e multiplica
```
Você pode aplicar quantos métodos você precisar, já que ela gera uma outra Stream.

```java
MAP (e -> e-2);
```

### Extraindo apenas o nome dos produtos
```java
MAP(p -> p.nome)
```


DICA: Você pode definir um construtor privado, para evitar que seja instanciado.

# Desafio Map 

```java
/**
 * Exercício
 * 1 - Número para String binária... 6 => "110"
 * 2 - Inverter a String... "110" => "011"
 * 3 - Converter de volta para inteiro => "011" => 3
 */
public class DesafioMap {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        UnaryOperator<String> inverter = s -> new StringBuilder(s).reverse().toString();
        Function<String, Integer> binarioParaInt = s -> Integer.parseInt(s, 2);

        numeros.stream()
                .map(Integer::toBinaryString)
                .map(inverter)
                .map(binarioParaInt)
                .forEach(System.out::println);
    }
}
```

---
# Filter
| 3 | 2 | 4 | 7 | 8 | 7 | 6 | 1 |
        => `Filter(n -> n%2 == 0)` //par
O resultado do Stream pode ser menor com o filter.
Stream Resultante com o Filter: | 2 | 4 | 8 | 6 |

Imagine uma lista de Produto (nome e preço)
Stream (Produtos) -> filter(p -> p.preco >= 1000)

### Exemplo
```java
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
```

Desafio Filter

`Pipeline de execução`

```java
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
        Predicate<Produto> produtoRelevante = p -> p.preco >= 500;
        Function<Produto, String> chamadaPromocional = p -> "Aproveite! " + p.nomeProduto + "por R$ " + p.preco + " e frete por R$ " + p.valorFrete;

        //Pipeline de Execução
        produtos.stream()
            .filter(superPromocao)
            .filter(freteGratis)
            .filter(produtoRelevante)
            .map(chamadaPromocional)
        .forEach(System.out::println);
        ;
    }
}
```

# Reduce
O Reduce transforma uma Stream de Dados e transforma em uma coisa diferente. (Nem o tipo precisa ser igual)

 - MAP - é uma função que faz um mapeamento de um elemento para outro elemento. O resultado gerado, terá uma stream de um mesmo tamanho.
 - Filter - tem o papel de filtrar

Você pode dar um valor inicial para o acumulador.

| 7 | 3 | 4 | 2 | 8 | 1 | 2 | 8 |
  `reduce(acumulador, n)` --> acumulador + n

Execução
```txt
`reduce(acumulador, n)` --> acumulador + n
 (0, 7) -> 0 + 7 = 7 // O 7 passa para a próxima execução
 (7, 3) -> 7 + 3 = 10 // o 10 será repassado para a próxima execução
 (10, 4) -> 10 + 4 = 14
 // e assim por diante, seguindo os números do mapeamento acima.
```

- O Resultado final do Reduce não gera uma Stream

```java
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
```

## Segundo exemplo Reduce

````java
public class Reduce2 {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 7.1);
        Aluno aluno2 = new Aluno("Luna", 6.1);
        Aluno aluno3 = new Aluno("Gui", 8.1);
        Aluno aluno4 = new Aluno("Gabi", 10);

        List<Aluno> alunos = Arrays.asList(aluno1, aluno2, aluno3, aluno4);

        Predicate<Aluno> aprovado = a -> a.nota >= 7; //Utilizando quando se quer filtra
        Function<Aluno, Double> apenasNota = a -> a.nota;
        BinaryOperator<Double> somatorio = (a, b) -> a + b;

        alunos.parallelStream()
                .filter(aprovado)
                .map(apenasNota)
                .reduce(somatorio)
                .ifPresent(System.out::println);
    }
}
````

## Exemplo Reduce3
````java
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
````
# Match
````java
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
````
# Stream Min e Max
````java
public class MinMax {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 7.1);
        Aluno aluno2 = new Aluno("Luna", 6.1);
        Aluno aluno3 = new Aluno("Gui", 8.1);
        Aluno aluno4 = new Aluno("Gabi", 10);

        List<Aluno> alunos = Arrays.asList(aluno1, aluno2, aluno3, aluno4);

        Comparator<Aluno> melhorNota = (a1, a2) -> {
          if (a1.nota > a2.nota) return 1;
          if (a1.nota < a2.nota) return -1;
          return 0;
        };

        Comparator<Aluno> piorNota = (a1, a2) -> {
            if (a1.nota > a2.nota) return -1;
            if (a1.nota < a2.nota) return 1;
            return 0;
        };

        System.out.println(alunos.stream().max(melhorNota).get());
        System.out.println(alunos.stream().min(melhorNota).get());

        System.out.println(alunos.stream().max(piorNota).get());

        // Uma das formas para comparar
        Comparator<Aluno> melhorNotaComparator = new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                if (a1.nota > a2.nota) return 1;
                if (a1.nota < a2.nota) return -1;
                return 0;
            }
        };
    }
}
````
## Outros métodos

````java
public class OutrosMetodosStream {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 7.1);
        Aluno aluno2 = new Aluno("Luna", 6.1);
        Aluno aluno3 = new Aluno("Gui", 8.1);
        Aluno aluno4 = new Aluno("Gabi", 10);
        Aluno aluno5 = new Aluno("Ana", 7.1);
        Aluno aluno6 = new Aluno("Pedro", 6.1);
        Aluno aluno7 = new Aluno("Gui", 8.1);
        Aluno aluno8 = new Aluno("Maria", 10);


        List<Aluno> alunos = Arrays.asList(aluno1, aluno2, aluno3, aluno4, aluno5, aluno6, aluno7, aluno8);

        System.out.println("Distinct");
        // Aqui acabou duplicando, é necessário implementar o Equals e hashcode
        alunos.stream().distinct().forEach(System.out::println);

        System.out.println("\n");

        System.out.println("\nSkip/Limit");
        alunos.stream()
                .distinct()
                .skip(2)
                .limit(2)
                .forEach(System.out::println);

        // Encontrou, ele para de executar.
        System.out.println("\nTake/While");
        alunos.stream()
                .distinct()
                .skip(2) // pula dois elementos
                .takeWhile(a -> a.nota >= 7)
                .forEach(System.out::println);
    }
}
````
