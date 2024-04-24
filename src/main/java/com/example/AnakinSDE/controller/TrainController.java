package com.example.AnakinSDE.controller;

import com.example.AnakinSDE.dto.TrainSearchRequest;
import com.example.AnakinSDE.entity.Train;
import com.example.AnakinSDE.service.TrainService;
import com.example.AnakinSDE.service.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private static final String ADMIN_API_KEY = "4fg8v4df8g4d8g7dg4df8hg47dfg";

    @Autowired
    private TrainServiceImpl trainServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<String> addTrain(@RequestHeader("API-Key") String apiKey, @RequestBody Train train) {
        if (!apiKey.equals(ADMIN_API_KEY)) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        Train savedTrain = trainServiceImpl.addTrain(train);
        String message = "Train added between " + savedTrain.getSource() + " and " + savedTrain.getDestination();
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PostMapping("/between")
    public ResponseEntity<List<Train>> getTrainsBetweenStations(
            @RequestBody TrainSearchRequest searchRequest) {
        List<Train> trains = trainServiceImpl.findTrainsBetweenStations(searchRequest);
        return ResponseEntity.ok(trains);
    }




}