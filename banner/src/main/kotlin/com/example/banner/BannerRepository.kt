package com.example.banner

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID


interface BannerRepository: CoroutineCrudRepository<Banner,UUID>{
    //TODO
}