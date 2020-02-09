package com.tapsellTask.task1.service

import com.tapsellTask.task1.model.AppStat
import com.tapsellTask.task1.model.AppStatModel
import com.tapsellTask.task1.repository.AppStatRepo
import org.springframework.stereotype.Service
import java.util.*


@Service
class AppStatService(val repo: AppStatRepo) {

    fun getStatistics(startDate: Date, endDate: Date, type: Int): List<AppStatModel> {
//        fun toResponseModel(appStat: AppStat): AppStatModel {
//            return AppStatModel()
//        }
//
//        val appStats: Unit = repo.typeMatch(startDate, endDate, type).forEach { (app) -> toResponseModel(app)}
        // todo
    }
}