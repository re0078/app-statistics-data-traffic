package com.tapsellTask.task1.service

import com.tapsellTask.task1.config.START_DATE
import com.tapsellTask.task1.entity.AppStat
import com.tapsellTask.task1.model.AppStatModel
import com.tapsellTask.task1.repository.AppStatQuery
import org.springframework.stereotype.Service
import java.util.*


@Service
class AppStatService(val appStatQuery: AppStatQuery) {

    fun getStatistics(startDate: Date, endDate: Date, type: Int): List<AppStatModel> {

        fun toResponseModel(appStat: AppStat): AppStatModel {
            val milliseconds = appStat.reportTime.time - START_DATE.time
            val year: Int = (milliseconds / 3.154e+10).toInt() + 1970
            val weekNum = (milliseconds / 6.048e+8).toInt()
            val requests = appStat.videoRequests + appStat.webViewRequest
            val installs = appStat.videoInstalls + appStat.webViewInstalls
            val clicks = appStat.videoClicks
            return AppStatModel(weekNum, year, requests, clicks, installs)
        }

        return appStatQuery.matchType(startDate, endDate, type).map { toResponseModel(it) }
    }
}
