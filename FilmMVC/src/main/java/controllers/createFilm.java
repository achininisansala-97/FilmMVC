package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAOEnum;
import model.Film;


@WebServlet("/createFilm")
public class createFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public createFilm() { // constructor
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("./pages/addFilm.jsp"); // set dispatcher location
		rd.include(request, response); // send values to updateFilm jsp

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilmDAOEnum dao = FilmDAOEnum.INSTANCE;

		Film f = new Film(); // constructor sets all variables to null

		// build film from parameters
		f.setTitle(request.getParameter("title"));
		f.setYear(Integer.parseInt(request.getParameter("year")));
		f.setDirector(request.getParameter("director"));
		f.setStars(request.getParameter("stars"));
		f.setReview(request.getParameter("review"));
		f.setGenre(request.getParameter("genre"));
		f.setRating(request.getParameter("rating"));

		try { // insert film
			dao.insertFilm(f);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("./home");

	}

}
