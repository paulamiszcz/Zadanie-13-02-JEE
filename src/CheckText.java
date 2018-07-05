import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tekst")
public class CheckText extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            loop(request, response);
        }

        private void loop(HttpServletRequest request, HttpServletResponse response) throws IOException {
            StringBuilder sb = new StringBuilder();
            request.setCharacterEncoding("UTF-8");
            String text = request.getParameter("tekst");
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("Tekst: " + text);
            writer.println("Rozmiar tekstu: " + text.length());
            String[] odstep = text.split(" ");
            for (String element : odstep) {
                sb.append(element);
            }
            writer.println("Ilość znaków bez spacji: " + sb.length());
            writer.println("Ilość wyrazów w tekście: " + odstep.length);
            String palindrom = sb.reverse().toString();
            if(text.equals(palindrom)) {
                writer.println("Czy tekst jest palindromem? Tak");
            } else {
                writer.println("Czy tekst jest palindromem? Nie");
            }
        }
}
