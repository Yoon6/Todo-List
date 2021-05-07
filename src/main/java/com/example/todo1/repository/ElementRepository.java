package com.example.todo1.repository;

import com.example.todo1.model.Element;

import java.util.List;
import java.util.Optional;

public interface ElementRepository {
    Element save(Element element);

    Optional<Element> findById(Long id);

    List<Element> findAll();
}
