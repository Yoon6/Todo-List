package com.example.todo1.ToDoItem;

import com.example.todo1.ApiResponse.ApiResponse;
import lombok.Builder;

import java.util.List;

public class ToDoItemResponse extends ApiResponse<ToDoItem> {

    @Builder
    public ToDoItemResponse(final ToDoItem data, final List<String> errors) {
        super(data);
        this.setErrors(errors);
    }
}
