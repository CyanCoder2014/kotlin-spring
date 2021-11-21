package com.example.demo.repo

import com.example.demo.entity.WalletTransaction
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class WalletTransactionRepositoryTest (@Autowired private val walletTransactionRepository: WalletTransactionRepository){

    @Test
    fun `When getTransactionsHistory then return collection of WalletTransaction`() {
        val walletTransaction = WalletTransaction(1000, "qwe0qwe0q09we",
            "seller_name","2021-11-19 22:28:19",222.9)

        assertThat(walletTransaction).isNotNull

        walletTransactionRepository.save(walletTransaction)
        assertNotNull(walletTransactionRepository.findById(1000))

    }


}
