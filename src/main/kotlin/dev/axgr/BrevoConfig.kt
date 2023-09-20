package dev.axgr

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@ConfigurationProperties("brevo")
data class BrevoProperties(val key: String, val url: String, val enabled: Boolean)

@Configuration
@EnableConfigurationProperties(BrevoProperties::class)
class BrevoConfig(private val props: BrevoProperties) {

  @Bean
  fun client(builder: RestClient.Builder): RestClient {
    return builder
      .baseUrl(props.url)
      .defaultHeader("api-key", props.key)
      .build()
  }
}
