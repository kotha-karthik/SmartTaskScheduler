package com.iss.service;

import com.iss.models.Task;

public class WorkerThread extends Thread {

    private Task task;
    private TaskService service;

    public WorkerThread(Task task, TaskService service) {
        this.task = task;
        this.service = service;
    }

    @Override
    public void run() {
        try {
            System.out.println("Executing Task: " + task.getName());

            Thread.sleep(2000); // simulate work

            service.markCompleted(task.getId());

            System.out.println("Completed Task: " + task.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
