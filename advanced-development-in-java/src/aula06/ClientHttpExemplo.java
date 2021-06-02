package aula06;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ClientHttpExemplo {
	
	static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
		@Override
		public Thread newThread(Runnable runnable) {
			Thread thread = new Thread(runnable);
			//Daemon sao threads que nao impedem que a JVM seja finalizada
			System.out.println("Nova Thread Criada :: "+ (thread.isDaemon() ? "daemon" : "") + " Thread Group :: " + thread.getThreadGroup());
			return thread;
		}
	});
	
	public static void main(String[] args) throws IOException, InterruptedException {

		//connectAndPrintURLJavaOracle();
		connectAndPrintURLJavaOracle();
	}

	public static void connectAndPrintURLJavaOracle() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.GET().uri(URI.create("https://docs.oracle.com/javase/10/language/"))
				.build();
		
		//Responsavel por fazer a execusao
		HttpClient httpClient = HttpClient.newHttpClient();
		
		//Conteudo da resposta
		//HTTP2 consegue trabalhar com concorrencia, diferente de HTTP1
		//É necessario que o servidor possua suporte a HTTP2
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println("Status code: " + response.statusCode());
		System.out.println("Headers: response: " + response.headers());
		System.out.println(response.body());
	}
}
