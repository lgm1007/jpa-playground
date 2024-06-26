package com.example.jpaplayground.experiment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.function.Supplier;

@Getter
@Table(name = "Experiment")
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Experiment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long insertField;

	@Setter
	private Long updateField;

	public static Supplier<Experiment> from(final Long id) {
		return () -> Experiment.builder()
			.id(id)
			.build();
	}
}
