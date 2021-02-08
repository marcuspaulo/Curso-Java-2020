# Arrays e Collections
O Array possui tamanho fixo (Estático) - No momento da criação, você precisa dizer quantos valores esse Array vai armazenar;

💡 - **Você pode mudar a referência de uma variável, mas não pode mudar o tamanho que foi criado, ou seja, crie um array de tamanho maior e faça a referência para ele.**

### Caracteristicas
  - Estático (Tamanho fixo);
  - Homogênio (Mesmo tipo);
  - Os elementos sempre começam no índice 0;
  - Array é um objeto.

```java
int[] a = new int[6];

a[2] = 10.0;
System.out.println(a[2]); // Imprime o valor 10.0

// a[2]. (Isso é um tipo primitivo, então, vai dar erro, a não ser que seja um objeto)
```
## Matriz
Em Java para representar a Matriz, você precisa de um Array dentro de outro Array;

### Array Multi dimensional
```java
double[][]
double[][][][] // Não é muito utilizado;
```
### Exercício Array
```java
package arrays;

import java.util.Arrays;

public class Exercicio {

	public static void main(String[] args) {
		
		double[] notasAlunoA = new double[4];
		System.out.println(Arrays.toString(notasAlunoA));

		notasAlunoA[0] = 7.9;
		notasAlunoA[1] = 8;
		notasAlunoA[2] = 6.7;
		notasAlunoA[3] = 9.7;
		
		System.out.println(Arrays.toString(notasAlunoA));
		System.out.println(notasAlunoA[0]);
		System.out.println(notasAlunoA[notasAlunoA.length - 1]);
		// System.out.println(notasAlunoA[4]); ERRO! Acessando o elemento fora dos limites;
		
		double totalAlunoA = 0;
		for(int i = 0; i < notasAlunoA.length; i++) {
			totalAlunoA += notasAlunoA[i];
		}
		
		System.out.println(totalAlunoA / notasAlunoA.length);
		
		final double notaArmazenada = 5.9;
		double[] notasAlunoB = { 6.9, 8.9, notaArmazenada, 10 };
		
		double totalAlunoB = 0;
		for (int i = 0; i < notasAlunoB.length; i++) {
			totalAlunoB += notasAlunoB[i];
		}
		
		System.out.println(totalAlunoB / notasAlunoB.length);
	}
}

```
### Atribuindo para um array de forma literal
```java
double[] notasAlunoB = { 6.9, 8.9, notaArmazenada, 10 };
```
---

# Foreach

```java
package arrays;

public class Foreach {

	public static void main(String[] args) {
		
		double[] notas = { 9.9, 8.7, 7.2, 9.4 };
		
		for (int i = 0; i < notas.length; i++) {
			System.out.print(notas[i] + " ");
		}
		
		System.out.println();
		
		for(double nota: notas) {
			System.out.print(nota + " ");
		}
	}
}
```

# Matriz

Exemplo: Aluno e as notas dos alunos.
a = aluno;
n = nota do aluno;
```java
package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Quantos alunos? ");
		int qtdeAlunos = entrada.nextInt();

		System.out.print("Quantas notas por aluno? ");
		int qtdeNotas = entrada.nextInt();
		
		double[][] notasDaTurma = new double[qtdeAlunos][qtdeNotas];
		
		double total = 0;
		for (int a = 0; a < notasDaTurma.length; a++) {
			for (int n = 0; n < notasDaTurma[a].length; n++) {
				System.out.printf("Informe a nota %d do aluno %d: "
						, n + 1, a + 1);
				notasDaTurma[a][n] = entrada.nextDouble();
				total += notasDaTurma[a][n];
			}
		}
		
		double media = total / (qtdeAlunos * qtdeNotas);
		System.out.println("Média da turma é " + media);

		for(double[] notasDoAluno: notasDaTurma) {			
			System.out.println(Arrays.toString(notasDoAluno));
		}
		
		entrada.close();
		
	}
}
```
---
# Equals e HashCode
Imagine a situação, criar dois Objetos Produtos, que tenham o atributo nome e o valor dessa atributo seja Caneta. Por mais que seja o mesmo conteúdo, serão criados dois objetos na memória;

Se você utilizar operação de igualdade: 
p1 == p2 --> false. // Por que, eles apontam para endereços distintos, mesmo que seja os mesmos dados.

💡 - **Em tipos primitivos 3.2 == 3.2, será verdadeiro, porém, com o objeto você compara com o valor de memória**

Para resolver isso, você pode utilizar o método `equals`. 

### Outro exemplo do Equals
```java
Produto p1 = new Produto();
p1.nome = "Caneta";

Produto p2 = new Produto();
p2.nome = "Caneta";

p1.equals(p2); // mesma coisa que: p1 == p2; // Dá falso, já que ele tem o mesmo comportamento do ==
```

### HashCode
 - O `Hashcode` retorna um valor inteiro;
 - `Equals` retorna o valor Boolean;

O objetivo do HashCode, ele separa os objetos que aparentemente são iguais e em seguida é utilizado o `equals`;

