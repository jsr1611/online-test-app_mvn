package services;

import models.Subject;

public interface subjectService {

    Subject addSubject();

    boolean updateSubject(Long id);

    boolean deleteSubject(Long id);

    void updatePrice(Long innerChoice);
}
