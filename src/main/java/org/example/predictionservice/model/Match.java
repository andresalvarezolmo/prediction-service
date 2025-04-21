package org.example.predictionservice.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "match")
public class Match {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String sport;
  private Instant startTime;
  private String homeTeam;
  private String awayTeam;
  private String resultWinner;

  public Match() {
  }

  public Match(Long id, String sport, Instant startTime, String homeTeam, String awayTeam, String resultWinner) {
    this.id = id;
    this.sport = sport;
    this.startTime = startTime;
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.resultWinner = resultWinner;
  }

  public Long getId() {
    return id;
  }

  public String getSport() {
    return sport;
  }

  public Instant getStartTime() {
    return startTime;
  }

  public String getHomeTeam() {
    return homeTeam;
  }

  public String getAwayTeam() {
    return awayTeam;
  }

  public String getResultWinner() {
    return resultWinner;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setSport(String sport) {
    this.sport = sport;
  }

  public void setStartTime(Instant startTime) {
    this.startTime = startTime;
  }

  public void setHomeTeam(String homeTeam) {
    this.homeTeam = homeTeam;
  }

  public void setAwayTeam(String awayTeam) {
    this.awayTeam = awayTeam;
  }

  public void setResultWinner(String resultWinner) {
    this.resultWinner = resultWinner;
  }
}
