package ra.controller;

import ra.model.Student;
import ra.service.StudentServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    StudentServiceImp  studentService = new StudentServiceImp();
    List<Student> listStudent = null;

    public void init() {
       listStudent = studentService.findAll();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("views/students.jsp");
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("SHOW")) {
                showAllStudent(request, response);
            } else if (action.equals("EDIT")) {
                String id = request.getParameter("id");
                for (Student s : listStudent
                ) {
                    if (s.getId().equals(id)) {
                        request.setAttribute("student_edit", s);
                        break;
                    }
                }
                request.getRequestDispatcher("views/editStudent.jsp").forward(request, response);
            } else if (action.equals("DELETE")) {
                String idDel = request.getParameter("id");
                for (Student s : listStudent) {
                    if (s.getId().equals(idDel)) {
                        listStudent.remove(s);
                        break;
                    }
                }
                showAllStudent(request,response);
            }else if (action.equals("SEARCH")){
                String searchName = request.getParameter("search");
                List<Student> listSearch = new ArrayList<>();
                for (Student s : listStudent) {
                    if(s.getName().toLowerCase().contains(searchName.toLowerCase())){
                        listSearch.add(s);
                    }
                }
                request.setAttribute("list",listSearch);
                request.getRequestDispatcher("views/students.jsp").forward(request, response);
            }
        }
    }

    public void showAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", listStudent);
        request.getRequestDispatcher("views/students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "CREATE":
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    String birthday = request.getParameter("birthday");
                    Boolean gen = Boolean.valueOf(request.getParameter("gen"));
                    String address = request.getParameter("address");
                    String place = request.getParameter("place");
                    Student newStudent = new Student(id, name, birthday, gen, address, null, place);
                    boolean check= studentService.createNewStudent(newStudent);
                    System.out.println(check);
                    listStudent=studentService.findAll();
                    showAllStudent(request,response);
                    break;
                case "UPDATE":
                    String idUp = request.getParameter("id");
                    String nameUp = request.getParameter("name");
                    String birthdayUp = request.getParameter("birthday");
                    Boolean genUp = Boolean.valueOf(request.getParameter("gen"));
                    String addressUp = request.getParameter("address");
                    String placeUp = request.getParameter("place");
                    Student updatedStudent = new Student(idUp, nameUp, birthdayUp, genUp, addressUp, null, placeUp);
                    updateStudent(updatedStudent);
                    showAllStudent(request, response);
                    break;

            }
        }
    }

    public void createNewStudent(Student student) {
        listStudent.add(student);
    }

    public void updateStudent(Student student) {
        for (Student stu : listStudent) {
            if (stu.getId().equals(student.getId())) {
                listStudent.set(listStudent.indexOf(stu), student);
                break;
            }
        }
    }
}
