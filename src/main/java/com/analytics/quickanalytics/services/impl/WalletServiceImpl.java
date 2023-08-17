package com.analytics.quickanalytics.services.impl;

import com.analytics.quickanalytics.entities.Wallet;
import com.analytics.quickanalytics.repositories.WalletRepository;
import com.analytics.quickanalytics.services.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    @Override
    public void saveWalletsInformation(List<Wallet> wallets) {
        walletRepository.saveAll(wallets);
    }
}
