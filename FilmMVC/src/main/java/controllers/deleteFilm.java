package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAOEnum;
import model.Film;


@WebServlet("/deleteFilm")
public class deleteFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteFilm() { // constructor
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response); // pass to doPost()

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilmDAOEnum dao = FilmDAOEnum.INSTANCE;

		Integer id = Integer.parseInt(request.getParameter("id")); // get id param

		try {
			dao.deleteFilm(id); // delete film from DB
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("./home");

	}

}
