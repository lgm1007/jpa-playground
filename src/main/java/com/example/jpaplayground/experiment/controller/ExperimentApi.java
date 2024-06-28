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

	@GetMapping("/q1")
	public ResponseEntity<String> requestQuestion1() {
		experimentService.question1();
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/q2")
	public ResponseEntity<String> requestQuestion2() {
		experimentService.question2();
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/q3")
	public ResponseEntity<String> requestQuestion3() {
		experimentService.question3();
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/q4")
	public ResponseEntity<String> requestQuestion4() {
		experimentService.question4();
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/q5")
	public ResponseEntity<String> requestQuestion5() {
		experimentService.question5();
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/q6")
	public ResponseEntity<String> requestQuestion6() {
		experimentService.question6();
		return ResponseEntity.ok("ok");
	}
}
