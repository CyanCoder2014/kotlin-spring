package com.example.demo.entity

import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*

@Entity(name = "wallet_transactions")
data class WalletTransaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val transaction_code: String,
    val sender_info: String,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    val datetime: Date,
    val amount: Double
)