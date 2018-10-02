package com.andrea.perez.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrea.perez.model.UsuarioDAO;
import com.andrea.perez.model.VideoDAO;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/inicio")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_INICIO = "/backoffice/index.jsp";
	
	private static UsuarioDAO daoUsuario;
	private static VideoDAO daoVideo;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
		daoVideo = VideoDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			request.setAttribute("usuarios", daoUsuario.getAll().size());
			request.setAttribute("videos", daoVideo.getAll().size());
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
		}
	}

}
