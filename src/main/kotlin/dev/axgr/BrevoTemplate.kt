package dev.axgr

interface BrevoTemplate {

  fun template(): Int

  fun params(): Map<String, Any>
}

data class OnboardingTemplate(val username: String, val link: String) : BrevoTemplate {

  override fun template(): Int = 3

  override fun params(): Map<String, Any> {
    return mapOf("username" to username, "link" to link)
  }
}
