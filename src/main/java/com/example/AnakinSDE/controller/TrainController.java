package com.example.AnakinSDE.controller;

import com.example.AnakinSDE.dto.TrainSearchRequest;
import com.example.AnakinSDE.entity.Train;
import com.example.AnakinSDE.service.TrainService;
import com.example.AnakinSDE.service.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainServiceImpl trainServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<String> addTrain(@RequestBody Train train) {
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