package ru.job4j.repository;

import net.jcip.annotations.ThreadSafe;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import ru.job4j.model.Rule;

import java.util.Collection;
import java.util.List;

@ThreadSafe
@Repository
public class AccidentHbmStore implements HbmStore {

    private final SessionFactory sf;

    public AccidentHbmStore(SessionFactory sf) {
        this.sf = sf;
    }


    public void add(Accident accident, String[] rIds) {
        if (rIds == null) {
            rIds = new String[]{"1"};
        }
        String[] finalRIds = rIds;
        transaction(session -> {
            for (String id : finalRIds) {
                accident.addRule(session.find(Rule.class, Integer.parseInt(id)));
            }
            session.persist(accident);
            return accident;
        }, sf);
    }


    public List<Accident> findAll() {
        return transaction((session -> {
            final Query query = session.createQuery("select a from Accident a "
                    + "join fetch a.type t "
                    + "join fetch a.rules", Accident.class
            );
            return query.getResultList();
        }), sf);
    }

    public Object findById(int id) {
        return transaction((session -> {
            final Query query = session.createQuery("select a from Accident a "
                    + "join fetch  a.type t "
                    + "join fetch  a.rules "
                    + "where a.id = :a_id", Accident.class
            );
            query.setParameter("a_id", id);
            return query.uniqueResult();
        }), sf);
    }

    public void update(Accident accident, String[] rIds) {
        transaction(session -> {
            for (String id : rIds) {
                accident.addRule(session.find(Rule.class, Integer.parseInt(id)));
            }
            session.update(accident);
            return accident;
        }, sf);
    }

    public void delete(int id) {
        Accident accident = new Accident();
        accident.setId(id);
        transaction(session -> {
            session.delete(accident);
            return new Object();
        }, sf);
    }


}
