package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentMemStore implements Store {

    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    public AccidentMemStore() {
        accidents.put(1, new Accident(1, "Sergei", "Car crash", "Sovetskaja Street"));
        accidents.put(2, new Accident(2, "Andrei", "car-bicycle crash", "Lenina Street"));
        accidents.put(3, new Accident(3, "Max", "car-human crash", "Lenina Street"));

    }

    @Override
    public Collection<Accident> findAll() {
        return accidents.values();
    }
}
