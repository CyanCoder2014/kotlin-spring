package com.example.demo.rest

import com.example.demo.config.Constants
import com.example.demo.entity.WalletTransaction
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.text.SimpleDateFormat
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class ClientControllerTest{

    @Autowired
    lateinit var mock: MockMvc

    fun String.toDate(dateFormat: String = Constants.DATE_FORMAT_VAL, timeZone: TimeZone = TimeZone.getTimeZone("GMT")): Date {
        val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
        parser.timeZone = timeZone
        return parser.parse(this)
    }

    @Test
    fun `Submit transaction successfully in json`(@Autowired objectMapper:ObjectMapper) {

        val walletTransaction = WalletTransaction(0, "qwe0qwe0q09we",
            "seller_name","2021-11-19T01:00:00.00+08:00".toDate(Constants.DATE_FORMAT_VAL,  TimeZone.getTimeZone("GMT")),222.9)


        mock.post("/client/submitTransaction"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(walletTransaction)
        }
            .andExpect { status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }}
    }
}