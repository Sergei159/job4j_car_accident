package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RuleMemStore {

    private final Map<Integer, Rule> rules = new HashMap<>();
    private final AtomicInteger ids = new AtomicInteger(4);

    public RuleMemStore() {
        rules.put(1, Rule.of(1, "Статья. 1"));
        rules.put(2, Rule.of(2, "Статья. 2"));
        rules.put(3, Rule.of(3, "Статья. 3"));
    }

    public Collection<Rule> findAll() {
        return rules.values();
    }

    public Rule findById(int id) {
        return rules.get(id);
    }

    public Set<Rule> createWithRules(String[] ids) {
        Set<Rule> rules = new HashSet<>();
        for (String ruleId : ids) {
            rules.add(findById(Integer.parseInt(ruleId)));
        }
        return rules;
    }
}
