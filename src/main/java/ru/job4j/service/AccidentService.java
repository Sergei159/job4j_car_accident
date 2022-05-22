package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentRepository;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class AccidentService {

    private final AccidentRepository store;


    public AccidentService(AccidentRepository store) {
        this.store = store;
    }

    public Iterable<Accident> findAll() {
        return store.findAll();
    }

    public void add(Accident accident) {
        store.save(accident);
    }

    public Optional<Accident> findById(int id) {
        return store.findById(id);
    }

    public void update(Accident accident) {
         store.save(accident);
    }

    public void delete(Accident accident) {
        store.delete(accident);
    }
}
