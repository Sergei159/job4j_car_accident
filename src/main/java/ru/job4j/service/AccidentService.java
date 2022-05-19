package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentJdbcStore;
import ru.job4j.repository.AccidentMemStore;

import java.util.Collection;

@Service
public class AccidentService {

    private final AccidentJdbcStore store;


    public AccidentService(AccidentJdbcStore store) {
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
