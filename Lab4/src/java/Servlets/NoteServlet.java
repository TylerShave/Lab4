
package Servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;


public class NoteServlet extends HttpServlet {
String path = getServletContext().getRealPath("/WEB-INF/note.txt");
String title;
String contents;
String read;
String[] titleArray;
String[] contentsArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NoteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NoteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         BufferedReader br = new BufferedReader(new FileReader(new 
        File(path)));
         //split note.txt once to grab the title
         read = br.readLine();
         titleArray = read.split("\\s+");
         //splits the rest of note.txt to make the contents section
         while ((read = br.readLine()) != null){
             contentsArray = read.split("\\s+");
         }
         //use split attributes to set the title and contents for displaying on viewnote.jsp
         request.setAttribute("titleMessage", titleArray);
         request.setAttribute("contentMessage", contentsArray);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new 
        FileWriter(path, false)));
        //parse the arrays to string for creating the note object
        title = titleArray.toString();
        contents = contentsArray.toString();
        
        Note savedNote = new Note(title, contents);
        
        if(request.getParameter("edit") != null){
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
            
            return;
        }
        
        if(request.getParameter("submitEdit") != null){
        
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
