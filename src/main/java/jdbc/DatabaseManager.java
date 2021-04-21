package jdbc;

import model.Doctor;
import model.Patient;
import model.TimeLine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String url = "jdbc:postgresql://localhost:5432/lesson1ExtraTask";
    private static final String dbUser = "postgres";
    private static final String password = "123";
    List<Doctor> doctorList = new ArrayList<>();
    public static List<TimeLine> timeLineList = new ArrayList<>();
    public static TimeLine timeLine;


    public void enterPatientInfo(Patient patient) {
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, password);
            String query = "insert into patient(first_nam,last_name,phone,address) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, patient.getFirstname());
            preparedStatement.setString(2, patient.getLastname());
            preparedStatement.setString(3, patient.getPhone());
            preparedStatement.setString(4, patient.getAddress());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getTimeLineId(Integer a) {


        try {
            Connection connection = DriverManager.getConnection(url, dbUser, password);
            String sql = "select id from timeline where id='" + a + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("id");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;

    }

    public int getDoctorId(String firstName) {
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, password);
            String sql = "select id from doctor where first_name='" + firstName + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;

    }

    public int getPatientId(String firstname, String lastname) {
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, password);
            String sql = "select id from patient where first_nam='" + firstname + "' and last_name='" + lastname + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public void showDoctors() {
        Doctor doctor;
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, password);
            String sql = "select id, first_name ,last_name from doctor";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer docId = resultSet.getInt("id");
                String firstname = resultSet.getString("first_name");
                String lastname = resultSet.getString("last_name");
                doctor = new Doctor(docId, firstname, lastname);
                doctorList.add(doctor);
            }
            int i = 1;
            for (Doctor doctor1 : doctorList) {
                System.out.println(i + ".  " + doctor1.getFirstname() + "  " + doctor1.getLastname());
                i++;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public String infoGettingFromDoctors(int a) {

        for (Doctor doctor : doctorList) {
            if (doctor.getId().equals(a)) {
                return doctor.getFirstname();
            }
        }
        return "";
    }

    public void showTimeLine(Integer doctor) {
        TimeLine timeLine;

        try {
            Connection connection = DriverManager.getConnection(url, dbUser, password);
            String sql = "select id, start_time,end_time,status,date from timeline where (doctor_id='" + doctor + "' and status='false')";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Time starts = resultSet.getTime("start_time");
                Time ends = resultSet.getTime("end_time");
                Boolean stat = resultSet.getBoolean("status");
                Date date = resultSet.getDate("date");
                timeLine = new TimeLine(id, starts, ends, stat, date);
                timeLineList.add(timeLine);
            }

            for (TimeLine line : timeLineList) {
                System.out.println(line.getId() + ".  " + line.getStartTime() + "  " + line.getEndTime() + "  " + line.getDate());


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        timeLineList.clear();
    }


}
