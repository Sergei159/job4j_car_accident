package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.repository.AccidentMemStore;

import java.util.Collection;

@Service
public class AccidentService {

    private final AccidentMemStore store;


    public AccidentService(AccidentMemStore store) {
        this.store = store;
    }

    public <T> Collection findAll() {
        return store.findAll();
    }
}
