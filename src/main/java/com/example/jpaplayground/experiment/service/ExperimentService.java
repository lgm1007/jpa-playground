package com.example.jpaplayground.experiment.service;

import com.example.jpaplayground.experiment.entity.Experiment;
import com.example.jpaplayground.experiment.repository.ExperimentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExperimentService {
	private final ExperimentRepository experimentRepository;

	// ***** Q1. Start *****
	@Transactional
	public void question1(final Long experimentId) {
		Experiment experiment = Experiment.from(experimentId).get();
		experimentRepository.save(experiment);	// select, insert

		question1Sub(experiment.getId());
	}	// question1() 완료 시 update

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
		experimentRepository.save(experiment);	// select, insert

		question2Sub(experiment.getId());
	}	// question2() 완료 시 update

	public void question2Sub(final Long experimentId) {
		Experiment experiment = experimentRepository.findById(experimentId).orElse(null);
		final Long updateField = 20L;

		experiment.setUpdateField(updateField);
	}
	// ***** Q2. Finish *****

	// ***** Q3. Start *****
	public void question3(final Long experimentId) {
		Experiment experiment = Experiment.from(experimentId).get();
		experimentRepository.save(experiment);    // select, insert

		question3Sub(experiment.getId());
	}

	@Transactional
	public void question3Sub(final Long experimentId) {
		Experiment experiment = experimentRepository.findById(experimentId).orElse(null);
		final Long updateField = 20L;

		experiment.setUpdateField(updateField);	// 업데이트 안 됨 X
	}
	// ***** Q3. Finish *****

	// ***** Q4. Start *****
	@Transactional
	public void question4() {
		// DB 같은 행 1
		final Experiment experiment = experimentRepository.findById(5L).orElse(null);	// select

		final Experiment experiment1 = experimentRepository.findByInsertField(20L).orElse(null);	// select

		final Experiment experiment2 = experimentRepository.findByInsertFieldByQueryDsl(20L).orElse(null);	// select
		// DB 같은 행 1


		// DB 같은 행 2
		final Experiment experiment3 = experimentRepository.findByInsertField(40L).orElse(null);	// select

		final Experiment experiment4 = experimentRepository.findById(6L).orElse(null);	// select X (캐싱)
		// DB 같은 행 2

	}
	// ***** Q4. Finish *****

	// ***** Q5. Start *****
	@Transactional
	public void question5() {
		/**
		 * INSERT INTO Experiment (id, insertField, updateField) VALUES (5, 20, 30);
		 * INSERT INTO Experiment (id, insertField, updateField) VALUES (6, 40, 50);
		 * 쿼리 선행
		 */

		// DB 같은 행 1
		final Experiment experiment = experimentRepository.findById(5L).orElse(null);	// select
		experiment.setUpdateField(5L);

		final Experiment experiment1 = experimentRepository.findByInsertField(20L).orElse(null);	// update, select
		experiment1.setUpdateField(15L);

		final Experiment experiment2 = experimentRepository.findByInsertFieldByQueryDsl(20L).orElse(null);	// update, select
		experiment2.setUpdateField(25L);
		// DB 같은 행 1


		// DB 같은 행 2
		final Experiment experiment3 = experimentRepository.findByInsertField(40L).orElse(null);	// update (experiment2.setUpdateField(25L);에 대한 업데이트), select
		experiment3.setUpdateField(35L);

		final Experiment experiment4 = experimentRepository.findById(6L).orElse(null);	// select X (캐싱)
		experiment4.setUpdateField(45L);
		// DB 같은 행 2

	}	// question5() 완료 시 update
	// ***** Q5. Finish *****
}
