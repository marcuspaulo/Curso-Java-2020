package streamapi;

public class MediaTeste {

    public static void main(String[] args) {
        Media media1 = new Media().adicionar(8.3).adicionar(6.7);
        Media media2 = new Media().adicionar(7.9).adicionar(6.6);

        System.out.println(media1.getValor());
        System.out.println(media2.getValor());

        System.out.println(Media.combinar(media1, media2).getValor());
    }
}
