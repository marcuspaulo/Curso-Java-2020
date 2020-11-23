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
