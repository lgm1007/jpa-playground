package com.example.jpaplayground.experiment.controller;

import com.example.jpaplayground.experiment.service.ExperimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExperimentApi {
	private final ExperimentService experimentService;

	@GetMapping("/q1/{id}")
	public ResponseEntity requestQuestion1(@PathVariable Long id) {
		experimentService.question1(id);
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/q2/{id}")
	public ResponseEntity requestQuestion2(@PathVariable Long id) {
		experimentService.question2(id);
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/q3/{id}")
	public ResponseEntity requestQuestion3(@PathVariable Long id) {
		experimentService.question3(id);
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/q4")
	public ResponseEntity requestQuestion4() {
		experimentService.question4();
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/q5")
	public ResponseEntity requestQuestion5() {
		experimentService.question5();
		return ResponseEntity.ok("ok");
	}
}
