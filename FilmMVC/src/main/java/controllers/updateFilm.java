package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAOEnum;
import model.Film;


@WebServlet("/updateFilm")
public class updateFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateFilm() { // constructor
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilmDAOEnum dao = FilmDAOEnum.INSTANCE;

		// get films details user wants to update
		Film f = new Film();
		f.setId(Integer.parseInt(request.getParameter("id")));

		Film thisFilm = dao.getFilm(f);

		request.setAttribute("film", thisFilm); 
		RequestDispatcher rd = request.getRequestDispatcher("./pages/updateFilm.jsp"); // set dispatcher location
		rd.include(request, response); // send values to updateFilm jsp

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilmDAOEnum dao = FilmDAOEnum.INSTANCE;

		// create film for updateFilm() param
		Film f = new Film();

		f.setId(Integer.parseInt(request.getParameter("id")));
		f.setTitle(request.getParameter("title"));
		f.setYear(Integer.parseInt(request.getParameter("year")));
		f.setDirector(request.getParameter("director"));
		f.setStars(request.getParameter("stars"));
		f.setReview(request.getParameter("review"));
		f.setGenre(request.getParameter("genre"));
		f.setRating(request.getParameter("rating"));

		try {
			dao.updateFilm(f); // update film in db
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("./home");

	}

}
