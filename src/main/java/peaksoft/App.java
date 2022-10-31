package peaksoft;

import peaksoft.Util.Util;
import peaksoft.dao.CourseDao;
import peaksoft.dao.InstructorDao;
import peaksoft.dao.LessonDao;
import peaksoft.dao.TaskDao;
import peaksoft.dao.daoImpl.CourseDaoImpl;
import peaksoft.dao.daoImpl.InstructorDaoImpl;
import peaksoft.dao.daoImpl.LessonDaoImpl;
import peaksoft.dao.daoImpl.TaskDaoImpl;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.service.InstructorService;
import peaksoft.service.LessonService;
import peaksoft.service.TaskService;
import peaksoft.serviceImpl.CourseServiceImpl;
import peaksoft.serviceImpl.InstructorServiceImpl;
import peaksoft.serviceImpl.LessonServiceImpl;
import peaksoft.serviceImpl.TaskServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 */


public class App{
    public static final Course courseService = new Course();
    public static final InstructorService instructorService = new InstructorServiceImpl();
    public static final LessonService lessonService = new LessonServiceImpl();
    public static final TaskService taskService = new TaskServiceImpl();

    public static void main(String[] args) {
        Util.creatSessionFactory();

        CourseDao courseDao = new CourseDaoImpl();
        InstructorDao instructorDao = new InstructorDaoImpl();
        LessonDao lessonDao = new LessonDaoImpl();
        TaskDao taskDao = new TaskDaoImpl();

        Course course1 = new Course("Peaksoft","Grajdanskaya 119","01.09.2020",
                "dlina ssylki prevyshaet (225),mojete poluchit ego cherez ssylki saita!","A great!");
        Course course2 = new Course("DevX","At national universities","12.07.2022","dlina ssylki prevyshaet (225),mojete poluchit ego cherez ssylki saita!","A good!");
        Course course3 = new Course("Makers","Tynyshalieva 29","05.08.2019","dlina ssylki prevyshaet (225),mojete poluchit ego cherez ssylki saita!","A great!");

        courseDao.saveCourse(course1);
        courseDao.saveCourse(course2);
        courseDao.saveCourse(course3);

        Instructor instructor1 = new Instructor("Mukhamed","Allanov","allanov@gmail.com","+996 777-004-446");
        Instructor instructor2 = new Instructor("Adina","Tilekova","adinana@gmail.com","+1 573-268-1967 ");
        Instructor instructor3 = new Instructor("Diana","Aidarovs","dian@gmail.com","+996 5555-777-777");
        Instructor instructor4 = new Instructor("Ulan","Bakytov","ulannn@gmail.com","+1 573-002-2214");
        instructorDao.saveInstructor(instructor1);
        instructorDao.saveInstructor(instructor2);
        instructorDao.saveInstructor(instructor3);
        instructorDao.saveInstructor(instructor4);

        Lesson lesson1 = new Lesson("JDBC","https://www.youtube.com/watch?v=nL9dnvoF_ng");
        Lesson lesson2 = new Lesson("OOP","https://www.youtube.com/watch?v=CHwzlHpp5CI");
        Lesson lesson3 = new Lesson("Hibernate","https://www.youtube.com/watch?v=xybmKzQ5s4c&list=PL8X2nqRlWfabWFN81Zi4vl30cZsdyxt6e");
//        Lesson lesson4 = new Lesson("Apache Maven","https://www.youtube.com/watch?v=0uwMKktzixU");
//        Lesson lesson5 = new Lesson("Spring Framework","https://www.youtube.com/watch?v=5ePo08sqcpk&list=PLAma_mKffTOR5o0WNHnY0mTjKxnCgSXrZ");
        lessonDao.saveLesson(1L,lesson1);
        lessonDao.saveLesson(2L,lesson2);
        lessonDao.saveLesson(3L,lesson3);



        Task task1 = new Task("Project 'TimeTable'","02.11.22","Creat!");
        Task task2 = new Task("Project 'Library'","01.11.22","Creat!");
        Task task3 = new Task("Project 'Course'","11.11.22","Creat!");
//        Task task4 = new Task("Project 'Register'","01.11.22","Creat!");
//        Task task5 = new Task("Project 'Company'","22.11.22","Creat!");
//        Task task6 = new Task("Project 'Elevator'","16.11.22","Creat!");
//        Task task7 = new Task("Project 'Calculate'","20.11.22","Creat!");
        taskDao.saveTask(1L,task1);
        taskDao.saveTask(1L,task2);
        taskDao.saveTask(1L,task3);




//        instructorService.saveInstructor(instructor3);
//        instructorService.updateInstructor(1L,instructor4);
//        System.out.println(instructorService.getInstructorById(1L));
//        instructorService.assignInstructorToCourse(2L,3L);
//        System.out.println(instructorService.getInstructorByCourseId(1L));
//        instructorService.deleteInstructorById(1L);
//
//        lessonService.saveLesson(2L,lesson1);
//        lessonService.updateLesson(2L,lesson4);
//        System.out.println(lessonService.getLessonById(1L));
//        System.out.println(lessonService.getLessonsByCourseId(1L));
//
//        taskService.saveTask(2L,task6);
//        taskService.updateTask(1L,task4);
//        System.out.println(taskService.getAllTasksByLessonId(1L));
//        taskService.deleteTaskById(1L);
        commands();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        switch (s){
//            ------------Courses------------
            case "1" -> courseDao.saveCourse(course1);
            case "2" -> courseDao.getCourseById(course1.getId());
            case "3" -> courseDao.getallCourse();
            case "4" -> courseDao.updateCourse(course1.getId(),course3);
            case "5" -> courseDao.deleteCourseById(1L);
            case "6" -> courseDao.getCourseByName(course1.getName());
//           -----------Instructors------------
            case "7" -> instructorDao.saveInstructor(instructor1);
            case "8" -> instructorDao.updateInstructor(1L, instructor1);
            case "9" -> instructorDao.getInstructorById(1L);
            case "10"-> instructorDao.getInstructorByCourseId(1l);
            case "11"-> instructorDao.deleteInctructorById(1L);
            case "12"-> instructorDao.assignInstructorToCourse(1L, 1L);
     //       ------------Lessons------------
            case "13"-> lessonDao.saveLesson(3L, lesson3);
            case "14"-> lessonDao.updateLesson(3L, lesson1);
            case "15"-> lessonDao.getLessonById(3L);
            case "16"-> lessonDao.getLessonByCourseId(3L);
//            ------------Tasks------------
            case "17"-> taskDao.saveTask(1L, task2);
            case "18"-> taskDao.updateTask(1L, task1);
            case "19"-> taskDao.getAllTaskLessonId(1L);
            case "20"-> taskDao.deleteTaskById(1L);
        }
    }
    public static void commands(){
        System.out.println("------------Courses------------");
        System.out.println("1-button 'saveCourse'");
        System.out.println("2-button 'getCourseById'");
        System.out.println("3-button 'getAllCourse'");
        System.out.println("4-button 'updateCourse'");
        System.out.println("5-button deleteCourseById");
        System.out.println("6-button getCourseByName");
        System.out.println("------------Instructors------------");
        System.out.println("7-button 'saveInstructor'");
        System.out.println("8-button 'updateInstructor'");
        System.out.println("9-button 'getInstructorById'");
        System.out.println("10-button 'getInstructorByCourseId'");
        System.out.println("11-button 'deleteInctructorById'");
        System.out.println("12-button 'assignInstructorToCourse'");
        System.out.println("------------Lessons------------");
        System.out.println("13-button 'saveLesson'");
        System.out.println("14-button 'updateLesson'");
        System.out.println("15-button 'getLessonById'");
        System.out.println("16-button 'getLessonByCourseId'");
        System.out.println("------------Tasks------------");
        System.out.println("17-button 'saveTask'");
        System.out.println("18-button 'updateTask'");
        System.out.println("19-button 'getAllTaskLessonId'");
        System.out.println("20-button 'deleteTaskById'");
    }


}
