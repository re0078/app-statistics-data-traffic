package com.tapsellTask.task1.Model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class AppStatistics {
    @Id
    val id: String = ""
    val reportTime: Date = Date(0)
    val type: Int = 0
    val videoRequests: Int = 0
    val webViewRequest: Int = 0
    val videoClicks: Int = 0
    val videoInstalls: Int = 0
    val webViewInstalls: Int = 0


}