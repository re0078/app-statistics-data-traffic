package com.tapsellTask.task1.controller

import com.tapsellTask.task1.model.TestRequest
import com.tapsellTask.task1.model.TestResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class TestController {


    @GetMapping("test-response")
    fun testResponse(): TestResponse {
        val type = TestResponse("hi there", 64, Date(45), arrayOf(2, 3, 34, 4, 4, 41))
        return type
    }

    @GetMapping("test-request")
    fun testRequest(@RequestBody test: TestRequest): String {
        println(test)
        return "data received"
    }
}