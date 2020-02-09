package com.tapsellTask.task1.repository

import com.tapsellTask.task1.model.AppStat
import org.springframework.data.mongodb.repository.MongoRepository

interface AppStatisticsRepo : MongoRepository<AppStat, String> {

    fun findByType(type: Int): List<AppStat>
}
