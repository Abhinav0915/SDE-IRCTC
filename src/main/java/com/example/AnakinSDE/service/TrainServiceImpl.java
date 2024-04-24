package com.example.AnakinSDE.service;

import com.example.AnakinSDE.dto.TrainSearchRequest;
import com.example.AnakinSDE.entity.Train;
import com.example.AnakinSDE.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService{
    @Autowired
    private TrainRepository trainRepository;

    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }



    @Override
    public List<Train> findTrainsBetweenStations(TrainSearchRequest searchRequest) {
        return trainRepository.findBySourceAndDestination(
                searchRequest.getSource(),
                searchRequest.getDestination()
        );
    }
}
