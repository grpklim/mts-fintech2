package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;
import ru.mtsbank.config.StarterProperties;

import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    protected AnimalType type;

    private StarterProperties starterProperties;

    public CreateAnimalServiceImpl(StarterProperties properties) {
        starterProperties = properties;
    }

    private AnimalFactory animalFactory = new AnimalFactory();

    public Animal create() {
        String[] names = null;
        switch (type) {
            case CAT -> names = starterProperties.getCatNames();
            case DOG -> names = starterProperties.getDogNames();
            case SHARK -> names = starterProperties.getSharkNames();
            case WOLF -> names = starterProperties.getWolfNames();
        }
        return animalFactory.createAnimal(type, names[new Random().nextInt(names.length)], new Random().nextInt(10));
    }
}