import java.util.function.Consumer;

public class Consumidores {
  public static void main(String[] args) {
    //utiliza o parametro da forma que ele foi recebido

    //método de referencia
    Consumer<String> imprimirFrase = System.out::println;

    Consumer<String> imprimirFrase02 = frase -> System.out.println(frase);
    imprimirFrase.accept("Hello World!");
  }
}
