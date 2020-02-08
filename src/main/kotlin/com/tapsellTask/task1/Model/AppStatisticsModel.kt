package com.tapsellTask.task1.Model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


class AppStatisticsModel(
        val weekNum: Int,
        val year: Int,
        val requests: Int,
        val clicks: Int,
        val installs: Int)