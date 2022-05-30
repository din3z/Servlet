package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/put")
public class ServletPut extends HttpServlet {
    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPut (HttpServletRequest  request, HttpServletResponse response) throws IOException{
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

        int id2 = jobj.get("id2").getAsInt();

        String name = jobj.get("name2").getAsString();
        String surname = jobj.get("surname2").getAsString();
        double salary = jobj.get("salary2").getAsDouble();

        model.getFrontList().get(id2).setName(name);
        model.getFrontList().get(id2).setSurname(surname);
        model.getFrontList().get(id2).setSalary(salary);

        response.setContentType("application/json; charset=utf-8");
        PrintWriter pw = response.getWriter();

        pw.print(gson.toJson(model.getFrontList()));
    }
}
