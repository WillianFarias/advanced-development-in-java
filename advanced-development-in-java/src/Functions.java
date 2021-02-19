import java.util.function.Function;

public class Functions {
  public static void main(String[] args) {
    Function<String, String> retornaNomeAoContrario = texto -> 
      new StringBuilder(texto).reverse().toString();

    Function<String, Integer> converterStringParaInteiro = //string -> 
      //Integer.valueOf(string) * 2;
      Integer::valueOf;

    System.out.println(retornaNomeAoContrario.apply("João"));
    System.out.println(converterStringParaInteiro.apply("10"));
  }
}
