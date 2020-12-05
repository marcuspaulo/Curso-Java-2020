#Lambda (Java 8)

Definição: Uma função anônima é uma expressão que representa uma definição de método “em-linha”. Ela não tem valor ou tipo em si, mas pode ser convertida em um delegate compatível ou em uma expressão do tipo árvore. Por razões históricas existem dois tipos sintáticos das funções anônimas: expressões lambda e expressões anônimas de métodos. O operador “->” tem a mesma precedência como a atribuição (=) e associativo à direita.

```java
public interface Calculo {
    public abstract double executar(double a, double b);
}
```

```java
public class Multiplicar implements Calculo {
    @Override
    public double executar(double a, double b) {
        return a * b;
    }
}
```

```java
public class Somar implements Calculo {
    @Override
    public double executar(double a, double b) {
        return a + b;
    }
}
```

Executando: 
```java
public class CalculoLambda {

    public static void main(String[] args) {
        Calculo calculo = (x, y) -> { //Função anonima (Tem que ser igual ao da interface)
          return x + y; // obrigatório colocar o return
        };

        System.out.println(calculo.executar(2, 3));

        calculo = (x, y) -> x * y; //Nesse caso o retorno é implícito. Só pode ter uma sentença se quiser mais de uma, precisa de um bloco de código {}

        System.out.println(calculo.executar(2, 3));
    }
}
```

---

# Interface funcional

Existe uma anotação chamada @FuncionalInterface

Caso a interface tenha mais de um método, significa se quiser criar um outro método vai dar problema, já que uma `interface funcional` só pode ter `1 método`;

 - Você precisa ter pelo menos um método abstrado;
 - Você pode ter um método default;

### Exemplo que é possível na `Funcional Interface`
```java

@FunctionalInterface
public interface Calculo {
    public abstract double executar(double a, double b);

    default String texto(String texto) {
        return "Titulo: " + texto;
    }

    static String subtitulo(String texto) {
        return "Subtitulo: " + texto;
    }
}
```

💡 - ** - `Relembrando`: A partir de um método de instância, é possível acessar os membros estáticos, porém, a partir dos métodos estáticos, você não tem acesso ao this.**

https://docs.oracle.com/javase/8/docs/api/?java/util/function/package-summary.html

# Binary Operator - recebe dois parâmetros de entrada do mesmo tipo e retorna o valor do tipo definido;

 - O Java não converte int para Double
 - Sim: double -> Double
 - Não é possível definir tipos primitivos no Genéric;
 - Binary Operator: Pode receber duas listas e retornar uma lista
 - Pode receber dois Strings e retornar um String e assim por diante;

```java
import java.util.function.BinaryOperator;

public class CalculoLambdaBinaryOperator {

    public static void main(String[] args) {

        BinaryOperator<Double> calculo = (x, y) -> {
          return x + y; // obrigatório colocar o return
        };

        // O Java não converte int para Double
        // Sim: double -> Double
        System.out.println(calculo.apply(2.0, 3.0));

        calculo = (x, y) -> x * y; //Nesse caso o retorno é implícito. Só pode ter uma sentença se quiser mais de uma, precisa de um bloco de código {}
        System.out.println(calculo.apply(2.0, 3.0));

        // Integer
        BinaryOperator<Integer> calculoInteger = (x, y) -> {
            return x + y; // obrigatório colocar o return
        };

        System.out.println(calculoInteger.apply(2, 3));
    }
}
```

Exemplos de Lambdas: 

  - Method reference: `aprovados.forEach(System.out::println); // Menos flexível`
  - ```java
        // Method reference do método definido na classe ForEach
        aprovados.forEach(ForEach::imprimir);
  - ```
  - ForEach lambda: 
  ```java
        aprovados.forEach((nome) -> {
            System.out.println(nome + "!!!");
        });

        // Se tiver apenas um parâmetro, pode remover os parentêses:
        aprovados.forEach(nome -> {
            System.out.println(nome + "!!!");
        });

        // Função personalizada, dentro da estrutura do Lambda
        aprovados.forEach(nome -> imprimir("Marcus"));
    ```

