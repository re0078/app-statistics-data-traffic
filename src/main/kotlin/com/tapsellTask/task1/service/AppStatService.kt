package com.tapsellTask.task1.service

import com.tapsellTask.task1.model.AppStatModel
import com.tapsellTask.task1.model.AppStatRequest
import com.tapsellTask.task1.repository.AppStatRepo
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class AppStatService(val appStatRepo: AppStatRepo,
                     val dateConverter: DateConverter,
                     val appStatDataAggregator: AppStatDataAggregator) {

    private val logger = LoggerFactory.getLogger(javaClass.simpleName)

    @Cacheable(value = ["redis"], key = "{#req.startDate, #req.endDate, #req.type}") // uses SpEL language and parsing methods
    fun getStatistics(req: AppStatRequest): List<AppStatModel> {
        val type = req.type

        dateConverter.toNormal(req.startDate)
        dateConverter.toNormal(req.endDate)


        return appStatDataAggregator.aggregate(
                appStatRepo.findByTypeAndReportTimeBetweenOrderByReportTime(type, req.startDate, req.endDate))
    }

    fun getAll(): List<AppStatModel> {
        logger.info("Returning all available app stat data from database")
        return appStatDataAggregator.aggregate(appStatRepo.findAll())
    }
}
