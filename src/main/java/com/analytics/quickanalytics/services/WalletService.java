package com.analytics.quickanalytics.services;

import com.analytics.quickanalytics.entities.Wallet;

import java.util.List;

public interface WalletService {
    void saveWalletsInformation(List<Wallet> wallets);
}
