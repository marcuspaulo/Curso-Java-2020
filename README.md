# Java 2020 COMPLETO

`Estrutura de Dados tem o objetivo de organizar e administrar os dados.`
`Ex. O 3 não é estrutura de dados, porém o número inteiro sim.`

--- 

## Tipos de Filas
 - FIFO - First In, First Out - O primeiro que entra, é o primeiro que sai.
 - LIFO (Pilha) - Last In, First out - O último é o primeiro a sair
 - Árvore - Similar ao sistema de pastas dos sistemas operacionais.
 - Tabela - Organizar em linhas e colunas
 - 

---
## Exercicio:
1 - Projeto: faculdade
2 - O que tem em uma faculdade

---

# Comentários

1 - Comentário de uma linha
```java
// Comentário de 1 linha
```

2 - Comentários de múltiplas linhas
```java
/*
Linha 1
Linha 2
*/
```
3 - Comentário JavaDoc

```java
/**
* Esta classe representa ...
* @author Marcus Paulo
* @since JDK11
* Linha 2
*/
```
 - O @ possui vários opções para melhorar o JavaDocs

 `É importante comentar, apenas quando necessário``

---
# Java 9
# Interpretador que foi adicionado a partir do Java 9
## jshell

```sh
❯ jshell 
|  Welcome to JShell -- Version 13.0.1
|  For an introduction type: /help intro

jshell> System.out.println("JShell Test");
JShell Test

jshell> 5.0/9.0
$4 ==> 0.5555555555555556
```

---
# Java 10
# Inferência Recurso do Java 10

Recurso inferência introduzido no Java 10
 * Observação, uma vez associado o tipo, não é possível mudar

 ```java
 /**
 * Recurso inferência introduzido no Java 10
 * Observação, uma vez associado o tipo, não é possível mudar
 * @since JDK 10
 */
public class Inferencia {

    public static void main(String[] args) {
        var numero = 3.5;
        System.out.println(numero);

        var numeroInteiro = 10;
        System.out.println(numeroInteiro);

        var texto = "Texto";
        System.out.println(texto);

        texto = "Texto para o exemplo";
        System.out.println(texto);

        // Erro: é preciso inicializar, caso contrário dá erro. Só asism o Java consegue descobrir o tipo
        //var e;
        //e = 15

        // Erro 2: Erro, já que mudou o tipo depois da inicialização
        var numeroTeste = 20; //inteiro
        numero = 1.25;
    }
}

 ```

 ---

 # Tipos primitivos do Java
### 8 tipos primitivos
`1 byte = 8 bits (0 ou 1) - a primeira casa, significa se é positivo ou negativo (0 ou 1 também)`
 ## Tipos primitivos que representam números inteiros
 ## A diferença entre eles é o tamanho
  - byte  -  (1 byte) - -128 até +127
  - short -  (2 byte) - ±32.767
  - int   -  (4 byte) - 2 bilhões
  - long  -  (8 byte) - número grande

## Tipos primitivos com pontos flutuantes
  - float  -  (4 byte) 
  - double -  (8 byte)
  Exemplo
  ```java
    double a = 3; // Inteiro
    double b = 3.2; //double
  ```

## Tipos primitivos
  - char  -  'c', '', '?';
  - boolean -  (true or false)

  * Observação: Você pode utilizar o byte para armazenar o tempo em que o funcionário está trabalhando em uma empresa, o byte dá, porém o ideal é que seja o int.

### Conversão
 - Sempre que tiver uma conversão de um tipo menor (capacidade) para um de maior capacidade, não tem problema, o inverso é um problema.

 `Obsevação: é possível separar os números por ponto ou underline. Exemplo: long pontosAcumulados = 3_234_234;`

 ```java
  long pontosAcumulados = 3_124_765_234L; // é necessário dizer que é Long, já que é maior do que o int

  float salario = 11_450F; //Pode utilizar F ou f;
 ```

 ```java
 public class TiposPrimitivos {

    public static void main(String[] args) {
        // Informações do funcionario

        // Tipos numéricos inteiros
        byte anosDeEmpresa = 23;
        short numeroDeVoos = 542;
        int id = 56789;
        long pontosAcumulados = 3_134_845_223L;

        // Tipos numéricos reais
        float salario = 11_445.44F;
        double vendasAcumuladas = 2_991_797_103.01;

        // Tipo booleano
        boolean estaDeFerias = false; // true

        // Tipo caractere
        char status = 'A'; // ativo

        // Dias de empresa
        System.out.println(anosDeEmpresa * 365);

        // Número de viagens
        System.out.println(numeroDeVoos / 2);

        // Pontos por real
        System.out.println(pontosAcumulados / vendasAcumuladas);

        System.out.println(id + ": ganha -> " + salario);
        System.out.println("Férias? " + estaDeFerias);
        System.out.println("Status: " + status);
    }
}
 ```

 # Notação Ponto (NotacaoPonto.java)
## String 

Se por exemplo, você precisa colocar um texto maíusculo, você pode utilizar: 
```java
  texto.toUpperCase();
