public class FuncaoAltaOrdem {
  public static void main(String[] args) {
    Calculo soma = (a, b) -> a + b;
    Calculo subtracao = (a, b) -> a - b;
    Calculo multiplicacao = (a, b) -> a * b;
    System.out.println(executaOperacao(soma, 1, 3));
    System.out.println(executaOperacao(subtracao, 5, 3));
    System.out.println(executaOperacao(multiplicacao, 3, 3));
  }

  public static int executaOperacao(Calculo calculo, int a, int b) {
    return calculo.somar(a, b);
  }
}

@FunctionalInterface
interface Calculo {
  public int somar(int a, int b);
}

//Funcao de alta ordem, por padrao recebe uma funcao como parametro
//ou retorna uma funcao