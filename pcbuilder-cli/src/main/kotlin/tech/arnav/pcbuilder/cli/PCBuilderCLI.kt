package tech.arnav.pcbuilder.cli

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class PCBuilderCLI {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(PCBuilderCLI::class.java, *args)
        }
    }
}