```

Porém, se quiser propagar, é necessário atribuir a uma variável
```java
  texto = texto.toUpperCase(); //TESTANDO
```
 
----
# Tipo String > (TipoString.java)
 - %s = String
 - %d = inteitos
 - %f = valores com pontos flutuantes

```java
// .2f Define as 2 casas decimais
System.out.printf("O senhor %s %s tem %d anos e ganha R$%.2f.", nome, sobrenome, idade, salario);

//ou 

String frase = String.format("\nO senhor %s %s tem %d anos e ganha R$%.2f.", nome, sobrenome, idade, salario);
System.out.println(frase);
```

```java
System.out.println("Frase qualquer".substring(6, 10)); // Inclui o caracter 6, mas não inclui o 10
// Resultado: qual
```
---

# Console (Console.java)
```java
System.out.printf("Megasena: %d %d %d %d %d %d %n", 1, 2, 3, 4, 5, 6); // print formatado
```
### Entrada (Input do Console)
```java
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = entrada.nextLine(); // Nextline salva na variável nome

        System.out.print("Digite o seu sobrenome: ");
        String sobrenome = entrada.nextLine();

        System.out.print("Digite a sua idade: ");
        int idade = entrada.nextInt();

        System.out.printf("%s %s tem %d anos.%n",
                nome, sobrenome, idade);

        entrada.close(); // Finalizar o input do console. 
```

# Wrappers é a versão Objeto dos tipos primitivos
```java
// Wrappers são a versão objeto dos tipos
        // primitivos!
        int a = 123;
        System.out.println(a);
```

# Conversão
Existem algumas configurações que não são factíveis

## Conversão de forma implícita, o inverso necessita de uma conversão explícita.
 short > int > float > double 

 *A conversão explícita, você pode perder precisão ou partes do número*

 ### Necessita de uma 

# Conversão String Numero
```java
public class ConversaoStringNumero {

    public static void main(String[] args) {
        String valor1 = JOptionPane.showInputDialog(
                "Digite o primeiro número:");
        String valor2 = JOptionPane.showInputDialog(
                "Digite o segundo número:");

        System.out.println(valor1 + valor2);

        double numero1 = Double.parseDouble(valor1);
        double numero2 = Double.parseDouble(valor2);

        double soma = numero1 + numero2;
        System.out.println("Soma é " + soma);
        System.out.println("Média é " + soma / 2);
    }
}
```

# Conversão String Numero
```java
import javax.swing.JOptionPane;

public class ConversaoStringNumero {