💡 - **Um exemplo mais prático do HashCode, você vai procurar a usuária chamada Luna e a lista possui 100.000 registros. O Hashcode, vai verificar, quandos nomes tem 4 posições e selecionar para uma lista menor. A partir da lista menor, o equals entra em ação. **

💡 - **HashSet utiliza o HashCode para comparar objetos**

```java
package exercicios.src.classe;

public class Usuario {

	String nome;
	String email;
	
	public boolean equals(Object objeto) {
		
		if(objeto instanceof Usuario) {
			Usuario outro = (Usuario) objeto;
			
			boolean nomeIgual = outro.nome.equals(this.nome);
			boolean emailIgual = outro.email.equals(this.email);
			
			return nomeIgual && emailIgual;			
		} else {
			return false;
		}
	}
	
	// O hascode será abordado em outra aula!
	public int hashCode() {
		return 0;
	}
}
```

```java
package exercicios.src.classe;

public class Equals {

	public static void main(String[] args) {
		
		Usuario u1 = new Usuario();
		u1.nome = "Pedro Silva";
		u1.email = "pedro.silva@ezemail.com.br";

		Usuario u2 = new Usuario();
		u2.nome = "Pedro Silva";
		u2.email = "pedro.silva@ezemail.com.br";
		
		System.out.println(u1 == u2); // false - comparando com endereço da memória
		System.out.println(u1.equals(u2)); //
		System.out.println(u2.equals(u1));
		
		// System.out.println(u2.equals(new Date()));
	}
}
```
---

# Collections
As Collections tem os valores dinâmicos e os dados podem ser misturado;
 - A boa prática é trabalhar com dados homogêneo;
 - Não é possível utilizar valores primitivos, para isso você pode utilizar as classes Wrappers;

## Set
 - Não ordenado (Por padrão);
 - Não indexado;
 - Não aceita repetição;

## List
 - Indexada;
 - Aceita repetição;
  
## Map
 - Chave/Valor;
 - Chave não aceita repetição;
 - Valor aceita repeticão;

## Queue (Fila = FIFO)
 - Implementa Fila;
 - First in/ first out (FIFO);

## Stack (Pilha)
 - Implementa Pilha (Stack);
 - Last In/ First out (LIFO);


---
# Set --> HashSet
 - Pode ser heterogêneo 😞;
 - Pode ser homogêneo;
 - Não aceita objetos duplicados;
 - Pode ser ordenado
 - Não é indexado;

```java
package colecoes;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBaguncado {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		HashSet conjunto = new HashSet();
		
		conjunto.add(1.2); // double -> Double
		conjunto.add(true); // boolean -> Boolean
		conjunto.add("Teste"); // String
		conjunto.add(1); // int --> Integer
		conjunto.add('x'); // char = Character
		
		System.out.println("Tamanho é " + conjunto.size());
		
		conjunto.add("Teste");
		conjunto.add('x'); // Não aceita repetição
		System.out.println("Tamanho é " + conjunto.size());
		
		System.out.println(conjunto.remove("teste"));
		System.out.println(conjunto.remove("Teste"));
		System.out.println(conjunto.remove('x'));
		
		System.out.println("Tamanho é " + conjunto.size());
		
		System.out.println(conjunto.contains('x'));
		System.out.println(conjunto.contains(1));
		System.out.println(conjunto.contains(true));
		
		Set nums = new HashSet();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		System.out.println(nums);
		System.out.println(conjunto);
		
		// conjunto.addAll(nums); // União entre dois conjuntos
		conjunto.retainAll(nums); // Interseção
		System.out.println(conjunto);
		
		conjunto.clear();
		System.out.println(conjunto);
	}
}
```

## Exemplo Set
ConjuntoComportado.java -- A lista obrigatóriamente terá um tipo;
```java
package colecoes;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjuntoComportado {

	public static void main(String[] args) {
		
//		Set<String> listaAprovados = new HashSet<>();
		SortedSet<String> listaAprovados = new TreeSet<>();
		listaAprovados.add("Ana");
		listaAprovados.add("Carlos");
		listaAprovados.add("Luca");
		listaAprovados.add("Pedro");
		
		for(String candidato: listaAprovados) {
			System.out.println(candidato);
		}
		
		Set<Integer> nums = new HashSet<>();
		nums.add(1);
		nums.add(2);
		nums.add(120);
		nums.add(6);
		
		// nums.get(1); Não é possível acessar pelo índice
		
		for(int n: nums) {
			System.out.println(n);
		}
	}
}

```

💡 - **AutoBoxing - coloca o valor dentro da classe**

## Operador Diamond (Adicionado no Java 7 ou 8)
```java
Set<String> lista = new HashSet<>();
```
## Set Conjunto Ordenado
```java
SortedSet<String> listaAprovados = new TreeSet<>();

// ou
TreeSet<String> listaAprovados = new TreeSet<>();
```
---

# List
 - Pode ser heterogêneo;
 - Pode ser homogêneo;
 - Aceita objetos duplicados;
 - É Ordenado;
 - É indexado;

---

