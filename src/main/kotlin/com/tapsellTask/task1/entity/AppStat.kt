package com.tapsellTask.task1.entity

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId
import java.util.*

@Document
class AppStat(@MongoId val id: String,
              val reportTime: Date,
              val type: Int,
              val videoRequests: Int,
              val webViewRequest: Int,
              val videoClicks: Int,
              val videoInstalls: Int,
              val webViewInstalls: Int
) {

}