    public static void main(String[] args) {
        String valor1 = JOptionPane.showInputDialog(
                "Digite o primeiro número:");
        String valor2 = JOptionPane.showInputDialog(
                "Digite o segundo número:");

        System.out.println(valor1 + valor2);

        double numero1 = Double.parseDouble(valor1); // String para double
        double numero2 = Double.parseDouble(valor2);

        double soma = numero1 + numero2;
        System.out.println("Soma é " + soma);
        System.out.println("Média é " + soma / 2);
    }
}
```
 - Olhar a classe: `DesafioConversao`
`Observação: Para números com precisão, utilize o BigDecimal.`
`Observação 2: O resultado de algumas operações gera um valor com várias casas decimais, isso é que a JDK opta por perder a precisão e melhorar o desempenho`

---

# Operadores
## Operadores Unários
Geralmente, utilizado em incremento, como por exemplo `numero++`
Prefix: ++a 
Postfix: a++;
Infix: 3+2

## Operadores Binário
Utiliza operador binário em uma soma, ou subtração, por exemplo.

## Operador Ternário
v ? v : v

---

# Operadores aritméticos

### Operador módulo
```java
System.out.println(a % b); // Operador módulo (resto da divisão)

double numA = Math.pow(6 * (3 + 2), 2); // Potência
```

*Observação: O resultado da operação é sempre do maio tipo, exemplo uma soma de um int + float, o resultado é float*

# Operadores Lógicos
## Tabela verdade

# e && 
`Se tiver um false, o resultado será falso.`

Valor 1 | Valor 2 | Resultado
--- | --- | ---
V | V | `V`
V | F | `F`
F | V | `F`
F | F | `F`

# Ou ||

Valor 1 | Valor 2 | Resultado
--- | --- | ---
V | V | `V`
V | F | `V`
F | V | `V`
F | F | `F`


# Xor ^

Valor 1 | Valor 2 | Resultado
--- | --- | ---
V | V | `F`
V | F | `V`
F | V | `V`
F | F | `F`

# Not !
`Se tiver um false, o resultado será falso.`

 - !true = false;
 - !false = true;

 - !!true = true;
 - !!false = false;

```java
public class Logicos {

    public static void main(String[] args) {

        boolean condicao1 = true;
        boolean condicao2 = 3 > 7;

        System.out.println(condicao1 && !condicao2);
        System.out.println(condicao1 || condicao2);
        System.out.println(condicao1 ^ condicao2);
        System.out.println(!!condicao1); //false
        System.out.println(!condicao2); //true

        System.out.println("Tabela verdade E (AND)");
        System.out.println(true && true);
        System.out.println(true && false);
//		System.out.println(false && true);
//		System.out.println(false && false);

        System.out.println("\nTabela verdade OU (OR)");
//		System.out.println(true || true);
//		System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);

        System.out.println("\nTabela verdade OU Exclusivo (XOR)");
        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println(false ^ false);

        System.out.println("\nTabela verdade NOT");
        System.out.println(!true);
        System.out.println(!false);
    }
}
```

---

# Operadores Relacionais

```java
public class Relacionais {
    public static void main(String[] args) {

        int a = 97;
        int b = 'a';

        System.out.println(a == b); // true // Não é legal utilizar
        System.out.println(30 != 7);
        System.out.println(3 > 4);
        System.out.println(3 >= 3);
        System.out.println(3 < 7);
        System.out.println(30 <= 7);

        double nota = 9.9;
        boolean bomComportamento = false;
        boolean passouPorMedia = nota >= 7;
        boolean temDesconto = bomComportamento && passouPorMedia;

        System.out.println("Tem desconto? " + temDesconto);
    }
}
```

---

# Operadores de Atribuição

```java
public class Atribuicao {

	public static void main(String[] args) {
		
		int a = 3; // a recebe valor 3
		int b = a;
		int c = a + b;
		
		c += b; // c = c + b; 
		c -= a; // c = c - a;
		c *= b; // c = c * b;
		c /= a; // c = c / a;
		
		System.out.println(c);
		
		c %= 2; // c = c % 2; Resultado: 0 ou 1
		System.out.println(c);
	}
}
```

# Operadores Unários
```java
public class Unarios {