# Queue (Fila)
 - FIFO - First In, First out;
- 
```java
package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {

	public static void main(String[] args) {
		
		Queue<String> fila = new LinkedList<>();
		
		// Offer e Add -> adicionam elementos na fila
		
		// Diferença é o comportamento ocorre
		// quando a fila está cheia!
		fila.add("Ana"); // retorna false
		fila.offer("Bia"); // Lança uma exceção
		fila.add("Carlos");
		fila.offer("Daniel");
		fila.add("Rafaela");
		fila.offer("Gui");
		
		// Peek e Element -> obter o próximo elemento
		// da fila (sem remover)
		
		// Diferença é o comportamento ocorre
		// quando a fila está vazia!
		System.out.println(fila.peek()); // retorna false
		System.out.println(fila.peek());
		System.out.println(fila.element()); // Lança uma exceção
		System.out.println(fila.element());
				
		// Poll e Remove -> obter o próximo elemento
		// da fila e remove!
		
		// Diferença é o comportamento ocorre
		// quando a fila está vazia!
		System.out.println(fila.poll()); // retorna false
		System.out.println(fila.remove()); // Lança uma exceção
		System.out.println(fila.poll()); // Pega o primeiro elemento, já removendo
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.remove());
		
		// fila.size();
		// fila.clear();
		// fila.isEmpty(); // Para saber se a fila está vazia
		// fila.contains(...)
	}
}
```
```java
	System.out.println(fila.peek()); // retorna false
	System.out.println(fila.element()); // Lança uma exceção, caso não tenha elemento
```

**Peek e Element -> obter o próximo elemento da fila (sem remover)**

**fila.poll() // Pega o primeiro elemento, já removendo**

----
# Pilha (Stack)
 - LIFO - Last In First Out

```java
package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {

	public static void main(String[] args) {
		
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("O Pequeno Príncipe");
		livros.push("Don Quixote");
		livros.push("O Hobbit");
		
		System.out.println(livros.peek()); // O Hobbit
		System.out.println(livros.element()); // O Hobbit
		
		for(String livro: livros) { // O laço é feito do topo até a parte inferior
			System.out.println(livro);
		}
		
		System.out.println(livros.pop()); // O Hobbit
		System.out.println(livros.poll()); // Don Quixote
		System.out.println(livros.poll()); // O Pequeno Príncipe
		System.out.println(livros.poll()); // false
		System.out.println(livros.poll());
		System.out.println(livros.pop()); // Se não tiver elemento, lança: NoSuchElementException
//		System.out.println(livros.remove()); // Lança exceção caso esteja nulo
		
		// livros.size();
		// livros.clear();
		// livros.contains();
		// livros.isEmpty();

	}
}
```

💡 - **O laço é feito do topo até a parte inferior**

---
# MAP

### Exemplo Map
```java
package colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {

	public static void main(String[] args) {
		
		Map<Integer, String> usuarios = new HashMap<>();
		
		usuarios.put(1, "Roberto");
		usuarios.put(20, "Ricardo");
		usuarios.put(3, "Rafaela");
		usuarios.put(4, "Rebeca");
		
		System.out.println(usuarios.size());
		System.out.println(usuarios.isEmpty());
		
		System.out.println(usuarios.keySet()); // Chaves
		System.out.println(usuarios.values()); // Valores
		System.out.println(usuarios.entrySet()); // Chave=Valor
		
		System.out.println(usuarios.containsKey(20));
		System.out.println(usuarios.containsValue("Rebeca"));
		
		System.out.println(usuarios.get(4));
		System.out.println(usuarios.remove(1));
		System.out.println(usuarios.remove(4, "Gui")); // Retorno falso
		
		for(int chave: usuarios.keySet()) {
			System.out.println(chave);
		}
		
		for(String valor: usuarios.values()) {
			System.out.println(valor);
		}
		
		for(Entry<Integer, String> registro: usuarios.entrySet()) {
			System.out.print(registro.getKey() + " ==> ");
			System.out.println(registro.getValue());
		}
	}
}

```
### Observações
 - Adicionar no MAP: put(1, "Marcus");
 - O método PUT, ele adiciona e substitui o valor antigo.
 - Quando adiciona um valor, com uma chave já existente, ele substitui o valor.

---

# HashCode na Prática

### Exemplo HashCode

```java
package colecoes;

public class Usuario {

	String nome;
	
	Usuario(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "Meu nome é " + this.nome + ".";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}

```
```java
package colecoes;

import java.util.HashSet;

public class Hash {

	public static void main(String[] args) {
		
		HashSet<Usuario> usuarios = new HashSet<Usuario>();
		
		usuarios.add(new Usuario("Pedro"));
		usuarios.add(new Usuario("Ana"));
		usuarios.add(new Usuario("Guilherme"));
		
		boolean resultado = usuarios.contains(new Usuario("Guilherme"));
		System.out.println(resultado);
	}
}
```

💡 - **Ao comentar o HashCode da classe usuário, ele não encontra mais o usuário Guilherme.**


💡 - **O HashSet é mais rápido para a pesquisa do que o List**💡