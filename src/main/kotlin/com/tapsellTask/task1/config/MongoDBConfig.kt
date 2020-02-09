package com.tapsellTask.task1.config

import com.tapsellTask.task1.Model.AppStatistics
import com.tapsellTask.task1.repository.AppStatisticsRepo
//import org.apache.commons.csv.CSVFormat
//import org.apache.commons.csv.CSVParser
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.nio.file.Files
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.*

@EnableMongoRepositories(basePackageClasses = [AppStatisticsRepo::class])
@Configuration
class MongoDBConfig(private val repo: AppStatisticsRepo) {

    private final val log: Log = LogFactory.getLog("Task1Application")


    @Bean
    fun config(): CommandLineRunner {

        repo.save(AppStatistics("miket", Date(), 1, 100, 1000, 50, 20, 100))
        repo.save(AppStatistics("balad", Date(), 3, 88, 390, 50, 20, 390))
        repo.save(AppStatistics("quiz of kings", Date(), 5, 150, 700, 120, 11, 65))
        repo.save(AppStatistics("cafe bazar", Date(), 1, 100, 1000, 50, 20, 100))
        repo.save(AppStatistics("aftabe", Date(), 3, 88, 390, 50, 20, 390))
        repo.save(AppStatistics("neshan", Date(), 5, 150, 700, 120, 11, 65))
        return CommandLineRunner {
            @Override
            fun run() {

            }
        }
    }
}


//Todo : can enter and use inserted data in requested queries but can not access these data on main mongodb and mongodb compass as well.
