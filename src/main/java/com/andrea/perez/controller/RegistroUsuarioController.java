package com.andrea.perez.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrea.perez.model.UsuarioDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Usuario;

/**
 * Servlet implementation class RegistroUsuarioController
 */
@WebServlet("/registro")
public class RegistroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String usuario = "";
	private static String pswd = "";
	private static String pswdRepe = "";
	Alert msg=null;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			usuario = request.getParameter("usuario");
			pswd = request.getParameter("pswd");
			pswdRepe = request.getParameter("pswdRepe");
			Usuario u=null;
			
			//Comprobar que el pass sean iguales en los campos:
			if(pswd.equals(pswdRepe)) {
				if(usuario!=null) {
					u=new Usuario(usuario,pswd);
					UsuarioDAO daoUser=UsuarioDAO.getInstance();
					daoUser.insert(u);
					
				}else {
					msg=new Alert(Alert.ALERT_WARNING,"Error...El campo nombre no puede ir vacio");
				}
			}else {
				msg=new Alert(Alert.ALERT_WARNING,"Error...Las contraseñas deben coincidir");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("inicio").forward(request, response);
		}
	}

}
