package com.iss.models;

public class Task implements Comparable<Task> {
    private int id;
    private String name;
    private int priority;
    private long deadline;
    private String status;

    public Task(int id, String name, int priority, long deadline, String status) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public long getDeadline() {
        return deadline;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return other.priority - this.priority; // higher priority first
        }
        return Long.compare(this.deadline, other.deadline);
    }
}
