package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

//    http://localhost:8080/distilleries?region=Speyside

//    same route /distilleries will be used as GET INDEX if no query string provided,
//    or it will be used to query and return data from distilleries table if query string provided

    @GetMapping
    public ResponseEntity findDistilleriesByRegionQueryString(
            @RequestParam(name = "region", required = false) String region
    ) {
        if (region != null) {
//            if query string provided in the format /distilleries?region=Speyside, then we will use
//            distilleryRepository which inherits from Jpa repo, and hence is data access object(DAO), to
//            access our db and query it using findByRegion(String region) method query to return List<Distillery>
            return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }


//        if query string in the format /distilleries?region=Speyside is not provided, then action standard GET INDEX route.
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }


//    currently in /distilleries
    @GetMapping(value = "/whiskies")
    public ResponseEntity findDistilleriesByAgeOfWhisky(
            @RequestParam(name="age") Integer age
    ) {
        return new ResponseEntity<>(distilleryRepository.findByWhiskiesAge(age), HttpStatus.OK );
    }



}
