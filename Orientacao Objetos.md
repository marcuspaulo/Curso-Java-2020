# Orientação a Objetos

## Reuso via composição

## Relacionamento Um pra um

Motor.java
```java
package oo.composicao;

public class Motor {

	final Carro carro;
	boolean ligado = false;
	double fatorInjecao = 1;
	
	Motor(Carro carro) {
		this.carro = carro;
	}
	
	int giros() {
		if(!ligado) {
			return 0;
		} else {
			return (int) Math.round(fatorInjecao * 3000);			
		}
	}
}
```
Relação Unidirecional;

```java
package oo.composicao;

public class Carro {

	final Motor motor;
	
	Carro() {
		this.motor = new Motor(this);
	}
	
	void acelerar() {
		if(motor.fatorInjecao < 2.6) {
			motor.fatorInjecao += 0.4;			
		}
	}
	
	void frear() {
		if(motor.fatorInjecao > 0.5) {
			motor.fatorInjecao -= 0.4;			
		}
	}
	
	void ligar() {
		motor.ligado = true;
	}
	
	void desligar() {
		motor.ligado = false;
	}
	
	boolean estaLigado() {
		return motor.ligado;
	}
}
```
💡 - **O importante é ter a coerência entre o relacionamento. Exemplo: Um carro possui um determinado motor.**

---

## Relacionamento Um pra Muitos
 - Relacionamento 1 compra para vários itens.
  
```java
package oo.composicao;

public class Item {

	String nome;
	int quantidade;
	double preco;
	Compra compra;
	
	Item(String nome, int quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
}

```

```java
package oo.composicao;

import java.util.ArrayList;

public class Compra {

	String cliente;
	ArrayList<Item> itens = new ArrayList<Item>();
	
	void adicionarItem(String nome, int quantidade, double preco) {
		this.adicionarItem(new Item(nome, quantidade, preco));
	}
	
	void adicionarItem(Item item) {
		this.itens.add(item);
		item.compra = this;
	}
	
	double obterValorTotal() {
		double total = 0;
		
		for(Item item: itens) {
			total += item.quantidade * item.preco;
		}
		
		return total;
	}
}

```
# Relacionamento Muitos para Muitos

```java
package oo.composicao;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	final String nome;
	final List<Curso> cursos = new ArrayList<>();
	
	Aluno(String nome) {
		this.nome = nome;
	}
	
	void adicionarCurso(Curso curso) {
		this.cursos.add(curso);
		curso.alunos.add(this);
	}
	
	Curso obterCursoPorNome(String nome) {		
		for(Curso curso: this.cursos) {
			if(curso.nome.equalsIgnoreCase(nome)) {
				return curso;
			}
		}
		
		return null;
	}
	
	public String toString() {
		return nome;
	}
}

```

```java
package oo.composicao;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	final String nome;
	final List<Aluno> alunos = new ArrayList<>();
	
	Curso(String nome) {
		this.nome = nome;
	}
	
	void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
		aluno.cursos.add(this);
	}
}
```

---

# Paradigmas de Programação
 - Não estruturado (GoTo) 
 - -------------------------> Edsger W. Dijkstra
 - Procedural (Ator principal é a função) - (Surgimento da função e melhoramento das estrutura de controle, if, else, for, while)
 - Funcional (foco é a função, é a função que alteram dados)
 - Orientação a objetos (Ator principal é o objeto) - (Foco no dado, ele é definido pela classe. A classe define um tipo, a classe define uma estrura de dados)


### Procedural:
formatarData(dataNascimento);

### Orientação a objetos
nascimento.formatarData();

### Curiosidade: 
💡 - **Edsger Wybe Dijkstra (Roterdã, 11 de maio de 1930 — Nuenen, 6 de agosto de 2002; IPA: [ˈɛtsxər ˈwibə ˈdɛɪkstra] (Loudspeaker.svg? ouvir)) foi um cientista da computação holandês, conhecido por suas contribuições nas áreas de desenvolvimento de algoritmos e programas, de linguagens de programação (pelo qual recebeu o Prêmio Turing de 1972 por suas contribuições fundamentais), sistemas operacionais e processamento distribuído.