```java
import java.util.Arrays;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<String> aprovados = Arrays.asList("Ana", "Bia", "Lia", "Gui");

        //Forma tradicional
        for(String nome: aprovados) {
            System.out.println(nome);
        }

        System.out.println("Lambda #01...");

        aprovados.forEach((nome) -> {
            System.out.println(nome + "!!!");
        });

        // Se tiver apenas um parâmetro, pode remover os parentêses:
        aprovados.forEach(nome -> {
            System.out.println(nome + "!!!");
        });

        //Forma reduzida, sem o corpo {}
        aprovados.forEach(nome -> System.out.println(nome + "!!!"));

        // Method Reference
        // Recebe um parâmetro e passa os nomes para o println
        System.out.println("Method Reference");
        aprovados.forEach(System.out::println); // Menos flexível

        // Função personalizada, dentro da estrutura do Lambda
        aprovados.forEach(nome -> imprimir("Marcus"));

        // Method reference do método definido na classe ForEach
        aprovados.forEach(ForEach::imprimir);

    }

    static void imprimir(String nome) {
        System.out.println("Oi! meu nome é " + nome);
    }
}
```

## Interfaces Funcionais
| Assinatura | Nome     |
|------------|------    |
|  Nada -> T | Supplier |
|  T -> Nada | Consumer |
|  T -> T    | Unary Operator |
|  T,T -> T  | Binary Operator |
|  S -> T    | Function |
|  T -> Boolean    | Predicate |

---

É possivel encadear as interfaces funcionais, portanto, que a saída de uma interface, seja a entrada de outra.

 - Existem interfaces voltadas para o tipo primitivo
 - IntBinaryOperator
 - DoubleBinaryOperator
 - DoublePredicate
 - Além de outros exemplos
---

## Interface funcional Predicate
Representa um predicado que retorna o valor

```java
public class Produto {

    final String nome;
    final double preco;
    final double desconto;

    public Produto(String nome, double preco, double desconto) {
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }
}
```

### Predicado
```java
import java.util.function.Predicate;

public class Predicado {

    public static void main(String[] args) {

        Predicate<Produto> isCaro = produto -> (produto.preco * ( 1 - produto.desconto)) >= 800;

        Produto produto = new Produto("Notebook", 3600, 0.15);
        System.out.println(isCaro.test(produto));
    }
}
```

--- 

# Interface Consumer (aceita 1 parâmetro e não retorna nada)

```java
package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidor {

	public static void main(String[] args) {
		
		Consumer<Produto> imprimirNome = 
				p -> System.out.println(p.nome + "!!!");
		
		Produto p1 = new Produto("Caneta", 12.34, 0.09);
		imprimirNome.accept(p1);
		
		Produto p2 = new Produto("Notebook", 2987.99, 0.25);
		Produto p3 = new Produto("Caderno", 19.90, 0.03);
		Produto p4 = new Produto("Borracha", 7.80, 0.18);
		Produto p5 = new Produto("Lapis", 4.39, 0.19);
		
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);
		
		produtos.forEach(imprimirNome);
		produtos.forEach(p -> System.out.println(p.preco));
		produtos.forEach(System.out::println);
	}
}
```
---

# Interface funcional Function
Representa uma interface que aceita um único argumento e que produz um resultado

```java
package lambdas;

import java.util.function.Function;

public class Funcao {

	public static void main(String[] args) {
		
		Function<Integer, String> parOuImpar = numero -> numero % 2 == 0 ? "Par" : "Ímpar";
		
		Function<String, String> oResultadoE = valor -> "O resultado é: " + valor;
				
		Function<String, String> empolgado = valor -> valor + "!!!";
				
		Function<String, String> duvida = valor -> valor + "???";
		
		String resultadoFinal1 = parOuImpar
				.andThen(oResultadoE)
				.andThen(empolgado)
				.apply(32);
		System.out.println(resultadoFinal1);

		String resultadoFinal2 = parOuImpar
				.andThen(oResultadoE)
				.andThen(duvida)
				.apply(33);
		System.out.println(resultadoFinal2);
		
		System.out.println(parOuImpar.apply(32));
	}
}
```

### Predicado Composicao
Interface Predicado recebe um parâmetro de entrada e retona verdadeiro ou falso;

```java
package lambdas;

import java.util.function.Predicate;

public class PredicadoComposicao {

	public static void main(String[] args) {
		
		Predicate<Integer> isPar = num -> num % 2 == 0;
		Predicate<Integer> isTresDigitos =
				num -> num >= 100 && num <= 999;
				
		System.out.println(isPar.and(isTresDigitos).negate().test(123));
		System.out.println(isPar.or(isTresDigitos).test(123));
	}
}
```
---

# Interface funcional Supplier
Não recebe nenhuma parâmetro e devolver alguma coisa
  - É uma interface mais simples
  - Não tem os operadores or and e etc. 
