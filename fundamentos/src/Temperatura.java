package fundamentos.src;

/**
 * Conversão de temperatura
 * Formula: (ºF -32) * 5/9 = ºC
 */
public class Temperatura {

    public static void main(String[] args) {
        final double AJUSTE = 32;
        final double FORMULA_FATOR = 5.0 / 9.0;

        double fahrenheit = 86;

        double celsius = (fahrenheit - AJUSTE) * FORMULA_FATOR;

        System.out.println("O resultado é " + celsius + "ºC.");

        fahrenheit = 30;

        celsius = (fahrenheit - AJUSTE) * FORMULA_FATOR;

        System.out.println("O resultado é " + celsius + "ºC.");

    }
}
