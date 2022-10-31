package peaksoft.dao;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskDao {
    void saveTask (Long lesson_id, Task task);

    void updateTask(Long id ,Task task);

    List<Task> getAllTaskLessonId (Long lessn_id);

    void deleteTaskById(Long id);

}
