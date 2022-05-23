package ru.job4j.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.Rule;
import ru.job4j.repository.RuleRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class RuleService {

    private final RuleRepository store;

    public RuleService(RuleRepository store) {
        this.store = store;
    }

    public Collection<Rule> findAll() {
        return store.findAll();
    }

    public Rule findById(int id) {
        return store.findById(id);
    }

    public Set<Rule> createWithRules(String[] ids) {
        if (ids == null) {
            ids = new String[]{"1"};
        }
        Set<Rule> rules = new HashSet<>();
        for (String ruleId : ids) {
            rules.add(findById(Integer.parseInt(ruleId)));
        }
        return rules;
    }

}
