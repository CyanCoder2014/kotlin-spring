package com.example.demo.rest

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class WalletControllerTest{

    @Autowired
    lateinit var mock: MockMvc

    @Test
    fun `Get must return transaction successfully in json`() {

        mock.get("/wallet/getAllTransactions")
            .andExpect { status { isOk() }
                         content { contentType(MediaType.APPLICATION_JSON) }}

    }



}