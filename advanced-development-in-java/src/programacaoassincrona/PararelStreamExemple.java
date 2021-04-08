package programacaoassincrona;

public class PararelStreamExemple {
  
  public static void main(String[] args) {
    
  }

  public static long fatorial(long num) {
    long fat = 0l;

    for (int i = 2; i < num; i++) {
      fat *= i;
    }

    return fat;
  }

  
}
