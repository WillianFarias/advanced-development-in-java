import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) throws Exception {
        //paradiguima funcional
        UnaryOperator<Integer> calcularValorVezesTres = valor -> valor * 3;
        int valor = 10;
        System.out.println("O resultado é :: " + calcularValorVezesTres.apply(10));

        //paradiguima imperativo
        /*int valor = 10;
        int resultado = valor * 3;
        System.out.println("O resultado é :: " + resultado);*/
    }
}
