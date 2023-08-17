package com.analytics.quickanalytics.services;

import com.analytics.quickanalytics.entities.Money;

import java.util.List;
import java.util.Optional;

public interface MoneyService {
    void saveAllMoney(List<Money> monies);
    void saveMoney(Money money);
    List<Money> getAll();
    Optional<Money> getMoneyById(Long id);
    Optional<Money> getMoneyByName(String name);
}
