package aula06;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ClientHttpExemplo {

	static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
		@Override
		public Thread newThread(Runnable runnable) {
			Thread thread = new Thread(runnable);
			// Daemon sao threads que nao impedem que a JVM seja finalizada
			System.out.println("Nova Thread Criada :: " + (thread.isDaemon() ? "daemon" : "") + " Thread Group :: "
					+ thread.getThreadGroup());
			return thread;
		}
	});

	public static void main(String[] args) throws IOException, InterruptedException {

		// connectAndPrintURLJavaOracle();
		conectAkamaiHttpClient();
	}

	private static void conectAkamaiHttpClient() {
		//System.out.println("Running HTTP/1.1 example");
		System.out.println("Running HTTP/2 example");
		try {
			HttpClient client = HttpClient.newBuilder()
					.version(Version.HTTP_2)
					.proxy(ProxySelector.getDefault())
					.build();

			// performace
			long start = System.currentTimeMillis();

			HttpRequest mainRequest = HttpRequest.newBuilder()
					.uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html")).build();

			HttpResponse<String> response = client.send(mainRequest, HttpResponse.BodyHandlers.ofString());

			System.out.println("Status Code ::: " + response.statusCode());
			System.out.println("Response Headers ::: " + response.headers());
			String responseBody = response.body();
			System.out.println(responseBody);

			List<Future<?>> future = new ArrayList<>();

			responseBody.lines().filter(line -> line.trim().startsWith("<img height"))
					.map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>"))).forEach(image -> {
						Future<?> imgFuture = executor.submit(() -> {
							HttpRequest imgRequest = HttpRequest.newBuilder()
									.uri(URI.create("https://http2.akamai.com/" + image)).build();

							try {
								HttpResponse<String> imageResponse = client.send(imgRequest,
										HttpResponse.BodyHandlers.ofString());
								System.out.println("Imagem Carregada ::  " + image + ", status code :: "
										+ imageResponse.statusCode());
							} catch (IOException | InterruptedException e) {
								e.printStackTrace();
							} 
						});

						future.add(imgFuture);
						System.out.println("Submetido um futuro para imagem :: " + image);
					});

			future.forEach(f -> {
				try {
					f.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				} 
			});

			long end = System.currentTimeMillis();
			System.out.println("Tempo de carregamento total: " + (end - start) + " ms");

		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}

	public static void connectAndPrintURLJavaOracle() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("https://docs.oracle.com/javase/10/language/")).build();

		// Responsavel por fazer a execusao
		HttpClient httpClient = HttpClient.newHttpClient();

		// Conteudo da resposta
		// HTTP2 consegue trabalhar com concorrencia, diferente de HTTP1
		// É necessario que o servidor possua suporte a HTTP2
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("Status code: " + response.statusCode());
		System.out.println("Headers: response: " + response.headers());
		System.out.println(response.body());
	}
}
