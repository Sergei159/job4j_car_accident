package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.AccidentTypeRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AccidentTypeService {

    private final AccidentTypeRepository store;

    public AccidentTypeService(AccidentTypeRepository store) {
        this.store = store;
    }

    public Iterable<AccidentType> findAll() {
        return store.findAll();
    }

    public Optional<AccidentType> findById(int id) {
        return store.findById(id);
    }
}
