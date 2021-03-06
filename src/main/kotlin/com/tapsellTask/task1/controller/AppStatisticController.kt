package com.tapsellTask.task1.controller

import com.tapsellTask.task1.entity.AppStat
import com.tapsellTask.task1.model.AppStatListResponse
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

    @GetMapping("/get-stat")
    @ResponseBody
    fun getStatistics(@RequestBody appStatReq: AppStatRequest): AppStatListResponse {

        // response model already returned from called method
        log.info("Request received for address : /get-stat")
        log.info("AppStat requested type : ${appStatReq.type}   from ${appStatReq.startDate} to ${appStatReq.endDate}")

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
}