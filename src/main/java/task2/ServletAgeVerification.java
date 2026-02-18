package task2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/age-verification")
public class ServletAgeVerification extends HttpServlet {
    //Задача 2:
    //Создать сервлет который на вход принимает возраст, а в ответе возвращает
    //информацию, совершеннолетний или нет.

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        int age = Integer.parseInt(req.getParameter("age"));
        PrintWriter out = resp.getWriter();
        if (age > 17) {
            out.println("<h1>The user is an adult</h1>");
        } else {
            out.println("<h1>The user is a minor</h1>");
        }
    }
}