package ru.job4j.repository;

import net.jcip.annotations.ThreadSafe;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ThreadSafe
@Repository
public class RuleHbmStore implements HbmStore {

    private final SessionFactory sf;

    public RuleHbmStore(SessionFactory sf) {
        this.sf = sf;
    }


    public List<Rule> findAll() {
        return this.transaction(session -> {
            final Query query = session.createQuery("from Rule ");
            return query.getResultList();
        }, sf);
    }

    public Rule findById(int id) {
        return transaction(session -> session.get(Rule.class, id), sf);
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