A pronúncia aproximada em português para Edsger Dijkstra é étsrrar déikstra.[1]**
Fonte: Wikipédia[!https://pt.wikipedia.org/wiki/Edsger_Dijkstra#:~:text=ouvir))%20foi%20um%20cientista,sistemas%20operacionais%20e%20processamento%20distribu%C3%ADdo.]

---
💡 - **Java possui a palavra reservada `Goto`, porém, não é possível utilizar.**

---

# Encapsulamento
O objetivo é encapsular algo. Você não precisa saber detalhes, é necessário conhecer as interfaces;
Parte da complexidade precisa estar escondida para o mundo exterior.

Exemplo: Carro, parte do carro você interage como o volante, o acelerador, porém, você não interagem diretamente com outras partes, como a injeção eletrônica, por exemplo.

# Herança - Extends
 - Herda caracteristicas e atributos do "pai", exemplo: Carro --> Ferrari
 - **`É um(a)`**
 - Civic é um carro;
 - Gato é um mamífero;
 - Maçã é uma fruta;

	Super classe (+Genérica)
				⬆️ 
	Sub-classe (+Específica)

Uma classe só pode herda de uma classe.

Na herança você receber comportamentos e atributos, sem precisar necessariamente definir na classe mais específica (Sub-classe). (Exemplo: Um animal respira, na sub-classe, você pode sobrescrever o método da classe pai ou adicionar algumas caracteristcas)
Extends

@Override - herdando da classe pai (Sobrescrevendo)

# Chamando os construtores
 - Para chamar o construtor da classe, this e para chamar do Pai, super();
 - É obrigatório um construtor do filho, chamar o do pai.
 - Se o Pai não tiver um construtor padrão, é necessário definir como ele será chamado na sub-classe;


💡 - **Algumas linguagens tem a herança múltipla, quando uma classe herda de várias, isso acontece no C++, não funciona no Java**

## Composição
 - **`Tem um(a)`**
 - Carro tem um motor;
 - Carro têm portas;
 - Casa tem uma cozinha;

💡 - **Dica: Geralmente, é melhor utilizar composição do que herança, já que é mais flexível.**

---

# Polimorfismo
Existem dois tipos de polimorfismo: Estático (Sobrecarga) e o Dinâmico

 - Estático (Sobrecarga) - métodos com o mesmo nome e parâmetros diferentes; Ele é estático, por que você escreveu no seu código aqueles métodos.
  
 - Dinâmico (Herança) - 
   Ex.: 
	 `Civic civic = new Civic(); // Herda de carro`
	 Mas existe essa possibilidade: 
	 `Carro carro = new Civic();`
	 Poliformismo: 
	 `carro = new Ferrari();`

## Opções de utilização no método: 
Nesse caso, só aceita Civic
 `void estacionar(Civic civic) {...}`

Nesse outro exemplo, ele vai aceitar qualquer tipo de carro, que herde da classe Carro
`void estacionar(Carro carro) {...}`

---

# Enum
```java
package oo.heranca;

public enum Direcao {
	
	NORTE, LESTE, SUL, OESTE;
}
```

---
# Modificadores de acesso
 - public - Atributo e método, pode ser acessado por todo mundo;
 - protected - Atributo e método é visivel por herança;
 - package (default) - Consegue acessar atributos e métodos dentro do mesmo pacote;
 - private - Atributo ou método só pode ser acessando na mesma classe;


💡 - **Uma classe só aceita o modificador (Default) ou público**

---

# Getters and Setters
Getters e Setters para acessar fora da classe;

# Interface
 - Pode implementar mais de uma inteface
 - Todo método é publico e abstract(Não tem corpo) (mesmo que não esteja explícito)

Implementando duas interfaces: 

```java
package oo.heranca.desafio;

public interface Esportivo {

	public abstract void ligarTurbo();
	public abstract void desligarTurbo();
}
```

```java
package oo.heranca.desafio;

public interface Luxo {

	public void ligarAr();
	abstract void desligarAr();
	
	default int velocidadeDoAr() {
		return 1;
	}
}

```

```java
package oo.heranca.desafio;

public class Ferrari extends Carro implements Esportivo, Luxo {

	private boolean ligarTurbo = false;
	private boolean ligarAr = false;
	
	public Ferrari() {
		this(315);
	}
	
	public Ferrari(int velocidadeMaxima) {
		super(velocidadeMaxima);
		setDelta(15);
	}
	
	@Override
	public void ligarTurbo() {
		ligarTurbo = true;
	}
	
	@Override
	public void desligarTurbo() {
		ligarTurbo = false;
	}
	
	@Override
	public void ligarAr() {
		ligarAr = true;
	}
	
	@Override
	public void desligarAr() {
		ligarAr = false;
	}
	
	@Override
	public int getDelta() {
		if(ligarTurbo && !ligarAr) {
			return 35;
		} else if(ligarTurbo && ligarAr) {
			return 30;
		} else if(!ligarTurbo && !ligarAr) {
			return 20;
		} else {
			return 15;			
		}
	}
	
//	@Override
//	public void acelerar() {
//		super.acelerar();
//	}
}

```
# Implementando um método na Interface:

```java
package oo.heranca.desafio;

public interface Luxo {

	public void ligarAr();
	abstract void desligarAr();
	
	default int velocidadeDoAr() { //método que é opcional
		return 1;
	}
}
```

---

# Classe Abstrata
 - Classe concreta 100% dos métodos implementado. (Tem corpo);
 - Na interface 0% dos métodos implementados (Sem corpo);
 - Classe Abstrata pode ter métodos concreto com o corpo e pode ter métodos sem implementação;
 - Uma classe Abstrata não pode ser instanciada; // Erro Pessoa pessoa = new Pessoa();
 - Você cria uma classe Abstrata, quando você quer herdar (Herança);
 - `Se o método for final, ele não pode ser herado;`

```java
package oo.abstrato;

public abstract class Animal {

	public String respirar() {
		return "Usando Oxigênio";
	}
	
	public abstract String mover();
}

```

Herdando na classe Cachorro
```java
package oo.abstrato;

public class Cachorro extends Mamifero {
	
	@Override
	public String mover() {
		return "Usando as patas";
	}
	
	@Override
	public String mamar() {
		return "Usando leite";
	}
}
```



💡 - ****