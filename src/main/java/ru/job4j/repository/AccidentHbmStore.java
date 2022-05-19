package ru.job4j.repository;

import net.jcip.annotations.ThreadSafe;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.List;

@ThreadSafe
@Repository
public class AccidentHbmStore implements HbmStore {

    private final SessionFactory sf;

    public AccidentHbmStore  (SessionFactory sf) {
        this.sf = sf;
    }


    public void add(Accident accident) {
        transaction(session -> session.save(accident), sf);
    }

    public List<Accident> findAll() {
        return transaction(session -> session.createQuery("from Accident").list(),
                sf);
    }

    public Accident findById(int id) {
        return transaction(session -> session.get(Accident.class, id),
                sf);
    }

    public void update(Accident accident) {
        transaction(session -> {
            session.update(accident);
            return new Object();
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
