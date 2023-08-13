package no.hamre.springboot.springdoc.springdoclatest.rest
import java.time.LocalDate

data class Task(
    val id: Long?,
    val description: String,
    val completed: Boolean = false,
    val dueDate: LocalDate? = null
)
