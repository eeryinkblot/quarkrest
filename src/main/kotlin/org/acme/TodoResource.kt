package org.acme

import io.smallrye.common.annotation.Blocking
import kotlinx.coroutines.delay
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

    @GET
    @Blocking
    @Path("{index}/blocking")
    fun getTodoBlocking(@RestPath index: Int): TodoDto {
        Thread.sleep(2000)
        return todoService.getAt(index)
    }

    @GET
    @Path("{index}/suspend")
    suspend fun getTodoSuspend(@RestPath index: Int): TodoDto {
        delay(2000)
        return todoService.getAt(index)
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

data class TodoDto(val description: String)