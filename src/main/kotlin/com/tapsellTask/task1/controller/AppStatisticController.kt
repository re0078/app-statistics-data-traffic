package com.tapsellTask.task1.controller

import com.tapsellTask.task1.model.AppStatListResponse
import com.tapsellTask.task1.model.AppStatRequest
import com.tapsellTask.task1.service.AppStatService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

//import org.slf4j.ILoggerFactory

@RestController
@RequestMapping("/stat")
class AppStatisticController(val appStatService: AppStatService) {

    // we usually use slf4j logger
    private val logger = LoggerFactory.getLogger(javaClass.simpleName)

    @GetMapping("/")
    @ResponseBody
    fun getStatistics(@RequestBody appStatReq: AppStatRequest?): AppStatListResponse {

        logger.info("Request received for address : /stat")
        logger.info("AppStat requested type : ${appStatReq?.type}   from ${appStatReq?.startDate} to ${appStatReq?.endDate}")

        return if (appStatReq != null) appStatService.getStatistics(appStatReq) else appStatService.getAll()
    }
}