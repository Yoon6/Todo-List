package com.example.todo1.repository;

import com.example.todo1.model.Element;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaElementRepositoryTest {

    @Autowired JpaElementRepository jpaElementRepository;

    @Test
    void save() {
        Element element = new Element();
        element.setContent("This is content!");

        jpaElementRepository.save(element);

//        System.out.println(element);

        Element result = jpaElementRepository.findById(element.getId()).get();

        Assertions.assertThat(element).isEqualTo(result);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        List<Element> result = jpaElementRepository.findAll();

        System.out.println(result);

    }
}