package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {


//    Get all the whiskies for a particular year
//    What Do I want? List<Whisky>
//    What Do I have? int year
    List<Whisky> findByYear(int year);

//    Get all the whisky from a particular distillery that’s a specific age
//    What Do I Want? List<Whisky>
//    What Do I Have? Str name, int Age
    List<Whisky> findByDistilleryNameAndAge(String distilleryName, int age);

//    Get all the whisky from a particular region
//    What Do I Want? List<Whisky>
//    What Do I have? Str region
    List<Whisky> findByDistilleryRegion(String region);

}
