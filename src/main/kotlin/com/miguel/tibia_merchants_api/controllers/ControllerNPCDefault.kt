package com.miguel.tibia_merchants_api.controllers
import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.data.repositories.NPCRepositoryImp
import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseNPC
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerNPCDefault: KoinComponent {
    private val logger: Logger = LogManager.getLogger(ControllerNPCDefault::class.java)
    private val npcepositoryImp = NPCRepositoryImp(Tibia())
    private val useCaseNPC: UseCaseNPC by inject()
    @GetMapping("api/v1/npcs/{name}")
    fun npcsDefault(@PathVariable name: String): Any?{
        return try {
            logger.info("init petition")
            val npc = useCaseNPC.npc(name)
            if (npc != null){
                val response = Response(200, npc)
                logger.info("Response final: ${response.statusCode}")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "NPC is not exits")
                logger.error("Error: $error")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }
}