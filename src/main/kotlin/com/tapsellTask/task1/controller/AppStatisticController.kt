package com.tapsellTask.task1.controller

import com.tapsellTask.task1.entity.AppStat
import com.tapsellTask.task1.model.AppStatModel
import com.tapsellTask.task1.model.AppStatRequest
import com.tapsellTask.task1.repository.AppStatRepo
import com.tapsellTask.task1.service.AppStatService
import org.apache.commons.logging.LogFactory
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class AppStatisticController(val repo: AppStatRepo, val appStatService: AppStatService) {

    private final val log: org.apache.commons.logging.Log = LogFactory.getLog("Task1Application")

    @GetMapping("/")
    fun getStatistics(@RequestBody appStatReq: AppStatRequest): List<AppStatModel> {
        // response model already returned from called method
        log.info("Request received for address : /")
        log.info("AppStat requested ${appStatReq.type} as type and from ${appStatReq.startDate} to ${appStatReq.endDate}")
        return appStatService.getStatistics(appStatReq.startDate, appStatReq.endDate, appStatReq.type)
    }

    @GetMapping("get/{id}")
    fun getById(@PathVariable id: String): Optional<AppStat> {
        return repo.findById(id)
    }


    @GetMapping("get-all")
    fun getAll(): List<AppStat> {
        return repo.findAll()
    }

    @GetMapping("test-response")
    fun testResponse(): AppStatRequest {
        val type = TestResponse("hi there", 64, Date(45), arrayOf(2, 3, 34, 4, 4, 41))
        val type2 = AppStatRequest(Date(0), Date(0), 3)
        return type2
    }

    @GetMapping("test-request")
    fun testRequest(@RequestBody test: TestRequest): String {
        println(test)
        return "data received"
    }

}


class TestResponse(val str: String, val num: Int, val date: Date, val array: Array<Int>)

class TestRequest(val date: Date, val num: Int) {
    @Override
    override fun toString(): String {
        return "date = $date\t num = $num"
    }
}