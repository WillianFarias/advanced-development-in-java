import java.util.function.Predicate;

public class Predicates {
  public static void main(String[] args) {
    Predicate<String> estaVazio = String::isEmpty; //valor -> valor.isEmpty();
    System.out.println(estaVazio.test(""));
    System.out.println(estaVazio.test("arg0"));
  }
}
