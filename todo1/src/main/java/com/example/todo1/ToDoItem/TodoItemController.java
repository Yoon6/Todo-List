package com.example.todo1.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoItemController {

    private final ToDoItemService toDoItemService;

    @Autowired
    public TodoItemController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody
    ToDoItemResponse get(@PathVariable(value = "id") Long id) {
        List<String> errors = new ArrayList<>();
        ToDoItem toDoItem = null;
        try {
            toDoItem = toDoItemService.get(id);
        } catch (final Exception e) {
            errors.add(e.getMessage());
        }
        return ToDoItemAdapter.toToDoItemResponse(toDoItem, errors);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<ToDoItemResponse> getAll() {
        List<String> errors = new ArrayList<>();
        List<ToDoItem> toDoItems = toDoItemService.getAll();
        List<ToDoItemResponse> toDoItemResponses = new ArrayList<>();
        toDoItems.stream().forEach(toDoItem -> {
            toDoItemResponses.add(ToDoItemAdapter.toToDoItemResponse(toDoItem, errors));
        });
        return toDoItemResponses;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ToDoItemResponse create(@RequestBody final ToDoItemRequest toDoItemRequest) {
        List<String> errors = new ArrayList<>();
        ToDoItem toDoItem = ToDoItemAdapter.toToDoItem(toDoItemRequest);
        try {
            toDoItem = toDoItemService.create(toDoItem);
        } catch (final Exception e) {
            errors.add(e.getMessage());
        }
        return ToDoItemAdapter.toToDoItemResponse(toDoItem, errors);
    }
}
