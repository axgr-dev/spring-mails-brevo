package dev.axgr

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BrevoTests {

  @Autowired
  private lateinit var brevo: Brevo

  @Test
  fun `sending succeeds`() {
    brevo.send(OnboardingTemplate("Alex", "https://axgr.dev"), "hello@axgr.dev")
  }

}