    public static void main(String[] args) {

        int a = 1;
        int b = 2;

        a++; // a = a + 1
        a--; // a = a - 1

        ++b; // b = b + 1;
        --b; // b = b - 1;

        System.out.println(a);
        System.out.println(b);

        System.out.println("Mini Desafio...");
        System.out.println(++a == b--); // Aqui a precedência é ++a, depois == e depois decremento no b
        System.out.println(a == b);
        System.out.println(a);
        System.out.println(b);
    }
}
```

# Operador Ternátio (operadores/Ternario.java)

```java
double media = 8.6;
String resultadoFinal = media >= 7.0 ? "aprovado." : "em recuperação.";
```

---

# Comparação de String

A comparação de Strings deve ser feita com equals ou equalsIgnoreCase, já que compara o valor. Cuidado, comparar com o ==, pode dar problema.

*Curiosidade: No Scanner, o next(), já faz o trim()*

```java
package operadores;

import java.util.Scanner;

public class TipoStringEquals {

    public static void main(String[] args) {
        System.out.println("2" == "2"); // Resultado verdadeiro

        String s1 = new String("2");
        System.out.println("2" == s1); // Resultado são falso, o valor igual, mas a referência a diferente.
        System.out.println("2".equals(s1)); // Aqui é a comparação do valor

        Scanner entrada = new Scanner(System.in);

        String s2 = entrada.next();
        System.out.println("2" == s2.trim()); // Resultado falso, errado comparar String dessa forma, utilize o Equals
        System.out.println("2".equals(s2.trim()));

        entrada.close();
    }
}
```

---

# JRE vs JDK
`JVM - Java Virtual Machine`

A compilação de uma classe .java, gera um .class

 - JRE - Java Runtime Enviroment (Usuário) (é onde é executado)
 - JDK - Java Development Kit (Desenvolvedor) + incluso o JRE


 .java -> .class --> bytecode

 O Bytecode não é interpretado pelo Windows, Mac, Linux, Android, ...

 Para que os sistemas operacionais entendam, é necessária uma JVM específica para o Windows, que `interpreta` para nos comandos do sistema operacional que ele está.

 ## `O Java é compilado, gera um .class, que por sua vez, o bytecode é interpretado pela JVM`.


### Se você tiver um `eclipse ` + `JRE`, você vai conseguir desenvolver, já que o Eclipse, possui um JDK embarcado.

---
# Java x Javac

```java
public class TestJava {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }
}
```
### Compilação .java -> .class
```java
javac TestJava.java
```

### Visualizando o .class (Bytecode)
```java
cat TestJava.class 
����9

java/lang/Object<init>()V



java/lang/SystemoutLjava/io/PrintStream;
HelloWorld

java/io/PrintStreamprintln(Ljava/lang/String;)TestJavaCodeLineNumberTablemain([Ljava/lang/String;)V
��stJava.java!*��       %       �
```
## Executar
```java
java TestJava
```

---

# Estruturas de Controle (Condicional)

```text
// if(...) sentença; ou {}
// while(...) sentença; ou {}
// for(..., ..., ...) sentença; ou {}
// do {} while(); // a única que termina com ;
```

## If

`Pegadinha`
```java
package controle;

public class DesafioIf {

	public static void main(String[] args) {

		double nota = 1.3;

		// não usar ;  em estruturas de controle (tem um exceção)
		if (nota >= 9.0); {
			System.out.println("Quadro de Honra!");
			System.out.println("Você é fera!!!");
		}
	}
}
```

### Repare que a próxima linha é o ; que é válida:

```java
if (nota >= 9.0)

; // Caso a condição seja verdadeira, esse é o resultado apresentado e segue o código

{
    System.out.println("Quadro de Honra!");
    System.out.println("Você é fera!!!");
}
```
## While (Pode ser executado 0 ou n vezes)
Você pode executar uma condição de forma indeterminada, caso queira.

## Do While (Você escreve de 1 ou n vezes)

```java
package controle;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);

		String texto = "";
		
		do {
			System.out.println("Você precisa falar as palavras mágicas...");
			System.out.print("Quer sair? ");
			texto = entrada.nextLine();
		} while(!texto.equalsIgnoreCase("por favor"));

		
		System.out.println("Obrigado!");
		entrada.close();
	}
}
```

# For alinhado
```java
package controle;

