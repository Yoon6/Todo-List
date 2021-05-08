package com.example.todo1.service;

import com.example.todo1.model.Element;
import com.example.todo1.repository.JpaElementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ElementService {


    private final JpaElementRepository jpaElementRepository;


    public ElementService(JpaElementRepository jpaElementRepository) {
        this.jpaElementRepository = jpaElementRepository;
    }

    public Long save(Element element){
        jpaElementRepository.save(element);
        return element.getId();
    }

    public List<Element> findAll() {
        return jpaElementRepository.findAll();
    }

}
