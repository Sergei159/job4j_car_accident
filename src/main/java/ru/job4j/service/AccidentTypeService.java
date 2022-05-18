package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.AccidentTypeMemStore;

import java.util.Collection;

@Service
public class AccidentTypeService {

    private final AccidentTypeMemStore store;

    public AccidentTypeService(AccidentTypeMemStore store) {
        this.store = store;
    }

    public Collection<AccidentType> findAll() {
        return store.findAll();
    }

    public AccidentType findById(int id) {
        return store.findById(id);
    }
}
