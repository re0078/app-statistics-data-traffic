package com.tapsellTask.task1.controller

import com.tapsellTask.task1.model.AppStat
import com.tapsellTask.task1.model.AppStatRequest
import com.tapsellTask.task1.repository.AppStatisticsRepo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
class AppStatisticController(val repo: AppStatisticsRepo) {

    @RequestMapping("/", method = [RequestMethod.GET])
    @ResponseBody
    fun getStatistics(@RequestBody req: AppStatRequest) {

    }

    @GetMapping("get/{id}")
    @ResponseBody
    fun getById(@PathVariable id: String): Optional<AppStat> {
        return repo.findById(id)
    }


    @GetMapping("get-all")
    @ResponseBody
    fun getAll(): List<AppStat> {
        return repo.findAll()
    }

    @GetMapping("get/type/{type}")
    @ResponseBody
    fun getByType(@PathVariable type: Int): List<AppStat> {
        return repo.findByType(type)
    }

}