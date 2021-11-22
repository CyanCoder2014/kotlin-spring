package com.example.demo.rest

import com.example.demo.repo.WalletHistoryModel
import com.example.demo.service.WalletService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/report")
class ReportController(private val walletService: WalletService) {



    @GetMapping("/getHistoryWalletAmount")
    fun getHistoryWalletAmount(@RequestParam
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) startDateTime: Date,
                         @RequestParam
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) endDateTime: Date): Collection<WalletHistoryModel>
            = walletService.getHistoryPerHour(startDateTime, endDateTime)



}