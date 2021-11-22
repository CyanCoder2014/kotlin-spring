package com.example.demo.repo

import com.example.demo.entity.WalletTransaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.*


@Repository
interface WalletTransactionRepository: JpaRepository<WalletTransaction, Long> {

    @Modifying
    @Query("select a from wallet_transactions a " +
            "where a.datetime >= :startDate and a.datetime <= :endDate")
    fun getTransactionsHistory(@Param("startDate") startDate: Date,
                               @Param("endDate") endDate: Date): Collection<WalletTransaction>


    @Query(
        value = "SELECT sum(ac.amount) as sum, function('date_format', max(ac.datetime), '%Y, %m, %d %h') as date FROM wallet_transactions  ac " +
                "WHERE ac.datetime BETWEEN :startDate AND :endDate GROUP BY function('date_format', ac.datetime, '%Y, %m, %d %h')"
    )
    fun getTransactionsHistorySum(
        @Param("startDate") startDate: Date?,
        @Param("endDate") endDate: Date?
    ): List<Map<String,Object>>
}