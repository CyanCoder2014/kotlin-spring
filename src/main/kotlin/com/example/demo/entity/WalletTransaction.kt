package com.example.demo.entity

import java.math.BigInteger

data class WalletTransaction(val id:BigInteger,
                             val transaction_code:String,
                             val sender_info:String,
                             val datetime:String,
                             val amount:Float)
