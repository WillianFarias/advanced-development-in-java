package aula05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class InferenciaExemplo {

	public static void main(String[] args) throws IOException {

	}

	public static void connectAndPrintURLJavaOracle() throws IOException {
		// var nao pode ser usado em nivel de classe
		// var nao pode ser usado como parametro
		// var nao pode ser usado em variaveis locais nao iniciadas

		var url = new URL("https://docs.oracle.com/javase/10/language/");
		var urlConnection = url.openConnection();

		try (var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
			System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
