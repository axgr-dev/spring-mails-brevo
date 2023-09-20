package dev.axgr

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent

data class BrevoRequest(val template: BrevoTemplate, val receivers: List<String>)

@JsonComponent
class BrevoRequestSerializer : JsonSerializer<BrevoRequest>() {

  override fun serialize(request: BrevoRequest, generator: JsonGenerator, serializers: SerializerProvider) {
    with(generator) {
      writeStartObject()
      writeArrayFieldStart("to")
      request.receivers.forEach { receiver ->
        writeStartObject()
        writeStringField("email", receiver)
        writeEndObject()
      }
      writeEndArray()
      writeNumberField("templateId", request.template.template())
      if (request.template.params().isNotEmpty()) {
        writeObjectFieldStart("params")
        request.template.params().forEach { (param, value) ->
          writeStringField(param, value.toString())
        }
        writeEndObject()
      }
      writeEndObject()
    }
  }
}
