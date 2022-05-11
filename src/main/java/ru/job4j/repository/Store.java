package ru.job4j.repository;

import java.util.Collection;

import java.util.function.*;

public interface Store {
    public <T> Collection  findAll();
}
