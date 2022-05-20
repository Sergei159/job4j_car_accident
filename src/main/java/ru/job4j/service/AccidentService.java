package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.model.Rule;
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

    public void add(Accident accident, String[] rIds) {
        store.add(accident, rIds);
    }

    public Accident findById(int id) {
        return (Accident) store.findById(id);
    }

    public void update(Accident accident, String[] rIds) {
         store.update(accident, rIds);
    }

    public void delete(int id) {
        store.delete(id);
    }


}
