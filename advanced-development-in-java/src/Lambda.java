public class Lambda {
  public static void main(String[] args) {
    
    //interface funcional possui apenas uma funcao
    Funcao colocarPrefixoSenhorNaString = valor -> "Sr. " + valor;
    System.out.println(colocarPrefixoSenhorNaString.gerar("Willian"));
  }
}

//Essa anotacao garante que a interface deve ser funcional
@FunctionalInterface
interface Funcao {
  String gerar(String valor);
  
  //a unica forma de ter mais de um metodo em uma interface funcional é usar 
  //default metod
  default Integer gerarNumero(String valor){return 10;}
}
