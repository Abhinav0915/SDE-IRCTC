package com.example.AnakinSDE.controller;

import com.example.AnakinSDE.entity.Train;
import com.example.AnakinSDE.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<String> addTrain(@RequestBody Train train) {
        Train savedTrain = trainService.addTrain(train);
        String message = "Train added between " + savedTrain.getSource() + " and " + savedTrain.getDestination();
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }



}