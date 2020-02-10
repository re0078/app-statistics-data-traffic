package com.tapsellTask.task1.config

// todo learn com.fasterxml.jackson.databind.ObjectMapper
import com.tapsellTask.task1.entity.AppStat
import com.tapsellTask.task1.repository.AppStatRepo
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.util.*


val START_DATE: Date = Date(-18144518400000) // as 1395 AD


@EnableMongoRepositories(basePackageClasses = [AppStatRepo::class])
@Configuration
class MongoDBConfig(val repo: AppStatRepo) {

    @Bean
    fun config(): CommandLineRunner {

        repo.save(AppStat("miket", Date(132132889132), 3, 100, 1000, 50, 20, 100))
        repo.save(AppStat("balad", Date(6546464465), 3, 88, 390, 50, 20, 390))
        repo.save(AppStat("quiz of kings", Date(879794646), 5, 150, 700, 120, 11, 65))
        repo.save(AppStat("cafe bazar", Date(8644768768), 3, 133, 1000, 50, 20, 100))
        repo.save(AppStat("aftabe", Date(), 3, 88, 390, 50, 20, 390))
        repo.save(AppStat("neshan", Date(), 3, 150, 700, 120, 11, 65))
        return CommandLineRunner {}
    }
}
