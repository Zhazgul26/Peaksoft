package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.Util.Util;
import peaksoft.dao.InstructorDao;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    private final EntityManagerFactory managerFactory = Util.creatSessionFactory();
    private final SessionFactory sessionFactory = Util.creatSessionFactory();
    @Override
    public void saveInstructor(Instructor instructor) {
        try {
            EntityManager entityManager1 = managerFactory.createEntityManager();
            entityManager1.getTransaction().begin();
            entityManager1.persist(new Instructor(instructor.getFirstName(), instructor.getLastName(), instructor.getEmail(), instructor.getPhoneNumber()));
            entityManager1.getTransaction().commit();
            entityManager1.close();
        } catch (Exception e) {
            System.out.println("! -> (saveInstructor)");
        }
        }


    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor updatedInstructor = session.find(Instructor.class, id);
            updatedInstructor.setCourse(instructor.getCourse());
            updatedInstructor.setEmail(instructor.getEmail());
            updatedInstructor.setFirstName(instructor.getFirstName());
            updatedInstructor.setLastName(instructor.getLastName());
            updatedInstructor.setPhoneNumber(instructor.getPhoneNumber());
            session.merge(updatedInstructor);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("An error occurred -> (updateInstructor)!");
        }
    }

    @Override
    public Instructor getInstructorById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor = session.find(Instructor.class, id);
            if (instructor==null){
                System.out.println("Empty,no such instructor!");
            }
            session.getTransaction().commit();
            session.close();
            return instructor;
        } catch (Exception e) {
            System.out.println("An error occurred -> (getInstructorById)!");
        }
        return null;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long course_id) {
        try { Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class, course_id);
            List<Instructor> instructors = course.getInstructors();
            session.getTransaction().commit();
            session.close();
            return instructors;
        } catch (Exception e) {
            System.out.println("An error occurred -> (getInstructorByCourseId)!");
        }
        return null;
    }

    @Override
    public void deleteInctructorById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor = session.find(Instructor.class, id);
            session.remove(instructor);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка ---> (deleteInstructorById)! -_-_-_-_-_-_-_-_-_-_-");
        }
    }

    @Override
    public void assignInstructorToCourse(Long id, Long course_id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.get(Course.class, course_id);
            if (course == null) {
                System.out.println("_-_-_-_-_-_-_-_-_-_- Пусто, нет такого курса! -_-_-_-_-_-_-_-_-_-_-");
            } else {
                Instructor instructor = session.get(Instructor.class,id);
                if (instructor == null){
                    System.out.println("_-_-_-_-_-_-_-_-_-_- Пусто, нет такого инструктора! -_-_-_-_-_-_-_-_-_-_-");
                } else {
                    instructor.getCourse().add(course);
                    session.merge(instructor);
                }
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка ---> (assignInstructorToCourse)! -_-_-_-_-_-_-_-_-_-_-");
        }
    }
    }
