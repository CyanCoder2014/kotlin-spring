package com.example.demo.service

import com.example.demo.entity.WalletTransaction
import com.example.demo.repo.WalletHistoryModel
import com.example.demo.repo.WalletTransactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class WalletService(private val walletTransactionRepo: WalletTransactionRepository) {


    fun getHistoryPerHour(startDateTime: Date, endDateTime: Date):Collection<WalletHistoryModel>{

        var amountBeforeStartQuery:Double? = walletTransactionRepo.getWalletAmount(startDateTime)
        var amountBeforeStart = 0.00
        if(amountBeforeStartQuery != null)
          amountBeforeStart = amountBeforeStartQuery

        var walletTransactionsPerHour = walletTransactionRepo.getTransactionsHistorySum(startDateTime,endDateTime)

        var walletAmountHourly : MutableList <WalletHistoryModel> = arrayListOf()

        var sumAmount = amountBeforeStart
        walletTransactionsPerHour.forEach { i ->
            sumAmount = sumAmount + i.get("sum").toString()?.toDouble()
            walletAmountHourly.add(WalletHistoryModel( i.get("date").toString(), sumAmount))
        }
        return walletAmountHourly
    }


    fun getHistory(startDateTime: Date, endDateTime: Date):Collection<WalletTransaction>{
        return walletTransactionRepo.getTransactionsHistory(startDateTime,endDateTime)
    }

    fun getHistorySum(startDateTime: Date, endDateTime: Date):List<Map<String,Object>> {
        return walletTransactionRepo.getTransactionsHistorySum(startDateTime,endDateTime)
    }

    fun getAll():Collection<WalletTransaction>{
        return walletTransactionRepo.findAll()
    }


    fun findTransactionById(transactionId: Long):Optional<WalletTransaction>{
        return walletTransactionRepo.findById(transactionId)
    }

    fun addTransaction(transaction: WalletTransaction): WalletTransaction {
        return walletTransactionRepo.save(transaction)
    }


}