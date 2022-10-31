package peaksoft.serviceImpl;

import peaksoft.dao.LessonDao;
import peaksoft.dao.daoImpl.LessonDaoImpl;
import peaksoft.entity.Lesson;
import peaksoft.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
private final LessonDao  lessonDao = new LessonDaoImpl();
    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
       lessonDao.saveLesson(courseId, lesson);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
lessonDao.updateLesson(id, lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long id) {
        return lessonDao.getLessonByCourseId(id);
    }
}
