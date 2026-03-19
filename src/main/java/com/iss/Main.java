package com.iss;

import com.iss.models.Task;
import com.iss.scheduler.TaskScheduler;
import com.iss.service.TaskService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        TaskService service = new TaskService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Run Scheduler");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                sc.nextLine();
                System.out.print("Task Name: ");
                String name = sc.nextLine();

                System.out.print("Priority (1-10): ");
                int priority = sc.nextInt();

                long deadline = System.currentTimeMillis() + 60000;

                Task task = new Task(0, name, priority, deadline, "PENDING");
                service.addTask(task);

                System.out.println("Task Added!");

            } else if (choice == 2) {
                TaskScheduler scheduler = new TaskScheduler();
                scheduler.startScheduling();

            } else {
                break;
            }
        }
    }
}