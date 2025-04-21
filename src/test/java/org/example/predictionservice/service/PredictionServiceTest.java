package org.example.predictionservice.service;

import org.example.predictionservice.repository.MatchRepository;
import org.example.predictionservice.repository.PredictionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class PredictionServiceTest {

  @Mock
  private MatchRepository matchRepo;

  @Mock
  private PredictionRepository predRepo;

  @InjectMocks
  private PredictionService service;

  @Test
  void create_whenMatchExistsAndInFuture_succeeds() {
    // Given a Match with startTime in the future
    // And CreatePredictionRequest with valid predictedWinner
    // When service.create(req)
    // Then verify predRepo.save(...) called and returned DTO has correct fields
  }

  @Test
  void create_whenMatchNotFound_throwsResourceNotFound() {
    // Given matchRepo.findById(...) returns empty
    // When service.create(req)
    // Then assert ResourceNotFoundException is thrown
  }

  @Test
  void create_whenMatchInPast_throwsIllegalState() {
    // Given a Match with startTime in the past
    // When service.create(req)
    // Then assert IllegalStateException is thrown
  }

  @Test
  void create_withInvalidPredictedWinner_throwsIllegalArgument() {
    // Given a future Match but predictedWinner not equal home or away
    // When service.create(req)
    // Then assert IllegalArgumentException is thrown
  }

  @Test
  void getByUserId_returnsAllPredictionsForThatUser() {
    // Given predRepo.findByUserId(1) returns 3 entities
    // When service.getByUserId(1)
    // Then result list size is 3
  }

  @Test
  void updateWinner_whenPredictionExistsAndMatchInFuture_succeeds() {
    // Given a Prediction whose match startTime is in the future
    // When service.updateWinner(id, winner)
    // Then verify predRepo.save(...) called and returned DTO has updated winner
  }

  @Test
  void updateWinner_whenPredictionNotFound_throwsResourceNotFound() {
    // Given predRepo.findById(...) returns empty
    // When service.updateWinner(...)
    // Then assert ResourceNotFoundException is thrown
  }

  @Test
  void updateWinner_whenMatchStarted_throwsIllegalState() {
    // Given a Prediction whose match startTime is in the past
    // When service.updateWinner(...)
    // Then assert IllegalStateException is thrown
  }
}
