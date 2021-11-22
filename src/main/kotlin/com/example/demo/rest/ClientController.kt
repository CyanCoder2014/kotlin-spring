package com.example.demo.rest

import com.example.demo.entity.WalletTransaction
import com.example.demo.service.WalletService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class ClientController(private val walletService: WalletService) {



    @PostMapping("/submitTransaction")
    fun getHistoryByHourSum(@RequestBody walletTransaction: WalletTransaction): WalletTransaction
            = walletService.addTransaction(walletTransaction)



}