package ru.job4j.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public interface RuleRepository extends CrudRepository<Rule, Integer> {

    @Override
    List<Rule> findAll();

    Rule findById(int id);
}