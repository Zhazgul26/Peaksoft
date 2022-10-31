package peaksoft.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.Util.Util;
import peaksoft.dao.TaskDao;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import java.util.List;

public class TaskDaoImpl implements TaskDao {
    private final SessionFactory sessionFactory = Util.creatSessionFactory();

    @Override
    public void saveTask(Long lesson_id, Task task) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Lesson lesson = session.find(Lesson.class,lesson_id);
            task.setLesson(lesson);
            lesson.addTasksToLesson(task);
            session.merge(lesson);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e) {
            System.out.println("Произошла ошибка ---> (saveTask)!");
        }
    }

    @Override
    public void updateTask(Long id, Task task) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Task updatedTask = session.get(Task.class, id);
            if (updatedTask == null) {
                System.out.println("Пусто, нет такого курса!");
            } else {
                updatedTask.setName(task.getName());
                updatedTask.setTask(task.getTask());
                updatedTask.setDeadLine(task.getDeadLine());
                session.merge(updatedTask);
                session.getTransaction().commit();
                session.close();
            }
        } catch (Exception e) {
            System.out.println(" Произошла ошибка ---> (updateTask)!");
        }
    }

    @Override
    public List<Task> getAllTaskLessonId(Long lessn_id) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Lesson lesson = session.find(Lesson.class,lessn_id);
            List<Task> taskList = lesson.getTasks();
            session.getTransaction().commit();
            session.close();
            return taskList;
        } catch (Exception exception) {
            System.out.println("Произошла ошибка ---> (getAllTaskByLessonId)!");
        }
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Task task = session.get(Task.class,id);
            task.setLesson(null);
            session.remove(task);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Произошла ошибка ---> (deleteTaskById)!");
        }
    }
}
