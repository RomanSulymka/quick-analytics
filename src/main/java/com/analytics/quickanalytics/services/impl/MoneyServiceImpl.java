package com.analytics.quickanalytics.services.impl;

import com.analytics.quickanalytics.entities.Money;
import com.analytics.quickanalytics.repositories.MoneyRepository;
import com.analytics.quickanalytics.services.MoneyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MoneyServiceImpl implements MoneyService {
    private final MoneyRepository moneyRepository;

    @Override
    public void saveAllMoney(List<Money> monies) {
        List<Money> existingMonies = moneyRepository.findAll();

        List<Money> newMonies = new ArrayList<>();
        List<Money> updatedMonies = new ArrayList<>();

        for (Money money : monies) {
            Optional<Money> existingMoney = existingMonies.stream()
                    .filter(m -> m.getId().equals(money.getId()))
                    .findFirst();

            if (existingMoney.isPresent()) {
                Money existing = existingMoney.get();
                if (!existing.equals(money)) {
                    existing.setName(money.getName());
                    existing.setSymbol(money.getSymbol());
                    updatedMonies.add(existing);
                }
            } else {
                newMonies.add(money);
            }
        }

        moneyRepository.saveAll(newMonies);
        moneyRepository.saveAll(updatedMonies);
    }


    @Override
    public void saveMoney(Money money) {
        if (!Objects.isNull(money)) {
            moneyRepository.save(money);
        } else {
            log.error("Failed to save money, object is null");
            throw new NullPointerException();
        }
    }

    @Override
    public List<Money> getAll() {
        return moneyRepository.findAll();
    }

    @Override
    public Optional<Money> getMoneyById(Long id) {
        if (!Objects.isNull(id)) {
            return moneyRepository.findById(id);
        } else {
            log.error("Failed to get money by id, id is null");
            throw new NullPointerException();
        }
    }

    @Override
    public Optional<Money> getMoneyByName(String name) {
        if (!Objects.isNull(name)) {
            return Optional.ofNullable(moneyRepository.findMoneyByName(name));
        } else {
            log.error("Failed to get money by name, name is null");
            throw new NullPointerException();
        }
    }
}
