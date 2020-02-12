package com.tapsellTask.task1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import java.util.*

@SpringBootApplication
class Task1Application

fun main(args: Array<String>) {
    runApplication<Task1Application>(*args)
}
