package org.example.predictionservice.dto;

import jakarta.validation.constraints.NotNull;

public class CreatePredictionRequest {
  @NotNull
  private Long userId;
  @NotNull
  private Long matchId;
  @NotNull
  private String predictedWinner;
  public Long getUserId() { return userId; }
  public void setUserId(Long userId) { this.userId = userId; }
  public Long getMatchId() { return matchId; }
  public void setMatchId(Long matchId) { this.matchId = matchId; }
  public String getPredictedWinner() { return predictedWinner; }
  public void setPredictedWinner(String predictedWinner) {
    this.predictedWinner = predictedWinner;
  }
}
