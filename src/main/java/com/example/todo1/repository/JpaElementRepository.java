package com.example.todo1.repository;

import com.example.todo1.model.Element;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaElementRepository implements ElementRepository {

    private final EntityManager em;

    public JpaElementRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Element save(Element element) {
        em.persist(element);
        return element;
    }

    @Override
    public Optional<Element> findById(Long id) {
        Element element = em.find(Element.class, id);
        return Optional.ofNullable(element);
    }

    @Override
    public List<Element> findAll() {
        return em.createQuery("select m from Element m", Element.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        em.createQuery("delete from Element e where e.id = :id")
                .setParameter("id", id)
                .executeUpdate();

    }
}
