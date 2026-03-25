package com.testing.course.ejercicio_final.repository;

import com.testing.course.ejercicio_final.model.RecommendationLog;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RecommendationLogRepository extends CrudRepository<RecommendationLog, Long> {
    List<RecommendationLog> findByVetId(Long vetId);
    long countByVetId(Long vetId);
}
