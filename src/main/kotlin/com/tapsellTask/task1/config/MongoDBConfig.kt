package com.tapsellTask.task1.config

import com.tapsellTask.task1.Model.AppStatistics
import com.tapsellTask.task1.repository.AppStatisticsRepo
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.nio.file.Files
import java.nio.file.Paths
import java.text.SimpleDateFormat

@EnableMongoRepositories(basePackageClasses = [AppStatisticsRepo::class])
@Configuration
class MongoDBConfig(private val repo: AppStatisticsRepo) {

    private final val log: Log = LogFactory.getLog("Task1Application")


    @Bean
    fun config(): MongoDemo {
        val pathToCSV = "/home/re/Downloads/task1/appStat.csv"
        CSVInjector(pathToCSV, repo).inject()
        log.info("primary data injected to appStatisticsRepository")
        return MongoDemoImpl()
    }
}


class CSVInjector(csvPath: String, val repo: AppStatisticsRepo) {

    private var parser: CSVParser? = null

    init {
        val reader = Files.newBufferedReader(Paths.get(csvPath))
        CSVParser(reader, CSVFormat.DEFAULT)
    }

    fun inject() {
        for (csvRecord in parser!!.requireNoNulls()) {
            val appStat = AppStatistics(csvRecord[0],
                    SimpleDateFormat("dd/MM/yyyy").parse(csvRecord[1]),
                    csvRecord[2].toInt(),
                    csvRecord[3].toInt(),
                    csvRecord[4].toInt(),
                    csvRecord[5].toInt(),
                    csvRecord[6].toInt(),
                    csvRecord[7].toInt())
            repo.save(appStat)
        }
    }
}

//Todo : can enter and use inserted data in requested queries but can not access these data on main mongodb and mongodb compass as well.


//        repo.save(AppStatistics("miket", Date(), 1, 100, 1000, 50, 20, 100))
//        repo.save(AppStatistics("balad", Date(), 3, 88, 390, 50, 20, 390))
//        repo.save(AppStatistics("quiz of kings", Date(), 5, 150, 700, 120, 11, 65))
//        repo.save(AppStatistics("cafe bazar", Date(), 1, 100, 1000, 50, 20, 100))
//        repo.save(AppStatistics("aftabe", Date(), 3, 88, 390, 50, 20, 390))
//        repo.save(AppStatistics("neshan", Date(), 5, 150, 700, 120, 11, 65))


interface MongoDemo {
    val serviceName: String?
}

class MongoDemoImpl : MongoDemo {
    override val serviceName: String?
        get() = "My first service with Spring 3"
}