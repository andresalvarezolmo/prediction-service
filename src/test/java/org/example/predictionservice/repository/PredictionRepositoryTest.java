package org.example.predictionservice.repository;

import org.junit.jupiter.api.Test;

public class PredictionRepositoryTest {

  private PredictionRepository repo;

  @Test
  void findByUserId_returnsOnlyThatUsersPredictions() {
    // Given three saved Prediction entities:
    //   two with userId=42, one with userId=7
    // When repo.findByUserId(42)
    // Then returned list size is 2 and all elements have userId==42
  }
}
