package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.AnimalCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    Animal findByAnimaltype(String type);

    @Query(value = "SELECT a.animaltype, COUNT(*) as count FROM animal a JOIN zooanimals za ON a.animalid = za.animalid GROUP BY a.animaltype", nativeQuery = true)
    List<AnimalCount> getAnimalCounts();
}
