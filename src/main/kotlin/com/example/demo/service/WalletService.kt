package com.example.demo.service

import com.example.demo.entity.WalletTransaction
import com.example.demo.repo.WalletTransactionRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
@Transactional
class WalletService(private val walletTransactionRepo: WalletTransactionRepository) {


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

    fun addTransaction(transaction: WalletTransaction):WalletTransaction{
        return walletTransactionRepo.save(transaction)
    }

}