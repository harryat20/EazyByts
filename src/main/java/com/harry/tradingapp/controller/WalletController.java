//package com.harry.tradingapp.controller;
//
//import com.harry.tradingapp.model.User;
//import com.harry.tradingapp.model.Wallet;
//import com.harry.tradingapp.service.CustomUserDetailService;
//import com.harry.tradingapp.service.WalletService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/wallet")
//public class WalletController {
//
//    @Autowired
//    private WalletService walletService;
//
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
//    @GetMapping
//    public ResponseEntity<Wallet> getUserWallet(@RequestHeader("email") String email) {
//        User user = customUserDetailService.getCurrentUser(email);
//        Wallet wallet = walletService.getUserWallet(user);
//        return ResponseEntity.ok(wallet);
//    }
//
//    @PostMapping("/addBalance")
//    public ResponseEntity<Wallet> addBalance(@RequestHeader("email") String email, @RequestHeader Long amount) {
//        User user = customUserDetailService.getCurrentUser(email);
//        Wallet wallet = walletService.getUserWallet(user);
//        walletService.addBalance(wallet, amount);
//        return ResponseEntity.ok(wallet);
//    }
//
//    @PostMapping("/walletToWalletTransfer")
//    public ResponseEntity<Wallet> walletToWalletTransfer(@RequestHeader("email") String email, @RequestHeader Long toWalletId, @RequestHeader Long amount) throws Exception {
//        User user = customUserDetailService.getCurrentUser(email);
//        Wallet toWallet = walletService.findWalletById(toWalletId);
//        Wallet wallet = walletService.walletToWalletTransfer(user, toWallet, amount);
//        return ResponseEntity.ok(wallet);
//    }
//}
