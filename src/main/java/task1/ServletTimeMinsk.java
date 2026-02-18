package task1;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ServletTimeMinsk extends HttpServlet {
    //Задача 1:
    //Создать приложение, которое при переходе на следующие урлы будет выдавать
    //результат:
    // /minsk - время в Минске
    // /washington - время в Вашингтоне
    // /beijing - время в Пекине
    //При решении использовать оба варианта настройки (xml и аннотации).

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZoneId zoneId = ZoneId.of("Europe/Minsk");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head> <title> Minsk </title> </head>");
        out.println("<body>");
        out.println("<h1> Minsk </h1>");
        out.println("Time in Minsk: " + zonedDateTime.format(formatter));
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}