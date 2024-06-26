package com.example.jpaplayground.experiment.service;

import com.example.jpaplayground.experiment.entity.Experiment;
import com.example.jpaplayground.experiment.repository.ExperimentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExperimentService {
	private ExperimentRepository experimentRepository;

	// ***** Q1. Start *****
	@Transactional
	public void question1(final Long experimentId) {
		Experiment experiment = Experiment.from(experimentId).get();
		experimentRepository.save(experiment);

		question1Sub(experiment.getId());
	}

	@Transactional
	public void question1Sub(final Long experimentId) {
		Experiment experiment = experimentRepository.findById(experimentId).orElse(null);
		final Long updateField = 20L;

		experiment.setUpdateField(updateField);
	}
	// ***** Q1. Finish *****

	// ***** Q2. Start *****
	@Transactional
	public void question2(final Long experimentId) {
		Experiment experiment = Experiment.from(experimentId).get();
		experimentRepository.save(experiment);

		question2Sub(experiment.getId());
	}

	public void question2Sub(final Long experimentId) {
		Experiment experiment = experimentRepository.findById(experimentId).orElse(null);
		final Long updateField = 20L;

		experiment.setUpdateField(updateField);
	}
	// ***** Q2. Finish *****

	// ***** Q3. Start *****
	public void question3(final Long experimentId) {
		Experiment experiment = Experiment.from(experimentId).get();
		experimentRepository.save(experiment);

		question3Sub(experiment.getId());
	}

	@Transactional
	public void question3Sub(final Long experimentId) {
		Experiment experiment = experimentRepository.findById(experimentId).orElse(null);
		final Long updateField = 20L;

		experiment.setUpdateField(updateField);
	}
	// ***** Q3. Finish *****

	// ***** Q4. Start *****
	@Transactional
	public void question4() {
		// DB 같은 행 1
		final Experiment experiment = experimentRepository.findById(5L).orElse(null);

		final Experiment experiment1 = experimentRepository.findByInsertField(20L).orElse(null);

		final Experiment experiment2 = experimentRepository.findByUpdateField(30L).orElse(null);
		// DB 같은 행 1


		// DB 같은 행 2
		final Experiment experiment3 = experimentRepository.findByInsertField(40L).orElse(null);

		final Experiment experiment4 = experimentRepository.findById(6L).orElse(null);
		// DB 같은 행 2

	}
	// ***** Q4. Finish *****

	// ***** Q5. Start *****
	@Transactional
	public void question5() {
		final Long updateField = 15L;
		// DB 같은 행 1
		final Experiment experiment = experimentRepository.findById(5L).orElse(null);
		experiment.setUpdateField(updateField);

		final Experiment experiment1 = experimentRepository.findByInsertField(20L).orElse(null);
		experiment1.setUpdateField(updateField);

		final Experiment experiment2 = experimentRepository.findByUpdateField(30L).orElse(null);
		experiment2.setUpdateField(updateField);
		// DB 같은 행 1


		// DB 같은 행 2
		final Experiment experiment3 = experimentRepository.findByInsertField(40L).orElse(null);
		experiment3.setUpdateField(updateField);

		final Experiment experiment4 = experimentRepository.findById(6L).orElse(null);
		experiment4.setUpdateField(updateField);
		// DB 같은 행 2

	}
	// ***** Q5. Finish *****
}
