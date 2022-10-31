package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonDao {
    void saveLesson(Long course_id, Lesson lesson);
  void updateLesson (Long id, Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getLessonByCourseId(Long course_id);

}
