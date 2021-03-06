package ru.job4j.repository;

import ru.job4j.model.Accident;

import java.util.Collection;

import java.util.function.*;

public interface Store {
    public <T> Collection  findAll();

    public void add(Accident accident);

    public Object findById(int id);

    void update(Accident accident);

    void delete(int id);
}
