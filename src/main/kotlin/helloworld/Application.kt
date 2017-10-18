
package helloworld;

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import java.io.*
import com.fasterxml.jackson.module.kotlin.*

data class HandlerInput(val who: String)
data class HandlerOutput(val message: String)

class Application : RequestStreamHandler  {
    override fun handleRequest(input: InputStream?, output: OutputStream?, context: Context?) {
        val inputObj = mapper.readValue<HandlerInput>(input!!)
        mapper.writeValue(output, HandlerOutput("Hello ${inputObj.who}"))
    }

    val mapper = jacksonObjectMapper()

}

