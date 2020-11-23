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
