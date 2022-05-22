package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Rule;
import ru.job4j.repository.RuleRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RuleService {

    private final RuleRepository store;

    public RuleService(RuleRepository store) {
        this.store = store;
    }
    public Iterable<Rule> findAll() {
        return store.findAll();
    }

    public Optional<Rule> findById(int id) {
        return store.findById(id);
    }

    public Set<Rule> createWithRules(String[] ids) {
        if (ids == null) {
            ids = new String[]{"1"};
        }
        Set<Rule> rules = new HashSet<>();
        for (String ruleId : ids) {
            rules.add(findById(Integer.parseInt(ruleId)).get());
        }
        return rules;
    }
}
