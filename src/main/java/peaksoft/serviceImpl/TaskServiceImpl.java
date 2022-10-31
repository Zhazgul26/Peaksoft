package peaksoft.serviceImpl;

import peaksoft.dao.TaskDao;
import peaksoft.dao.daoImpl.TaskDaoImpl;
import peaksoft.entity.Task;
import peaksoft.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao = new TaskDaoImpl();
    @Override
    public void saveTask(Long lessonId, Task task) {
        taskDao.saveTask(lessonId,task);
    }

    @Override
    public void updateTask(Long id, Task task) {
taskDao.updateTask(id, task);
    }

    @Override
    public List<Task> getAllTasksByLessonId(Long id) {
        return taskDao.getAllTaskLessonId(id);
    }

    @Override
    public void deleteTaskById(Long id) {
taskDao.deleteTaskById(id);
    }
}
