package task1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/washington")
public class ServletTimeWashington extends HttpServlet {
    //Задача 1:
    //Создать приложение, которое при переходе на следующие урлы будет выдавать
    //результат:
    // /minsk - время в Минске
    // /washington - время в Вашингтоне
    // /beijing - время в Пекине
    //При решении использовать оба варианта настройки (xml и аннотации).

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head> <title> Washington </title> </head>");
        out.println("<body>");
        out.println("<h1> Washington </h1>");
        out.println("Time in Washington: " + zonedDateTime.format(formatter));
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}