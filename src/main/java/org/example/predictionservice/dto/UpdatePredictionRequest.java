package org.example.predictionservice.dto;

import jakarta.validation.constraints.NotNull;

public class UpdatePredictionRequest {
  @NotNull
  private Long predictionId;
  @NotNull(message = "predictedWinner must not be null")
  private String predictedWinner;

  public UpdatePredictionRequest() {}

  public UpdatePredictionRequest(String predictedWinner) {
    this.predictedWinner = predictedWinner;
  }

  public String getPredictedWinner() {
    return predictedWinner;
  }

  public void setPredictedWinner(String predictedWinner) {
    this.predictedWinner = predictedWinner;
  }

  public Long getPredictionId() {
    return predictionId;
  }

  public void setPredictionId(Long predictionId) {
    this.predictionId = predictionId;
  }

}
