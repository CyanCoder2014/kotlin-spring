package com.example.demo.rest

import com.example.demo.entity.WalletTransaction
import com.example.demo.service.WalletService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/wallet")
class WalletController(private val walletService: WalletService) {



    @GetMapping("/getHistoryByHour")
    fun getHistoryByHour(@RequestParam
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) startDateTime: Date,
                         @RequestParam
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) endDateTime: Date): Collection<WalletTransaction>
                        = walletService.getHistory(startDateTime, endDateTime)


    @GetMapping("/getHistoryByHourSum")
    fun getHistoryByHourSum(@RequestParam
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) startDateTime: Date,
                         @RequestParam
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) endDateTime: Date): List<Map<String,Object>>
            = walletService.getHistorySum(startDateTime, endDateTime)



    @GetMapping("/getAllTransactions")
    fun getAllTransactions(): Collection<WalletTransaction>
                        = walletService.getAll()



}