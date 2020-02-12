package com.tapsellTask.task1.repository

import com.tapsellTask.task1.entity.AppStat
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface AppStatRepo : MongoRepository<AppStat, String> {

    fun findByTypeAndReportTimeBetweenOrderByReportTime
            (tech: Int, startDate: Date, endDate: Date): List<AppStat>

}
