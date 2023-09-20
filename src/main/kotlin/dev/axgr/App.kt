package dev.axgr

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class App {

  @Bean
  fun run(brevo: Brevo) = CommandLineRunner {
    brevo.send(OnboardingTemplate("Alex", "https://axgr.dev"), "hello@axgr.dev")
  }

}

fun main(args: Array<String>) {
  runApplication<App>(*args)
}