public class For3 {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) { // executa 9 vezes, incrementa o i e executa mais 9 vezes.
				System.out.printf("[%d %d]", i, j);
			}
			System.out.println();
		}
	}
}
```

# Desafio do For
Na segunda parte do código, você trabalha o for, sem o controle númerico.
```java
package controle;

public class DesafioFor {

	public static void main(String[] args) {
		
		String valor = "#";
		for(int i = 1; i <= 5; i++) {
			System.out.println(valor);
			valor += "#";
		}
		
		// Versão do desafio
		// Não pode usar valor numérico pra controlar o laço!
		
		for(String v = "#"; !v.equals("######"); v += "#") {
			System.out.println(v);
		}
	}
}
```
---
# Switch
## Switch sem o break 
Caso entre no primeiro Case, ele executa os demais

```java
package controle;

public class SwitchSemBreak {

	public static void main(String[] args) {

		String faixa = "marrom";

		switch (faixa.toLowerCase()) {
		case "preta":
			System.out.println("Sei o Bassai-Dai...");
		case "marrom":
			System.out.println("Sei o Tekki Shodan");
		case "roxa":
			System.out.println("Sei o Heian Godan");
		case "verde":
			System.out.println("Sei o Heian Yodan");
		case "laranja":
			System.out.println("Sei o Heian Sandan");
		case "vermelha":
			System.out.println("Sei o Heian Nidan");
		case "amarela":
			System.out.println("Sei o Heian Shodan");
			break;
		default:
			System.out.println("Não sei nada");
		}

		System.out.println("Fim!");
		
		int idade = 2;
		
		switch (idade) {
		case 3:
			System.out.println("Sabe programar");
		case 2:
			System.out.println("Sabe falar");
		case 1:
			System.out.println("Sabe andar");
		case 0:
			System.out.println("Sabe respirar");
		}
	}
}

```

## Switch com o Break
```java
package controle;

import java.util.Scanner;

public class SwitchComBreak {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String conceito = "";
		System.out.print("Informe a nota: ");
		int nota = entrada.nextInt();
		
		switch(nota) {
		case 10: case 9: 
			conceito = "A";
			break;
		case 8: case 7: {
			conceito = "B";
			break;
		}
		case 6:
		case 5:
			conceito = "C";
			break;
		case 4:
		case 3:
			conceito = "D";
			break;
		case 2: case 1: case 0:
			conceito = "E";
			break;
		default:
			conceito = "não encontrado!";
//			break;
		}
		
		System.out.println("Conceito é " + conceito);
		entrada.close();
	}
}
```
`Break` e `Continue` são palavras reservadas no java.
 - Break quebra o fluxo natural da execução.
  
```java
package controle;

public class Break {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			
			if(i == 5) {
				break; // Quebra o fluxo, sai da estrutura condicional
			}
			
			System.out.println(i);
		}
		
		System.out.println("Fim!");
	}
}

```

## Continue
O Continue interrompe apenas aquela execução e vai para a próxima, sem sair
da estrutura de controle.

```java
package controle;

public class Continue {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			if(i % 2 == 1) {
				continue; // se o número for ímpar, volta para o for. (Interrompe apenas, aquela execução)
			}
			
