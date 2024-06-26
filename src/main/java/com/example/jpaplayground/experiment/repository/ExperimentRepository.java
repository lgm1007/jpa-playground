package com.example.jpaplayground.experiment.repository;

import com.example.jpaplayground.experiment.entity.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ExperimentRepository extends JpaRepository<Experiment, Long> {
	Optional<Experiment> findByInsertField(Long insertField);

	@Query("select e from Experiment e where e.updateField = :updateField")
	Optional<Experiment> findByUpdateField(Long updateField);
}
