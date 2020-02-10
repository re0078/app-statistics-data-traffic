package com.tapsellTask.task1.controller

import com.tapsellTask.task1.entity.AppStat
import com.tapsellTask.task1.model.AppStatListResponse
import com.tapsellTask.task1.model.AppStatModel
import com.tapsellTask.task1.model.AppStatRequest
import com.tapsellTask.task1.repository.AppStatRepo
import com.tapsellTask.task1.service.AppStatService
import org.apache.commons.logging.LogFactory
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class AppStatisticController(
        // repo should not be in controllers
        val repo: AppStatRepo,
        val appStatService: AppStatService
) {

    // we usually use slf4j logger
    private final val log: org.apache.commons.logging.Log = LogFactory.getLog("Task1Application")
    private val logger = LoggerFactory.getLogger(javaClass.simpleName)

    // rest endpoints should not contain verbs (the http method is enough)
    @GetMapping("/get-stat")
    @ResponseBody
    fun getStatistics(@RequestBody appStatReq: AppStatRequest): AppStatListResponse {

        // response model already returned from called method
        log.info("Request received for address : /get-stat")
        log.info("AppStat requested type : ${appStatReq.type}   from ${appStatReq.startDate} to ${appStatReq.endDate}")

        return appStatService.getStatistics(appStatReq.startDate, appStatReq.endDate, appStatReq.type)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): Optional<AppStat> {
        return repo.findById(id)
    }


    @GetMapping("get-all")
    fun getAll(): List<AppStat> {
        return repo.findAll()
    }
}