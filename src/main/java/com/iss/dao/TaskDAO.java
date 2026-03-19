package com.iss.dao;

import com.iss.models.Task;
import com.iss.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public void saveTask(Task task) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO tasks(name, priority, deadline, status) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, task.getName());
        ps.setInt(2, task.getPriority());
        ps.setTimestamp(3, new Timestamp(task.getDeadline()));
        ps.setString(4, "PENDING");

        ps.executeUpdate();
        con.close();
    }

    public List<Task> getAllTasks() throws Exception {
        List<Task> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM tasks");

        while (rs.next()) {
            Task task = new Task(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("priority"),
                    rs.getTimestamp("deadline").getTime(),
                    rs.getString("status")
            );
            list.add(task);
        }

        con.close();
        return list;
    }

    public void updateStatus(int id, String status) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "UPDATE tasks SET status=? WHERE id=?"
        );
        ps.setString(1, status);
        ps.setInt(2, id);
        ps.executeUpdate();
        con.close();
    }
}
