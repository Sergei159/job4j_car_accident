package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Rule;
import ru.job4j.repository.RuleMemStore;

import java.util.Collection;
import java.util.Set;

@Service
public class RuleService {

    private final RuleMemStore store;

    public RuleService(RuleMemStore store) {
        this.store = store;
    }
    public Collection<Rule> findAll() {
        return store.findAll();
    }

    public Rule findById(int id) {
        return store.findById(id);
    }

    public Set<Rule> createWithRules(String[] ids) {
        return store.createWithRules(ids);
    }
}
