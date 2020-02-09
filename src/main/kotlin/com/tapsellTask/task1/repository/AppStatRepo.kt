package com.tapsellTask.task1.repository

import com.tapsellTask.task1.entity.AppStat
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.util.*

interface AppStatRepo : MongoRepository<AppStat, String> {

    @Query("{'type': ?0}")
    fun matchType(startDate: Date, endDate: Date, type: Int): List<AppStat>
}
