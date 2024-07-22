package com.harry.tradingapp.service;

import com.harry.tradingapp.model.Order;
import com.harry.tradingapp.model.User;
import com.harry.tradingapp.model.Wallet;

public interface WalletService {

    Wallet getUserWallet (User user);
    Wallet addBalance(Wallet wallet, Long amount);
    Wallet findWalletById(Long id) throws Exception;
    Wallet walletToWalletTransfer (User sender, Wallet toWallet, Long amount) throws Exception ;
    Wallet payOrderWallet(Order order, User user);
}
