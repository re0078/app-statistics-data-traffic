package com.tapsellTask.task1.config

// todo learn com.fasterxml.jackson.databind.ObjectMapper
import com.tapsellTask.task1.entity.AppStat
import com.tapsellTask.task1.repository.AppStatRepo
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.util.*


@EnableMongoRepositories(basePackageClasses = [AppStatRepo::class])
@Configuration
class MongoDBConfig(val repo: AppStatRepo) {

    private final val logger = LoggerFactory.getLogger(javaClass.simpleName)

    @Bean
    fun config(): CommandLineRunner {

        repo.save(AppStat("miket", Date("01/05/2000"), 3, 100, 1000, 50, 20, 100))
        repo.save(AppStat("balad", Date(0 ), 3, 88, 390, 50, 20, 390))
        repo.save(AppStat("quiz of kings", Date(0), 5, 150, 700, 120, 11, 65))
        repo.save(AppStat("cafe bazar", Date(0), 3, 133, 1000, 50, 20, 100))
        repo.save(AppStat("aftabe", Date(), 3, 88, 390, 50, 20, 390))
        repo.save(AppStat("neshan", Date(), 3, 150, 700, 120, 11, 65))

        logger.info("Init app stat data is saved")
        return CommandLineRunner {}
    }
}