			System.out.println(i); // Imprimir apenas números pares
		}

		for (int i = 1; i <= 10; i++) {
			if(i == 5) continue;			
			System.out.println(i);
		}
	}
}
```

## Break Rotulado (Cuidado com a utilização)
Você pode rotular o for mais externo e chamar, quando necessário.

```java
package controle;

public class BreakRotulado {

	public static void main(String[] args) {
		
		externo:
		for (int i = 0; i < 3; i++) {
			interno: for (int j = 0; j < 3; j++) {
				if(i == 1) {
					break externo; // Sai do for mais externo
				}
				System.out.printf("[%d %d] ", i, j);
			}
			System.out.println();
		}
	
		System.out.println("Fim!");
	}
}

```

## Continue Rotulado

```java
package controle;

public class ContinueRotulado {
public static void main(String[] args) {
		
		externo:
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 1) {
					continue externo; //Continue do externo
				}
				System.out.printf("[%d %d] ", i, j);
			}
			System.out.println();
		}
	
		System.out.println("Fim!");
	}
}

```

---
# Classes e Métodos

O nome da Classe java, precisa ter o mesmo nome do arquivo.
É possível ter mais de uma classe dentro de um arquivo.

`Uma classe define um bloco de código`

O ideal, é que tenha apenas um método main em um arquivo java, ou seja, ele é
a única porta de entrada.

## Classes vs Objetos

### Anatomia de uma classe Java
`A primeira letra Maíuscula e as seguintes maíusculas também. Ex. PessoaFisica`
```java
 class Nome ... (Variações) {
     // Corpo
 }
```
Antes da palavra reservada `class`, você pode ter outros modificadores.

 - Corpo da classe (`Membros da Classe`): Existem atribuitos e comportamentos.

Exemplo: 
### Características do Carro: 
  - Cor
  - Modelo
### Comportamento
  - Ligar
  - Acelerar

----
Classe define um `TIPO (Personalizado seu)` (**Estrutura de dados**). `Uma classe é uma estrutura de dados`.

```text
A Classe representa uma `Abstração` (Simplificação).
```
Exemplo: 
 Você pode ter uma classe Produto.java, que pode ser utilizado
 em uma mercearia e um de uma grande redes. O que muda, talvez, seja, a quantidade de atributos (Ex. Localização, Impostos e etc)
 
 **Objeto == Instâncias**;

 `Acabei de instanciar 10 objetos do tipo Produto.`

## Relação Classe e Objeto

 - Classe: Planta Baixa (Molde)
 - Casa Construída - Instância (Valor dos atributos podem mudar, porém a estrutura permanece igual)
 - Casa Construída - Instância (Valor dos atributos podem mudar, porém a estrutura permanece igual)

`A partir de um único Molde (Classe), você pode construir vários objetos (Instâncias)`.

### Exemplo
```text
Produto 
  - Nome
  - Preço
  - Desconto

  Produto 1
  - Notebook
  - R$ 4.500
  - 15%

  Produto 2
  - Celular
  - R$ 1.800
  - 10%
```
**O `construtor` é um `método especial` que `cria` os `objetos`;**

---

# Membros de uma Classe
```text
 - Classe
    - Variáveis/Constante
    - Construtor(es)
    - Métodos
    - Classes
```
`Static` - atributo ou método pertence a classe.

`System.out.print` - A notação . é forma para acessar os membros de um objeto ou de uma classe.

----

## Método
Método é o comportamento da classe. (Ex. Você poderia ter um método para retornar o produto com desconto).

No método você tem uma sequência de passos, que pode ter condicionais ou não e pode gerar um resultado.

### Anatomia do Método
 - Convenção: nomeMetodo (Pascal Case ou Camel Case)

### Método sem retorno
```java
// Ausência de retorno
void nomeMetodo() {
    // corpo
}
```

### Método dois parâmetros e retorno
```java
// Ausência de retorno
int nomeMetodo(int a, int b) {
    // corpo
    return a + b;
}
```
---

# Construtor(es)
 Criam novos objetos a partir de uma classe. O nome da classe e o nome do constutor são iguais.


  💡 - O construtor padrão é fornecido por padrão. Caso você crie outro construtor, ele anula o construtor padrão. Caso queira, é necessário criar um construtor sem parâmetros. 
  - Método não tem retorno (ausência de retorno)
  - O retorno é do tipo da Classe
  - Colocando void, ele vira um método

### Utilizando o construtor padrão.
```java
Produto produto = new Produto();

