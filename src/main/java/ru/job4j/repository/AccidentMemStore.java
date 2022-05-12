package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMemStore implements Store {

    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private final AtomicInteger ids = new AtomicInteger(0);

    public AccidentMemStore() {
    }

    @Override
    public Collection<Accident> findAll() {
        return accidents.values();
    }


    @Override
    public void add(Accident accident) {
        accident.setId(ids.incrementAndGet());
        accidents.put(ids.get(), accident);

    }

    @Override
    public Accident findById(int id) {
        return accidents.get(id);
    }
}
