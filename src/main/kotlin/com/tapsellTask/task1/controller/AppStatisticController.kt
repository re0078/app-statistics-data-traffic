package com.tapsellTask.task1.controller

import com.tapsellTask.task1.Model.AppStatistics
import com.tapsellTask.task1.Model.RequestModel
import com.tapsellTask.task1.repository.AppStatisticsRepo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
class AppStatisticController(val repo: AppStatisticsRepo) {

    @RequestMapping("/", method = [RequestMethod.GET])
    @ResponseBody
    fun getStatistics(@RequestBody req: RequestModel) {


    }

    @GetMapping("get/{id}")
    @ResponseBody
    fun getById(@PathVariable id: String): Optional<AppStatistics> {
        return repo.findById(id)
    }


    @GetMapping("get-all")
    @ResponseBody
    fun getAll(): List<AppStatistics> {
        return repo.findAll()
    }

    @GetMapping("get/type/{type}")
    @ResponseBody
    fun getByType(@PathVariable type: Int): List<AppStatistics> {
        return repo.findByType(type)
    }

}