Produto produto = new Produto("laptop");
```

---
# Membros de classe vs Instância #01

Exemplo:

Quando você cria uma nova instância, utilizando `new`, significa , que você vai criar uma instância, por sua vez, a Instância ter espaços para alocar os valores de cada variável. (Atributo de Instância ou atributo de objeto).

```java
class Data {
    int dia;
    int mes;
    int ano;
}
```
# Atributo de classe `static`
No momento em que você utiliza a palavra `static`, diz que o valor será associado a classe. Isso significa, que o dia estará associado a classe, enquanto que o mês e o ano, estarão associado a instância. Caso altere, ele vale para todas instâncias.
```java
class Data {
    int static dia = 3;
    int mes;
    int ano;
}
```
### Exemplo 2 - Atributo de Classe
```java
class Math {
    static double PI = 3.14;
}

...
System.out.print(Math.PI)
...
```
## Membro de Instância e membro de instância

Nesse trecho de código, ele é constante `final` e static já que está associado a classe.

💡 - Por convenção a constante fica com letra maíuscula.

```java
final static double PI = 3.1415;
```

### Método estático
```java
static double area(double raio) {
    return PI * Math.pow(raio, 2);		
}

//Utilização
...
System.out.print(AreaCirc.area(2.2, 3.8)); 
```

```java
package exercicios.src.classe;

public class AreaCirc {

	double raio;
	final static double PI = 3.1415;
	
	AreaCirc(double raioInicial) {
		raio = raioInicial;
	}
	
	double area() {
		return PI * Math.pow(raio, 2);
	}
	
	static double area(double raio) {
		return PI * Math.pow(raio, 2);		
	}
}
```
---

# Atribuição por valor vs Atribuição por referência

💡 - *Atribuição por valor: `Tipos primitivos`*;
💡 - *Atribuição por referência: `Objetos`*

## Atribuição por valor
```java
int a = 2;
int b = a;
```
Na memória vai existir: 

Memória | Valor 
--- | --- |
a | `2`
b | `2`
** Ou seja, é cada variável tem uma cópia do valor **

-----

## Atribuição por valor
```java
Data d1 = new Data();
Data d2 = 3;
int b = a;
```
Na memória vai existir: 

Memória | Valor 
--- | --- |
d1 | `0x123`
d2 | `0x123`
valor `0x123` | `3`

** Ou seja, tem uma atribuição do endereço, mesmo objeto na memória **

Se criar um novo objeto, ele não aponta mais para o endereço de memória antiga.
===
💡 - *Quando um objeto não é mais referênciado, entra em ação o `Garbage Collector`, que vai excluir da memória;*
===

Existe um método chamado `clone()`, já que ele gera uma cópia exata daquele objeto.

Cuidado com os métodos que alterem as referências do objeto;

### Exemplo 
```java
package exercicios.src.classe;

public class ValorVsReferencia {

	public static void main(String[] args) {
		
		double a = 2;
		double b = a; // atribuição por valor (Tipo primitivo)
		
		a++;
		b--;
		
		System.out.println(a + " " + b);
		
		Data d1 = new Data(1, 6, 2022);
		Data d2 = d1; // atribuição por referência (Objeto)
		
		d1.dia = 31;
		d2.mes = 12;
		
		d1.ano = 2025;
		
		System.out.println(d1.obterDataFormatada());
		System.out.println(d2.obterDataFormatada());
		
		voltarDataParaValorPadrao(d1);
		
		System.out.println(d1.obterDataFormatada());
		System.out.println(d2.obterDataFormatada());
		
		int c = 5;
		alterarPrimitivo(c);
		System.out.println(c);
	}
	
