package programacaoassincrona;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExemple {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    IntStream.range(1, 10000).forEach(num -> fatorial(num));// Serial
    long end = System.currentTimeMillis();
    System.out.println("Tempo de execução Serial: " + (end - start));

    start = System.currentTimeMillis();
    IntStream.range(1, 10000).forEach(num -> fatorial(num));// Parallel
    end = System.currentTimeMillis();
    System.out.println("Tempo de execução Parallel: " + (end - start));

    List<String> nomes = Arrays.asList("Willian", "Sousa", "Farias");
    nomes.parallelStream().forEach(System.out::println);
  }

  public static long fatorial(long num) {
    long fat = 0l;

    for (int i = 2; i < num; i++) {
      fat *= i;
    }

    return fat;
  }
}
