package com.example.demo.service

import com.example.demo.entity.WalletTransaction
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import java.text.SimpleDateFormat
import java.util.*

@SpringBootTest
internal class WalletServiceTest(@Autowired private val walletService: WalletService){

    fun String.toDate(dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timeZone: TimeZone = TimeZone.getTimeZone("GMT")): Date {
        val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
        parser.timeZone = timeZone
        return parser.parse(this)
    }


    @BeforeEach
    fun `Add transactions`() {

        val walletTransaction = WalletTransaction(1000, "qwe0qwe0q09we",
            "seller_name","2021-11-19T01:00:00.00+08:00".toDate("yyyy-MM-dd'T'HH:mm:ss.SSSXXX",  TimeZone.getTimeZone("GMT")),222.9)

        assertThat(walletTransaction).isNotNull

        walletService.addTransaction(walletTransaction)
        assertNotNull(walletService.findTransactionById(walletTransaction.id))

    }

    @Test
    fun `history of wallet transactions return a list`() {

       val walletTransactions = walletService.getHistory("2021-11-19T01:00:00.00+08:00".toDate("yyyy-MM-dd'T'HH:mm:ss.SSSXXX",  TimeZone.getTimeZone("GMT")),
            "2021-11-19T01:00:00.00+08:00".toDate("yyyy-MM-dd'T'HH:mm:ss.SSSXXX",  TimeZone.getTimeZone("GMT")))

        assertThat(walletTransactions.size).isGreaterThanOrEqualTo(1)

    }


    @Test
    fun `Sum of wallet transactions return a list that group_by hour`() {


        val walletTransactions = walletService.getHistorySum("2021-11-19T01:00:00.00+08:00".toDate("yyyy-MM-dd'T'HH:mm:ss.SSSXXX",  TimeZone.getTimeZone("GMT")),
            "2021-11-19T01:00:00.00+08:00".toDate("yyyy-MM-dd'T'HH:mm:ss.SSSXXX",  TimeZone.getTimeZone("GMT")))

        assertThat(walletTransactions.size).isGreaterThanOrEqualTo(1)

        assertThat(walletTransactions[0]).isNotEmpty
    }


}