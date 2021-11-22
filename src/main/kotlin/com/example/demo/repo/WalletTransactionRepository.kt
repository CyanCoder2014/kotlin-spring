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
            "where a.datetime > :startDate and a.datetime <= :endDate")
    fun getTransactionsHistory(@Param("startDate") startDate: Date,
                               @Param("endDate") endDate: Date): Collection<WalletTransaction>


    @Query(
        value = "select sum(wt.amount) as sum, function('date_format', max(wt.datetime), '%Y-%m-%d %h:00') as date from wallet_transactions  wt " +
                "where wt.datetime > :startDate and wt.datetime <= :endDate group by function('date_format', wt.datetime, '%Y-%m-%d %h:00')"
    )
    fun getTransactionsHistorySum(
        @Param("startDate") startDate: Date?,
        @Param("endDate") endDate: Date?
    ): List<Map<String,Object>>
}