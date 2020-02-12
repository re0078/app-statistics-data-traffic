package com.tapsellTask.task1.service

import com.tapsellTask.task1.entity.AppStat
import com.tapsellTask.task1.model.AppStatListResponse
import com.tapsellTask.task1.model.AppStatModel
import org.springframework.stereotype.Service
import java.util.*

val WEEK_DURATION = Date("10/17/2000").time - Date("10/10/2000").time

@Service
class AppStatResponseGenerator(val dateConverter: DateConverter) {

    fun generate(appStats: List<AppStat>): AppStatListResponse {
        return AppStatListResponse(
                appStats.map {
                    dateConverter.toSolar(it.reportTime)
                    it
                }.groupBy {
                    val year = it.reportTime.year + 1900
                    Pair(((it.reportTime.time - Date("01/01/$year").time) / WEEK_DURATION).toInt(), year)
                }.map
                {
                    AppStatModel(weekNum = it.key.first % 53,
                            year = it.key.second,
                            requests = it.value.sumBy { app -> app.videoRequests + app.webViewRequest },
                            clicks = it.value.sumBy { app -> app.videoClicks },
                            installs = it.value.sumBy { app -> app.videoInstalls + app.webViewInstalls }
                    )
                }.toList()
        )
    }
}
