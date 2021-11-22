package com.example.demo.repo

import com.example.demo.config.Constants
import com.example.demo.entity.WalletTransaction
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.text.SimpleDateFormat
import java.util.*

@SpringBootTest
internal class WalletTransactionRepositoryTest (@Autowired private val walletTransactionRepository: WalletTransactionRepository){


    fun String.toDate(dateFormat: String = Constants.DATE_FORMAT_VAL, timeZone: TimeZone = TimeZone.getTimeZone("GMT")): Date {
        val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
        parser.timeZone = timeZone
        return parser.parse(this)
    }


    @Test
    fun `When getTransactionsHistory then return collection of WalletTransaction`() {
        val walletTransaction = WalletTransaction(100, "qwe0qwe0q09we",
            "seller_name","2021-11-19T01:00:00.00+08:00".toDate(Constants.DATE_FORMAT_VAL,  TimeZone.getTimeZone("GMT")),222.9)

        assertThat(walletTransaction).isNotNull

        walletTransactionRepository.save(walletTransaction)
        assertNotNull(walletTransactionRepository.findById(100))

        val walletTransactions = walletTransactionRepository.getTransactionsHistory("2000-11-19T01:00:00.00+08:00".toDate(Constants.DATE_FORMAT_VAL,  TimeZone.getTimeZone("GMT")),
            "2050-11-19T01:00:00.00+08:00".toDate(Constants.DATE_FORMAT_VAL,  TimeZone.getTimeZone("GMT")))

        assertThat(walletTransactions.size).isGreaterThanOrEqualTo(1)


    }


}
