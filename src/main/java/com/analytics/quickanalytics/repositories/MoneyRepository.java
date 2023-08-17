package com.analytics.quickanalytics.repositories;

import com.analytics.quickanalytics.entities.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyRepository extends JpaRepository<Money, Long> {
    Money findMoneyByName(String name);
}
