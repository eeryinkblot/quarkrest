package org.acme

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TodoService {

    private val todos = mutableListOf<TodoDto>()

    fun getAllTodos(): List<TodoDto> {
        return todos
    }

    fun add(todo: TodoDto): TodoDto {
        todos.add(todo)
        return todo
    }

    fun removeAt(index: Int) {
        todos.removeAt(index)
    }

    fun getAt(index: Int): TodoDto {
        return todos[index]
    }

}
