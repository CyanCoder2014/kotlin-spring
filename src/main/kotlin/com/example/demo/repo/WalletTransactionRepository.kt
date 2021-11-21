package com.example.demo.repo

import com.example.demo.entity.WalletTransaction
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository


@Repository
interface WalletTransactionRepository: PagingAndSortingRepository<WalletTransaction, Long> {


}