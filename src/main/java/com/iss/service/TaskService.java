package com.iss.service;

import com.iss.dao.TaskDAO;
import com.iss.models.Task;

import java.util.List;

public class TaskService {
    private TaskDAO dao = new TaskDAO();

    public void addTask(Task task) throws Exception {
        dao.saveTask(task);
    }

    public List<Task> fetchTasks() throws Exception {
        return dao.getAllTasks();
    }

    public void markCompleted(int id) throws Exception {
        dao.updateStatus(id, "COMPLETED");
    }
}
