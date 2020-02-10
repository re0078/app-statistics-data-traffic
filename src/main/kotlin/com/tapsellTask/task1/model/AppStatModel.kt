package com.tapsellTask.task1.model

import java.io.Serializable


class AppStatModel(
        val weekNum: Int,
        val year: Int,
        val requests: Int,
        val clicks: Int,
        val installs: Int) : Serializable