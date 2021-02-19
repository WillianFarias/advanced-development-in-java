import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Iteracao {
  public static void main(String[] args) {
    
    String[] nomes = {"João", "Paulo", "Oliveira", "Santos", "Instrutor", "java"};
    Integer[] numeros = {1, 2, 3, 4, 5};
    //imprimirNomesFiltrados(nomes);
    //imprimirTodosNomes(nomes);
    //imprimirDobroValores(numeros);

    List<String> profissoes = new ArrayList<>();
    profissoes.add("Desenvolvedor");
    profissoes.add("Gerente de Projeto");
    profissoes.add("Gerente de Qualidade");
    profissoes.add("Testador");

    //Stream é baseada no paradigma funcional
    profissoes.stream()
      .filter(profissao -> profissao.startsWith("Gerente"))
      .forEach(System.out::println);
  }

  public static void imprimirNomesFiltrados(String... nomes) {
    String nomesParaImprimir = "";

    for(int i = 0; i < nomes.length; i++) {
      if (nomes[i].equals("João")) {
        nomesParaImprimir+= " " + nomes[i];
      }
    }

    System.out.println(nomesParaImprimir);
  }

  public static void imprimirTodosNomes(String... nomes) {
    /*for (String nome : nomes) {
      System.out.println(nome);
    }*/
    Stream.of(nomes).forEach(System.out::println);
  }

  public static void imprimirDobroValores(Integer... numeros) {
    /*for (Integer numero : numeros) {
      System.out.println(numero * 2);
    }*/
    Stream.of(numeros)
      .map(numero -> numero * 2)
      .forEach(System.out::println);;
  }
}
