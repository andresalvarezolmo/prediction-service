package org.example.predictionservice.service;

import org.example.predictionservice.dto.CreatePredictionRequest;
import org.example.predictionservice.dto.PredictionResponse;
import org.example.predictionservice.exception.ResourceNotFoundException;
import org.example.predictionservice.model.Match;
import org.example.predictionservice.model.Prediction;
import org.example.predictionservice.repository.MatchRepository;
import org.example.predictionservice.repository.PredictionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PredictionService {
  private final PredictionRepository predRepo;
  private final MatchRepository matchRepo;

  public PredictionService(PredictionRepository predRepo, MatchRepository matchRepo) {
    this.predRepo = predRepo;
    this.matchRepo = matchRepo;
  }

  @Transactional
  public PredictionResponse create(CreatePredictionRequest req) {
    Match match = matchRepo.findById(req.getMatchId())
        .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    if (match.getStartTime().isBefore(Instant.now())) {
      throw new IllegalStateException("Match already started");
    }
    isPredictedWinnerValid(req, match);
    Prediction prediction = new Prediction();
    prediction.setUserId(req.getUserId());
    prediction.setMatch(match);
    prediction.setPredictedWinner(req.getPredictedWinner());
    predRepo.save(prediction);
    return toDto(prediction);
  }

  public List<PredictionResponse> getByUserId(Long userId) {
    return predRepo.findByUserId(userId).stream()
        .map(this::toDto)
        .collect(Collectors.toList());
  }

  @Transactional
  public PredictionResponse updateWinner(Long predictionId, String winner) {
    Prediction prediction = predRepo.findById(predictionId)
        .orElseThrow(() -> new ResourceNotFoundException("Prediction not found"));
    if (prediction.getMatch().getStartTime().isBefore(Instant.now())) {
      throw new IllegalStateException("Cannot update after start");
    }
    prediction.setPredictedWinner(winner);
    predRepo.save(prediction);
    return toDto(prediction);
  }

  private static void isPredictedWinnerValid(CreatePredictionRequest req, Match match) {
    String predicted = req.getPredictedWinner();
    boolean validHome  = predicted.equalsIgnoreCase(match.getHomeTeam());
    boolean validAway  = predicted.equalsIgnoreCase(match.getAwayTeam());
    if (!validHome && !validAway) {
      throw new IllegalArgumentException(
          "predictedWinner must be either '" +
              match.getHomeTeam() + "' or '" + match.getAwayTeam() + "'");
    }
  }

  private PredictionResponse toDto(Prediction prediction) {
    return new PredictionResponse(
        prediction.getId(),
        prediction.getUserId(),
        prediction.getMatch().getId(),
        prediction.getPredictedWinner(),
        prediction.getCreatedAt(),
        prediction.getUpdatedAt()
    );
  }
}
