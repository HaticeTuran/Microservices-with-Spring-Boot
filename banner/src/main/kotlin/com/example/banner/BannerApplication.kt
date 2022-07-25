package com.example.banner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BannerApplication

fun main(args: Array<String>) {
    runApplication<BannerApplication>(*args)
}
