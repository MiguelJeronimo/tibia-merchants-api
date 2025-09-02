package mx.org.frd.wnspproteccionreport.utils.validator

import com.fasterxml.jackson.databind.ObjectMapper
import com.miguel.tibia_merchants_api.utils.Constants
import com.miguel.tibia_merchants_api.utils.exceptions.ResourceNotFoundException
import com.networknt.schema.JsonSchemaFactory
import com.networknt.schema.SchemaValidatorsConfig
import com.networknt.schema.SpecVersion
import com.networknt.schema.ValidationMessage
import java.io.InputStream
import java.nio.charset.StandardCharsets

class SchemaValidator(private val routeJson: String) {
    private val objectMapper = ObjectMapper()
    private val config = SchemaValidatorsConfig.builder().errorMessageKeyword("errorMessage").build()
    private val jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7)
    fun validate(body: Any,): MutableSet<ValidationMessage>? {
        val jsonRequest = objectMapper.writeValueAsString(body)
        val schema = jsonSchemaFactory.getSchema(readJson(), config)
        // Convertir el JSON en un JsonNode
        val jsonNode = objectMapper.readTree(jsonRequest)
        // Validar el JSON contra el esquema
        val validationErrors = schema.validate(jsonNode)
        return validationErrors
    }

    private fun readJson(): String {
        val inputStream: InputStream? = javaClass.getResourceAsStream(routeJson)
        if (inputStream != null) {
            return inputStream.bufferedReader(StandardCharsets.UTF_8).use { it.readText() }
        } else {
            throw ResourceNotFoundException("No se encontro el archivo ${Constants.JsonSchemaToken.route}")
        }
    }
}