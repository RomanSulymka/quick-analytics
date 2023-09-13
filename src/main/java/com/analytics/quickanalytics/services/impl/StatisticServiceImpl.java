package com.analytics.quickanalytics.services.impl;

import com.analytics.quickanalytics.repositories.StatisticRepository;
import com.analytics.quickanalytics.services.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {
    private final StatisticRepository statisticRepository;

}
