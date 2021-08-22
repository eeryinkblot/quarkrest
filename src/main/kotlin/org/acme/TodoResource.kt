package org.acme

import com.fasterxml.jackson.annotation.JsonProperty
import org.jboss.resteasy.reactive.RestPath
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/todos")
class TodoResource (private val todoService: TodoService) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllTodos() : List<TodoDto> {
        return todoService.getAllTodos()
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("earl")
    fun addTodo(todo: TodoDto): TodoDto {
        return todoService.add(todo)
    }

    @DELETE
    @Path("/{index}")
    fun deleteTodoAt(@RestPath index: Int) {
        todoService.removeAt(index)
    }

}

data class TodoDto(@JsonProperty("description") val description: String)