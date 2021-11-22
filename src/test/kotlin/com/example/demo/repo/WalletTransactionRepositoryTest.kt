package com.example.demo.repo

import com.example.demo.entity.WalletTransaction
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@SpringBootTest
internal class WalletTransactionRepositoryTest (@Autowired private val walletTransactionRepository: WalletTransactionRepository){


    fun String.toDate(dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timeZone: TimeZone = TimeZone.getTimeZone("GMT")): Date {
        val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
        parser.timeZone = timeZone
        return parser.parse(this)
    }


    @Test
    fun `When getTransactionsHistory then return collection of WalletTransaction`() {
        val walletTransaction = WalletTransaction(1000, "qwe0qwe0q09we",
            "seller_name","2021-11-19T01:00:00.00+08:00".toDate("yyyy-MM-dd'T'HH:mm:ss.SSSXXX",  TimeZone.getTimeZone("GMT")),222.9)

        assertThat(walletTransaction).isNotNull

        walletTransactionRepository.save(walletTransaction)
        assertNotNull(walletTransactionRepository.findById(1000))

        val walletTransactions = walletTransactionRepository.getTransactionsHistory("2021-11-19T01:00:00.00+08:00".toDate("yyyy-MM-dd'T'HH:mm:ss.SSSXXX",  TimeZone.getTimeZone("GMT")),
            "2021-11-19T01:00:00.00+08:00".toDate("yyyy-MM-dd'T'HH:mm:ss.SSSXXX",  TimeZone.getTimeZone("GMT")))

        assertThat(walletTransactions.size).isGreaterThanOrEqualTo(1)


    }


}
