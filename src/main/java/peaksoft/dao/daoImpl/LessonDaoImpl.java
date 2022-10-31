package peaksoft.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.Util.Util;
import peaksoft.dao.LessonDao;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;

import java.util.List;

public class LessonDaoImpl implements LessonDao {
private final SessionFactory sessionFactory =Util.creatSessionFactory();
    @Override
    public void saveLesson(Long course_id, Lesson lesson) {

        try {
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            Course course = session.get(Course.class,course_id);
            if (course == null) {
                System.out.println("_-_-_-_-_-_-_-_-_-_- Нет такого курса! -_-_-_-_-_-_-_-_-_-_-)");
            } else {
                lesson.setCourse(course);
                session.merge(lesson);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка! ---> (saveLesson)! -_-_-_-_-_-_-_-_-_-_-");
        }
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Lesson updatedLesson = session.get(Lesson.class, id);
            if (updatedLesson == null) {
                System.out.println("_-_-_-_-_-_-_-_-_-_ Нет такого курса! -_-_-_-_-_-_-_-_-_-_-");
            } else {
                updatedLesson.setName(lesson.getName());
                updatedLesson.setVideoLink(lesson.getVideoLink());
                updatedLesson.setTasks(lesson.getTasks());
                updatedLesson.setCourse(lesson.getCourse());
                session.merge(updatedLesson);
                session.getTransaction().commit();
                session.close();
            }
        } catch (Exception e) {
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка! ---> (updateLesson)! -_-_-_-_-_-_-_-_-_-_-");
        }
    }



    @Override
    public Lesson getLessonById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Lesson lesson = session.find(Lesson.class, id);
            if (lesson == null) {
                System.out.println("_-_-_-_-_-_-_-_-_-_- Пусто, нет такого урока! -_-_-_-_-_-_-_-_-_-_-");
            }
            session.getTransaction().commit();
            session.close();
            return lesson;
        } catch (Exception e) {
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка! ---> (getLessonById)! -_-_-_-_-_-_-_-_-_-_-");
        }
        return null;
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long course_id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,course_id);
            List<Lesson> lessons = course.getLessons();
            session.getTransaction().commit();
            session.close();
            return lessons;
        } catch(Exception e){
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка! ---> (getLessonsByCourseId)! -_-_-_-_-_-_-_-_-_-_-");
        }
        return null;
    }
}