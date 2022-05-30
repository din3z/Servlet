package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Map;

@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet {
    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html; charset=utf-8");
//        PrintWriter pw = response.getWriter();
//        //Reader reader =  request.getReader();
//        int id = Integer.parseInt(request.getParameter("id"));
//        if (id == 0)
//        {
//            pw.print("html" + "<h3>Доступные пользователи </h3><br/>" + "<ul>");
//            for (Map.Entry<Integer, User> entry : model.getFrontList().entrySet())
//            {
//                pw.print("<li>" + entry.getKey() + "</li>" + "<ul>" +
//                        "<li>Имя " + entry.getValue().getName() + "</li>" +
//                        "<li>Имя " + entry.getValue().getSurname() + "</li>" +
//                        "<li>Имя " + entry.getValue().getSalary() + "</li>" + "</ul>" +
//                        "<a href = \'index.jsp\' Домой> </a>" +
//                        "</html>");
//
//            }
//            pw.print("</ul>" + "<a href = \'index.jsp\' > Домой </a>" + "</html>");
//        }
//        else if (id > 0)
//        {
//            if (id > model.getFrontList().size())
//            {
//                pw.print("<html>" + "<h3> такого пользователя нет</h3>" +
//                        "<a href = \'index.jsp\'> Домой </a>" +
//                        "</html>");
//            }
//            model.getFrontList().get(id);
//            pw.print("<html>" + "<h3>Запрошенный пользователь </h3>" + "<br/>" +
//                    "Имя " + model.getFrontList().get(id).getName() + "<br/>" +
//                    "Фамилия " + model.getFrontList().get(id).getSurname() + "<br/>" +
//                    "Зарплата " + model.getFrontList().get(id).getSalary() + "<br/>" +
//                    "<a href = \'index.jsp\' > Домой </a>" +
//                    "</html>");
//        }
//        else
//            {
//            pw.print("<html>" + "<h3>id больше 0! </h3>" + "<a href = \'index.jsp\' Домой </a>" +
//                    "</html>");
//            }
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        StringBuffer jb = new StringBuffer();
        String line;
        try{
            BufferedReader reader = request.getReader();
            while((line = reader.readLine())!= null){
                jb.append(line);
            }
        }catch (Exception e){
            System.out.println("error");
        }
        JsonObject jobj = gson.fromJson(String.valueOf(jb),JsonObject.class);
        request.setCharacterEncoding("UTF-8");

        int id = jobj.get("id").getAsInt();
        response.setContentType("application/json; charset=utf-8");
        PrintWriter pw = response.getWriter();


        if (id==0)
        {
            for (Map.Entry<Integer, User> entry : model.getFrontList().entrySet())
            {
                pw.print(gson.toJson(entry.getKey()));
                pw.print(gson.toJson(entry.getValue().getName()));
                pw.print(gson.toJson(entry.getValue().getSurname()));
                pw.print(gson.toJson(entry.getValue().getSalary()));
            }
        }
        else if (id>0){
            if (id > model.getFrontList().size()){
                ;//???обработчик
            }
            pw.print(gson.toJson(model.getFrontList().get(id).getName()));
            pw.print(gson.toJson(model.getFrontList().get(id).getSurname()));
            pw.print(gson.toJson(model.getFrontList().get(id).getSalary()));
        }
    }

}

