package org.example.predictionservice.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "prediction")
public class Prediction {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long userId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "match_id")
  private Match match;

  private String predictedWinner;
  private Instant createdAt;
  private Instant updatedAt;

  public Prediction() {
  }

  public Prediction(Long id, Long userId, Match match, String predictedWinner, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.userId = userId;
    this.match = match;
    this.predictedWinner = predictedWinner;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @PrePersist
  public void onCreate() {
    createdAt = updatedAt = Instant.now();
  }

  @PreUpdate
  public void onUpdate() {
    updatedAt = Instant.now();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Match getMatch() {
    return match;
  }

  public void setMatch(Match match) {
    this.match = match;
  }

  public String getPredictedWinner() {
    return predictedWinner;
  }

  public void setPredictedWinner(String predictedWinner) {
    this.predictedWinner = predictedWinner;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }
}
