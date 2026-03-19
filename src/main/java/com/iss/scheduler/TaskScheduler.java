package com.iss.scheduler;

import com.iss.models.Task;
import com.iss.service.TaskService;
import com.iss.service.WorkerThread;

import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    private TaskService service = new TaskService();

    public void startScheduling() throws Exception {

        List<Task> tasks = service.fetchTasks();

        PriorityQueue<Task> queue = new PriorityQueue<>();
        queue.addAll(tasks);

        while (!queue.isEmpty()) {
            Task task = queue.poll();

            WorkerThread worker = new WorkerThread(task, service);
            worker.start();

            worker.join();
        }
    }
}
