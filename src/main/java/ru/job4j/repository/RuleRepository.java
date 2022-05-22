package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;

@Repository
public interface RuleRepository
        extends CrudRepository<Rule, Integer> {
}
