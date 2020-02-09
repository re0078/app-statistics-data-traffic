package com.tapsellTask.task1.model

import java.util.*


class TestRequest(val date: Date, val num: Int) {
    @Override
    override fun toString(): String {
        return "date = $date\t num = $num"
    }
}