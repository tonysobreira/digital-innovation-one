package digitalinnovation.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import digitalinnovation.example.dto.MessageSend;
import digitalinnovation.example.dto.ResultBotTelegramList;
import digitalinnovation.example.service.Telegram;

@RestController
@RequestMapping("/v1/telegram")
public class TelegramController {

    private Telegram telegram;
    
    private ObjectMapper objectMapper;

    public TelegramController(Telegram telegram, ObjectMapper objectMapper) {
        this.telegram = telegram;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity enviarMensagem(@RequestBody MessageSend messageRequest) {
        System.out.println("Entrou no post");
        telegram.enviarMensagem(messageRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<ResultBotTelegramList> buscarAtualizacao() {
        ResultBotTelegramList getUpdatesResultBotTelegram = telegram.buscarAtualizacao();
        return ResponseEntity.ok(getUpdatesResultBotTelegram);
    }
    
}