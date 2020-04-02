package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    //    Get all the distilleries for a particular region
    //    What Do I want? List<Distillery>
    //    What Do I have? String region

    List<Distillery> findByRegion(String region);


    //    Get distilleries that have whiskies that are 12 years old
    //    What Do I want? List<Distillery>
    //    What Do I have? int age


    List<Distillery> findByWhiskiesAge(int age);

}
