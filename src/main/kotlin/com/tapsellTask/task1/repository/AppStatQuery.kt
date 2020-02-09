package com.tapsellTask.task1.repository

import com.tapsellTask.task1.entity.AppStat
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.util.*

@Component
class AppStatQuery(private val mongoTemplate: MongoTemplate) {

    fun matchType(startDate: Date, endDate: Date, type: Int): List<AppStat> {
        val query = Query()
        query.addCriteria(Criteria.where("reportTime").gte(startDate).lte(endDate).and("type").`is`(type))
        return mongoTemplate.find(query, AppStat::class.java)
    }
}