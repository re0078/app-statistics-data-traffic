package com.tapsellTask.task1.repository

import com.tapsellTask.task1.entity.AppStat
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.domain.Pageable
import java.util.*

interface AppStatRepo : MongoRepository<AppStat, String> {

    @Query("{'type': type, 'reportTime':{\$gt: startDate, \$lt: endDate}")
    fun matchType(startDate: Date, endDate: Date, type: Int): List<AppStat>


    fun findAllByType(type: Int, pageable: Pageable): List<AppStat>
}
