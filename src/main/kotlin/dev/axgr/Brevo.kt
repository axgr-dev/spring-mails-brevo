package dev.axgr

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class Brevo(private val client: RestClient, private val props: BrevoProperties) {

  companion object {
    private val log = LoggerFactory.getLogger(Brevo::class.java)
  }

  fun send(template: BrevoTemplate, vararg receivers: String) {
    if (props.enabled) {
      submit(template, *receivers)
    } else {
      log(template, *receivers)
    }
  }

  private fun submit(template: BrevoTemplate, vararg receivers: String) {
    client.post()
      .body(BrevoRequest(template, receivers.toList()))
      .retrieve()
      .toBodilessEntity()
  }

  private fun log(template: BrevoTemplate, vararg receivers: String) {
    log.info("Sending template {} to {}", template.template(), receivers.joinToString(", "))
  }
}
