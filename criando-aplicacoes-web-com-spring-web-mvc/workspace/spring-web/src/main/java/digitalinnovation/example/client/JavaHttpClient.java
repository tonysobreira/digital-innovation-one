package digitalinnovation.example.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import digitalinnovation.example.dto.MessageSend;
import digitalinnovation.example.dto.ResultBotTelegram;
import digitalinnovation.example.dto.ResultBotTelegramList;

@Component
public class JavaHttpClient {

	@Value("${telegram.api}")
	private String BASE_PATH;

	@Value("${telegram.token}")
	private String TOKEN;

	private HttpClient httpClient;

	private ObjectMapper objectMapper;

	public JavaHttpClient(ObjectMapper objectMapper) {
		this.httpClient = HttpClient.newHttpClient();
		this.objectMapper = objectMapper;
	}

	public ResultBotTelegramList buscarAtualizacao() {
		ResultBotTelegramList resultBotTelegramList = null;

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(BASE_PATH + TOKEN + "/getUpdates"))
				.GET()
				.build();

		HttpResponse<String> stringHttpResponse = sendRequest(request);

		try {
			resultBotTelegramList = objectMapper.readValue(stringHttpResponse.body(), ResultBotTelegramList.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBotTelegramList;
	}

	public ResultBotTelegram enviarMensagem(MessageSend msg) {
		ResultBotTelegram resultBotTelegram = null;

		String mensagem = null;

		try {
			mensagem = objectMapper.writeValueAsString(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(BASE_PATH + TOKEN + "/sendMessage"))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(mensagem))
				.build();

		HttpResponse<String> stringHttpResponse = sendRequest(request);

		try {
			resultBotTelegram = objectMapper.readValue(stringHttpResponse.body(), ResultBotTelegram.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBotTelegram;
	}

	private HttpResponse<String> sendRequest(HttpRequest request) {
		HttpResponse<String> httpResponse = null;

		try {
			httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return httpResponse;
	}

}
