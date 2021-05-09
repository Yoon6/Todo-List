package com.example.todo1.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;

    @Autowired
    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public ToDoItem get(final Long id) {
        return toDoItemRepository.findById(id).orElse(null);
    }

    public ToDoItem create(final ToDoItem toDoItem) {
        if (toDoItem == null) {
            throw new NullPointerException("To Do Item cannot be null");
        }
        return toDoItemRepository.save(toDoItem);
    }

    public List<ToDoItem> getAll(){
        return toDoItemRepository.findAll();
    }

}
