package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.AccidentType;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentTypeMemStore {

    private final Map<Integer, AccidentType> types = new ConcurrentHashMap<>();
    private final AtomicInteger ids = new AtomicInteger(4);

    public AccidentTypeMemStore() {
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
    }

    public Collection<AccidentType> findAll() {
        return types.values();
    }

    public AccidentType findById(int id) {
        return types.get(id);
    }
}
