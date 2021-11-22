package com.example.demo.rest

import com.example.demo.entity.WalletTransaction
import com.example.demo.service.WalletService
import org.springframework.beans.factory.annotation.Value
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/client")
class ClientController(private val walletService: WalletService) {



    @PostMapping("/submitTransaction")
    fun getHistoryByHourSum(@RequestBody walletTransaction: WalletTransaction): WalletTransaction
            = walletService.addTransaction(walletTransaction)



}