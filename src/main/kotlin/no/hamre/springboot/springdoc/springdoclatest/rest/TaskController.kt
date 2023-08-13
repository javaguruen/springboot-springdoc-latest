package no.hamre.springboot.springdoc.springdoclatest.rest

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(path = ["/todo/v1/task"], produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
class TaskController {
    private val LOG = LoggerFactory.getLogger(TaskController::class.java)

    @PostMapping(path = ["/"])
    fun create(@RequestBody  task: Task): ResponseEntity<Task>{
        val id = kotlin.random.Random.nextLong()
        LOG.info("Task assigned id: $id : $task")
        return ResponseEntity.created(URI.create("http://localhost:8080/todo/v1/task/$id"))
            .body(task.copy(id = id ))
    }
}
