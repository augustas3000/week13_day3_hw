package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public ResponseEntity findWhiskeysByYearOrByDistilleryNameAndAgeQueryString(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "distilleryName", required = false) String distilleryName,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        if (year != null) {
//            if query string provided in the format /whiskies?year=2000, then we will use
//            whiskyRepository which inherits from Jpa repo, and hence is data access object(DAO), to
//            access our db and query it using findByYear(int year) method query to return List<Whisky>
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }

        if (distilleryName != null && age != null) {
//            if query  string provided in the format /whiskies?distilleryName=Glendronach&age=12, then we will
//            use whiskyRepository which inherits from Jpa repo, and hence is data access object (DAO), to access
//            our db and query it using findByDistilleryNameAndAge(String distilleryName, int age) method query.
            return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(distilleryName, age), HttpStatus.OK);
        }

//        if query string in not provided, then action standard GET INDEX route.
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distillery")
    public ResponseEntity findWhiskeysByRegionQueryString(
        @RequestParam(name = "region") String region
    ) {
//        if (region != null) {
////            if query string provided in teh format /whiskies/distillery?region=Highland, then we will
////            use whiskyRepository which inherits from Jpa repo, and hence is a data access object(DAO), to
////            access our db and query it using findByDistilleryRegion(String region) method query.
//
//        }
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
    }

}
