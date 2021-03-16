package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kennel {
    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        dogs.forEach(Dog::feed);
//        for(Dog dog : dogs) {
//            dog.feed();
//        }
    }

    public Dog findByName(String name) {
        for(Dog dog : dogs) {
            if(dog.getName().equals(name)) {
                return dog;
            }
        }
        throw new IllegalArgumentException("No dog with this name!");
    }

    public void playWith(String name,int hours) {
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        //return dogs.stream().filter(d -> d.getHappiness() > minHappiness).map(Dog::getName).collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        for(Dog dog : dogs) {
            if(dog.getHappiness() > minHappiness) {
                result.add(dog.getName());
            }
        }
        return result;
    }

    public List<Dog> getDogs() {
        return dogs;
    }
}
