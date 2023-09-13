package com.analytics.quickanalytics.kafka;

import com.analytics.quickanalytics.entities.Money;
import com.analytics.quickanalytics.entities.Wallet;
import com.analytics.quickanalytics.services.MoneyService;
import com.analytics.quickanalytics.services.WalletService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final MoneyService moneyService;
    private final WalletService walletService;
    private final ObjectMapper objectMapper;

    @Value("${topic.name.money}")
    private String topicMoney;

    @Value("${topic.name.wallet}")
    private String topicWallet;

    @KafkaListener(topics = "${topic.name.money}")
    public void consumeAllMoney(ConsumerRecord<String, String> payload) {
        log.debug("Topic: {}", topicMoney);
        log.debug("key: {}", payload.key());
        log.debug("Headers: {}", payload.headers());
        log.debug("Partition: {}", payload.partition());
        log.debug("Order: {}", payload.value());
        try {
            List<Money> currencies = Arrays.asList(objectMapper.readValue(payload.value(), Money[].class));
            moneyService.saveAllMoney(currencies);
        } catch (IOException e) {
            log.error("Error parsing JSON: {}", e.getMessage());
        }
    }

    @KafkaListener(topics = "${topic.name.wallet}")
    public void consumeWallet(ConsumerRecord<String, String> payload) {
        try {
            log.debug("Topic: {}", topicWallet);
            List<Wallet> wallets = Arrays.asList(objectMapper.readValue(payload.value(), Wallet[].class));
            walletService.saveWalletsInformation(wallets);
        } catch (IOException e) {
            log.error("Error parsing JSON: {}", e.getMessage());
        }
    }
}
