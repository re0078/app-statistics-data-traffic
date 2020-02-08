package com.tapsellTask.task1.repository

import com.tapsellTask.task1.Model.AppStatistics
import org.springframework.data.mongodb.repository.MongoRepository

interface AppStatisticsRepo : MongoRepository<AppStatistics, String> {

    fun findByType(type: Int): List<AppStatistics>
}
