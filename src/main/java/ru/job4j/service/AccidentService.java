package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentHbmStore;

import java.util.Collection;

@Service
public class AccidentService {

    private final AccidentHbmStore store;


    public AccidentService(AccidentHbmStore store) {
        this.store = store;
    }

    public Collection<Accident> findAll() {
        return store.findAll();
    }

    public void add(Accident accident) {
        store.add(accident);
    }

    public Accident findById(int id) {
        return (Accident) store.findById(id);
    }

    public void update(Accident accident) {
         store.update(accident);
    }

    public void delete(int id) {
        store.delete(id);
    }
}
