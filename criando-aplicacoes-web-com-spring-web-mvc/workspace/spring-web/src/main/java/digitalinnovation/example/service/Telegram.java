package digitalinnovation.example.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import digitalinnovation.example.client.FeignClientClient;
import digitalinnovation.example.client.JavaHttpClient;
import digitalinnovation.example.client.RestTemplateClient;
import digitalinnovation.example.dto.MessageSend;
import digitalinnovation.example.dto.ResultBotTelegram;
import digitalinnovation.example.dto.ResultBotTelegramList;

@Service
public class Telegram {

	private RestTemplateClient restTemplateClient;

	private FeignClientClient feingClient;

	private JavaHttpClient javaHttpClient;

	public Telegram(RestTemplateClient restTemplateClient, FeignClientClient feingClient, JavaHttpClient javaHttpClient) {
		this.restTemplateClient = restTemplateClient;
		this.feingClient = feingClient;
		this.javaHttpClient = javaHttpClient;
	}

	public void enviarMensagem(MessageSend mensagem) {
		// HTTP CLIENT
//		ResultBotTelegram resultBotTelegramResponseEntity = javaHttpClient.enviarMensagem(mensagem);

		// RestTemplate
//		restTemplateClient.enviarMensagem(mensagem);

		// FeingClient
		ResultBotTelegram resultBotTelegram = feingClient.enviarMensagem1(mensagem);
	}

	public ResultBotTelegramList buscarAtualizacao() {
		// HTTP CLIENT
//		ResultBotTelegramList resultBotTelegramList = javaHttpClient.buscarAtualizacao();

		// RestTemplate
//		ResultBotTelegramList resultBotTelegramList = restTemplateClient.buscarAtualizacao();

		// FeingClient
//		feingClient.buscaratualizacao();
		ResultBotTelegramList resultBotTelegramList = feingClient.buscarAtualizacao();
		
		return resultBotTelegramList;
	}
	
}