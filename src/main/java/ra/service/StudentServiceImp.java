package ra.service;

import ra.model.Student;
import ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImp {
    public List<Student> findAll(){
        List<Student> list = new ArrayList<Student>();
        try {
            Connection conn = ConnectionDB.getConnection();
           PreparedStatement pre= conn.prepareStatement("SELECT * from Students");
           ResultSet rs =  pre.executeQuery();
           while (rs.next()) {
               Student student = new Student();
               student.setId(rs.getString("id"));
               student.setName(rs.getString("name"));
               student.setBirthday(String.valueOf(rs.getDate("birthday")));
               student.setPhone(rs.getString("phone"));
               student.setAddress(rs.getString("address"));
               student.setGen(rs.getBoolean("gen"));
               student.setPlace(rs.getString("place"));
               list.add(student);
           }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean createNewStudent(Student stu){
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre= conn.prepareStatement("insert into Students values (?,?,?,?,?,?,?)");
            pre.setString(1,stu.getId());
            pre.setString(2,stu.getName());
            pre.setDate(3, Date.valueOf(stu.getBirthday()));
            pre.setBoolean(4,stu.isGen());
            pre.setString(5,stu.getAddress());
            pre.setString(6,stu.getPhone());
            pre.setString(7,stu.getPlace());
           int i = pre.executeUpdate();
            System.out.println(i);
        }catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }
//    public boolean updateStudent(Student student){
//
//    }
    public Student findById(String id){
        Student student = new Student();
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre= conn.prepareStatement("SELECT * from Students WHERE  id ="+id);
            ResultSet rs =  pre.executeQuery();
            while (rs.next()) {

                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setBirthday(String.valueOf(rs.getDate("birthday")));
                student.setPhone(rs.getString("phone"));
                student.setAddress(rs.getString("address"));
                student.setGen(rs.getBoolean("gen"));
                student.setPlace(rs.getString("place"));

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
    public boolean deleteStudent(String id){
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement pre= conn.prepareStatement("DELETE from Students WHERE id = "+id);
            pre.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
