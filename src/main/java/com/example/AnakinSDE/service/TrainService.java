package com.example.AnakinSDE.service;

import com.example.AnakinSDE.dto.TrainSearchRequest;
import com.example.AnakinSDE.entity.Train;

import java.util.List;

public interface TrainService {
    List<Train> findTrainsBetweenStations(TrainSearchRequest searchRequest);
}