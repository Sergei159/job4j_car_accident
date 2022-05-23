package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentRepository;

import java.util.Collection;

@Service
public class AccidentService {

    private final AccidentRepository store;


    public AccidentService(AccidentRepository store) {
        this.store = store;
    }


    public Collection<Accident> findAll() {
        return store.findAll();
    }


    public void add(Accident accident) {
        store.save(accident);
    }


    public Accident findById(int id) {
        return  store.findById(id);
    }


    public void update(Accident accident) {
         store.save(accident);
    }


    public void delete(int id) {
        store.deleteById(id);
    }
}
