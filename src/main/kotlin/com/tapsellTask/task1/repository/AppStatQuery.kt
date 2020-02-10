package com.tapsellTask.task1.repository

import com.tapsellTask.task1.entity.AppStat
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.util.*


@Component
class AppStatQuery(private val mongoTemplate: MongoTemplate) {

    private final val log: org.apache.commons.logging.Log = org.apache.commons.logging.LogFactory.getLog("Task1Application")

    fun matchType(startDate: Date, endDate: Date, type: Int): List<AppStat> {
        val query = Query()
        query.addCriteria(Criteria.where("reportTime").gte(startDate).lte(endDate).and("type").`is`(type))
        query.with(PageRequest.of(0, 10))

        log.info("Performing custom query..")
        return mongoTemplate.find(query, AppStat::class.java)
    }
}