```java
package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor {

	public static void main(String[] args) {
		
		Supplier<List<String>> umLista = 
				() -> Arrays.asList("Ana", "Bia", "Lia", "Gui");
		System.out.println(umLista.get());
	}
}

```
---

# Unary Operator
É interessante para fazer o encadeamento de várias chamadas;

  - Compose executa de trás para frente (Sentido inverso)

```java
package lambdas;

import java.util.function.UnaryOperator;

public class OperadorUnario {

	public static void main(String[] args) {
		
		UnaryOperator<Integer> maisDois = n -> n + 2;
		UnaryOperator<Integer> vezesDois = n -> n * 2;
		UnaryOperator<Integer> aoQuadrado = n -> n * n;
		
		int resultado1 = maisDois
				.andThen(vezesDois)
				.andThen(aoQuadrado)
				.apply(0);
		System.out.println(resultado1);
		
		int resultado2 = aoQuadrado
				.compose(vezesDois)
				.compose(maisDois)
				.apply(0);
		System.out.println(resultado2);
	}
}
```

# Operador Binário

Exemplo interessante, recebendo dois números e retornando uma String

```java
BiFunction<Double, Double, String> resultado = (n1, n2) -> {
		double notaFinal = (n1 + n2) / 2;
		return notaFinal >= 7 ? "Aprovado" : "Reprovado";
};
```

```java
package lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperadorBinario {

	public static void main(String[] args) {
		
		BinaryOperator<Double> media = (n1, n2) -> (n1 + n2) / 2;
		System.out.println(media.apply(9.8, 5.7));
		
		BiFunction<Double, Double, String> resultado = (n1, n2) -> {
			double notaFinal = (n1 + n2) / 2;
			return notaFinal >= 7 ? "Aprovado" : "Reprovado";
		};
		
		System.out.println(resultado.apply(9.7, 4.1));
		
		Function<Double, String> conceito = 
				m -> m >= 7 ? "Aprovado" : "Reprovado";
				
		System.out.println(media.andThen(conceito).apply(9.7, 5.1));
	}
}
```

# Desafio Binary Operator
```java
package lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {

	public static void main(String[] args) {
		
		/*
		 * 1. A partir do produto calcular o preco real (com desconto)
		 * 2. Imposto Municipal: >= 2500 (8,5%)/ < 2500 (Isento)
		 * 3. Frete: >= 3000 (100)/ < 3000 (50)
		 * 4. Arredondar: Deixar duas casas decimais
		 * 5. Formatar: R$1234,56
		 */
		
		Function<Produto, Double> precoFinal = 
				produto -> produto.preco * (1 - produto.desconto);
		UnaryOperator<Double> impostoMunicipal =
				preco -> preco >= 2500 ? preco * 1.085 : preco;
		UnaryOperator<Double> frete = 
				preco -> preco >= 3000 ? preco + 100 : preco + 50;
		UnaryOperator<Double> arredondar = 
				preco -> Double.parseDouble(String.format("%.2f", preco));
		Function<Double, String> formatar = 
				preco -> ("R$" + preco).replace(".", ",");
		
		
		Produto p = new Produto("iPad", 3235.89, 0.13);
		String preco = precoFinal
				.andThen(impostoMunicipal)
				.andThen(frete)
				.andThen(arredondar)
				.andThen(formatar)
				.apply(p);
		System.out.println("O preço final é " + preco);
	}
}
```

# Interfaces Funcionais antes do Java 8

Thread é um processo que pode se executado paralelamente;
```java
package lambdas;

public class Threads {

	public static void main(String[] args) {
		Runnable trabalho1 = new Trabalho1();
		Runnable trabalho2 = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Tarefa #02");
					try {
						Thread.sleep(100);						
					} catch (Exception e) {
            // omitido apenas para fins didáticos
					}
				}
			}
		};
		
		Runnable trabalho3 = Threads::trabalho3;
		
		Thread t1 = new Thread(trabalho1);
		Thread t2 = new Thread(trabalho2);
		Thread t3 = new Thread(trabalho3);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	static void trabalho3() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Tarefa #03");
			try {
				Thread.sleep(100);						
			} catch (Exception e) {
			}
		}
	}
}
```

```java
package lambdas;

public class Trabalho1 implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Tarefa #01");
			try {
				Thread.sleep(100);						
			} catch (Exception e) {
			}
		}
	}
}
```
💡 - ****



💡 - ****