	static void voltarDataParaValorPadrao(Data d) {
		d.dia = 1;
		d.mes = 1;
		d.ano = 1970;
	}
	
	static void alterarPrimitivo(int c) {
		c++;
	}
}

```

---

# Desafio

Ao executar esse código dá erro 
Exception in thread "main" 

```java
package exercicios.src.classe;

public class PrimeiroTrauma {

	int a = 3;

	public static void main(String[] args) {
		System.out.println(a);
	}
}

```

# Resultado do Desafio
===
💡 - *Para resolver é necessário criar uma instância da classe PrimeiroTrauma. `Você só consegue acessar um membro de classe, se criar uma instância.`*
Não consegue acessar uma variável de instância a partir de um método estático.
Você pode mudar a variável para `static`, ai você pode acessar em um método estático.

===


```java
package exercicios.src.classe;

public class PrimeiroTrauma {

	int a = 3;
	static int b = 4;

	public static void main(String[] args) {
		
		PrimeiroTrauma p = new PrimeiroTrauma();
		System.out.println(p.a);
		
		System.out.println(b);
	}
}

```
---

# This e This()

Sempre que você quiser acessar uma variável que pertence a instância, você utilizar o `this.nomeVariavel`. Com o this você referencia o objeto atual.

💡 - **O `método estático é associado` a `classe` e o `this` é `associado` a uma `instância`.**


💡 - **Com um método estático, você não pode chamar o `this`**
```java
// Funciona
void imprimirDataFormatada() {
    this.dia = 3;
}
```

```java
// ERRO, não compila
static void teste() {
    this.dia = 3;
}
```


```java
public class Produto {
    String nome;

    Produto(String nome) {
        this.nome = nome; //this.nome pertence a instância
    }
}
```

### This() chamando outro construtor ou pode ser um outro método
💡 - **Não pode chamar um construtor pelo `this`, dentro de um método;**
```java
public class Produto {
    String nome;

    Produto() {
        this("Videogame");
    }

    Produto(String nome) {
        this.nome = nome; //this.nome pertence a instância
    }
}
```
---

# Variáveis locais
Quando uma variável é definida dentro do método, ou seja, a visibilidade da variável é apenas dentro do método. Se quiser, você pode definir como `final`, ou seja, ela terá um valor constante.

Os valores da assinatura de um método, são visíveis apenas.

# Valores Padrão
```java
 byte, short, int, long -> 0;
 float, double -> 0.0;
 boolean -> false;
 char -> '/u0000';
 //Objetos -> null;
 //String s = null;
```
💡 - **Variáveis locais não são inicializadas por padrão.**

💡 - **Variáveis definidas dentro do corpo da classe, serão inicializadas por padrão.**

💡 - **Objetos inicializados são inicializados nulo, ou seja, não aponta para nenhum objeto de memória**


### No exemplo abaixo, o código não compila, o motivo é que as variáveis locais não foram inicializadas. Para funcionar, basta inicializar com um valor
```java
 int a; // variável local
 System.out.println(a); //Erro: A variável local não é inicializada por padrão.
```

💡 - **Na String: Nulo é diferente de vazio, já que o valor vazio, possui um espaço na memória**

### Quando você define uma constante ou na definição ou no construtor; caso contrário, o código estará errado. O Objeto não pode ser criado, sem com que a constante tenha um valor definido.

```java
static int x; //Inicia com valor zero, por padrão
```
---

# Valor Nulo (Null) - Não aponta para nenhum local de memória
Se o objeto estiver null, se você tentar chamar um método, vai ocorrer o NullPointerException; Esse erro, só vai ocorrer em tempo de execução --> RuntimeException;



