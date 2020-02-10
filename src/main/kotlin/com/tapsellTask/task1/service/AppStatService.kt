package com.tapsellTask.task1.service

import com.tapsellTask.task1.config.START_DATE
import com.tapsellTask.task1.entity.AppStat
import com.tapsellTask.task1.model.AppStatListResponse
import com.tapsellTask.task1.model.AppStatModel
import com.tapsellTask.task1.repository.AppStatQuery
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.*

@Service
class AppStatService(val appStatQuery: AppStatQuery) {


    @Cacheable(value = ["redis"], key = "{#startDate, #endDate, #type}") // uses SpEL language and parsing method
    fun getStatistics(startDate: Date, endDate: Date, type: Int): AppStatListResponse {
        fun toResponseModel(appStat: AppStat): AppStatModel {
            val milliseconds = appStat.reportTime.time - START_DATE.time
            val year: Int = (milliseconds / 3.154e+10).toInt() + 1395
            val weekNum = (milliseconds / 6.048e+8).toInt() % 53
            val requests = appStat.videoRequests + appStat.webViewRequest
            val installs = appStat.videoInstalls + appStat.webViewInstalls
            val clicks = appStat.videoClicks
            return AppStatModel(weekNum, year, requests, clicks, installs)
        }

        return AppStatListResponse(appStatQuery.matchType(startDate, endDate, type).map { toResponseModel(it) })
    }
}
