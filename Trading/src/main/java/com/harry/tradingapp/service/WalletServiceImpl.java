package com.harry.tradingapp.service;

import com.harry.tradingapp.model.Order;
import com.harry.tradingapp.model.User;
import com.harry.tradingapp.model.Wallet;
import com.harry.tradingapp.repo.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet getUserWallet(User user) {
        Wallet wallet = walletRepository.findByUserId(user.getId());
        if (wallet == null) {
            wallet = new Wallet();
            wallet.setUser(user);
            wallet.setBalance(BigDecimal.ZERO);
            walletRepository.save(wallet);
        }
        return wallet;
    }

    @Override
    public Wallet addBalance(Wallet wallet, Long amount) {
        BigDecimal oldBalance = wallet.getBalance();
        BigDecimal newBalance = oldBalance.add(BigDecimal.valueOf(amount));
        wallet.setBalance(newBalance);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findWalletById(Long id) throws Exception {
        Optional<Wallet> wallet = walletRepository.findById(id);
        if (wallet.isPresent()) {
            return wallet.get();
        }
        throw new Exception("Wallet not found");
    }

    @Override
    public Wallet walletToWalletTransfer(User sender, Wallet toWallet, Long amount) throws Exception {
        Wallet senderWallet = getUserWallet(sender);
        if (senderWallet.getBalance().compareTo(BigDecimal.valueOf(amount)) < 0) {
            throw new Exception("Insufficient balance");
        }

        BigDecimal senderBalance = senderWallet.getBalance().subtract(BigDecimal.valueOf(amount));
        senderWallet.setBalance(senderBalance);
        walletRepository.save(senderWallet);

        BigDecimal receiverBalance = toWallet.getBalance().add(BigDecimal.valueOf(amount));
        toWallet.setBalance(receiverBalance);
        walletRepository.save(toWallet);

        return senderWallet;
    }

    @Override
    public Wallet payOrderWallet(Order order, User user) {
        // Implementation for payOrderWallet
        return null;
    }
}
