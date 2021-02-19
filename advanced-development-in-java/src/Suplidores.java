import java.util.function.Supplier;

public class Suplidores {
  public static void main(String[] args) {
    Supplier<Pessoa> instanciaPessoa = Pessoa::new; //() -> new Pessoa();
    System.out.println(instanciaPessoa.get());
  }
}

class Pessoa {
  
  private String nome;
  private Integer idade;

  public Pessoa() {
    nome = "Willian";
    idade = 27;
  }

  public String toString() {
    return String.format("nome : %s, idade: %s", nome, idade);
  }
}
