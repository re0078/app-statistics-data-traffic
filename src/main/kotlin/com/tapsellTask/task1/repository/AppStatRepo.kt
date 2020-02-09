package com.tapsellTask.task1.repository

import com.tapsellTask.task1.model.AppStat
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.util.*

interface AppStatRepo : MongoRepository<AppStat, String> {

    @Query("{type: 2?}")
    fun typeMatch(startDate: Date, endDate: Date, type: Int): List<AppStat>
}
