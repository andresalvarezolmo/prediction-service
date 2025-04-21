package org.example.predictionservice.controller;

import org.example.predictionservice.service.PredictionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PredictionController.class)
public class PredictionControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private PredictionService predictionService;

  @Test
  void create_withValidRequest_returns201AndLocationHeader() {
    // Given a CreatePredictionRequest with userId, matchId, predictedWinner
    // When we POST /api/v1/predictions
    // Then expect 201 Created, Location header ends with the new ID, and JSON body has that ID
  }

  @Test
  void create_withMissingPredictedWinner_returns400() {
    // Given a CreatePredictionRequest missing predictedWinner
    // When we POST /api/v1/predictions
    // Then expect 400 Bad Request with error message about predictedWinner
  }

  @Test
  void create_withInvalidPredictedWinner_returns400() {
    // Given a CreatePredictionRequest with a predictedWinner that is not playing the match
    // When we POST /api/v1/predictions
    // Then expect 400 Bad Request with error message about predictedWinner not being valid
  }

  @Test
  void listByUser_withExistingUser_returns200AndList() {
    // Given PredictionService.getByUserId(1) returns two items
    // When we GET /api/v1/predictions?userId=1
    // Then expect 200 OK and JSON array of size 2
  }

  @Test
  void updateWinner_withValidRequest_returns200AndUpdatedBody() {
    // Given UpdatePredictionRequest with predictionId and new winner
    // When we PATCH /api/v1/predictions
    // Then expect 200 OK and JSON body with updated predictedWinner
  }

  @Test
  void updateWinner_withNonexistentId_returns404() {
    // Given PredictionService.updateWinner throws ResourceNotFoundException
    // When we PATCH /api/v1/predictions
    // Then expect 404 Not Found
  }
}
