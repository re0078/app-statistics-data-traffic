package com.tapsellTask.task1.service

import org.springframework.stereotype.Service
import java.util.*


@Service
class DateConverter {

    private val skew: Long = Date("01/05/2000").time - Date("10/15/1378").time

    fun toNormal(persianDate: Date) {
        persianDate.time += skew
    }

    fun toSolar(normalDate: Date) {
        normalDate.time -= skew
    }

}