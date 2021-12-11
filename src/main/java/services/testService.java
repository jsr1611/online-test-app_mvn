package services;

import models.Test;

public interface testService {
    Test createTest();

    boolean updateTest(Long id, Long subjectId);

    boolean deleteTest(Long id, Long subjectId);
}
