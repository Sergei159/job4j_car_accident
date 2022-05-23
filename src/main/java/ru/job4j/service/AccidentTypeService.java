package ru.job4j.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.AccidentTypeRepository;

import java.util.Collection;

@Service
public class AccidentTypeService {

    private final AccidentTypeRepository store;

    public AccidentTypeService(AccidentTypeRepository store) {
        this.store = store;
    }

    public Collection<AccidentType> findAll() {
        return store.findAll();
    }

    public AccidentType findById(int id) {
        return store.findById(id);
    }
}
