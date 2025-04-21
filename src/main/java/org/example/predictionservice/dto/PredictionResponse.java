package org.example.predictionservice.dto;

import java.time.Instant;

public class PredictionResponse {
  private Long id;
  private Long userId;
  private Long matchId;
  private String predictedWinner;
  private Instant createdAt;
  private Instant updatedAt;

  public PredictionResponse(Long id, Long userId, Long matchId,
                            String predictedWinner,
                            Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.userId = userId;
    this.matchId = matchId;
    this.predictedWinner = predictedWinner;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getId() { return id; }
  public Long getUserId() { return userId; }
  public Long getMatchId() { return matchId; }
  public String getPredictedWinner() { return predictedWinner; }
  public Instant getCreatedAt() { return createdAt; }
  public Instant getUpdatedAt() { return updatedAt; }
}
