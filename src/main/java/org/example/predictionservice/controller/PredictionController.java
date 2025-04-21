package org.example.predictionservice.controller;

import org.example.predictionservice.dto.CreatePredictionRequest;
import org.example.predictionservice.dto.PredictionResponse;
import org.example.predictionservice.dto.UpdatePredictionRequest;
import org.example.predictionservice.service.PredictionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/predictions")
public class PredictionController {

  private final PredictionService predictionService;

  public PredictionController(PredictionService predictionService) {
    this.predictionService = predictionService;
  }

  @PostMapping
  public ResponseEntity<PredictionResponse> create(
      @Valid @RequestBody CreatePredictionRequest req
  ) {
    PredictionResponse created = predictionService.create(req);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(created.getId())
        .toUri();
    return ResponseEntity.created(location).body(created);
  }

  @GetMapping
  public ResponseEntity<List<PredictionResponse>> listByUser(
      @RequestParam("userId") Long userId
  ) {
    List<PredictionResponse> list = predictionService.getByUserId(userId);
    return ResponseEntity.ok(list);
  }

  @PatchMapping
  public ResponseEntity<PredictionResponse> updateWinner(
      @Valid @RequestBody UpdatePredictionRequest req
  ) {
    PredictionResponse updated = predictionService.updateWinner(
        req.getPredictionId(),
        req.getPredictedWinner()
    );
    return ResponseEntity.ok(updated);
  }
}
