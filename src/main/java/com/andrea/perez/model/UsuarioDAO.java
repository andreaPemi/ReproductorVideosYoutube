package com.andrea.perez.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.andrea.perez.pojo.Usuario;
import com.andrea.perez.pojo.Video;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements Crudable<Usuario> {
	private static UsuarioDAO INSTANCE = null;
	private final String SQL_GET_ALL = "SELECT nombre, password FROM usuario ORDER BY id DESC LIMIT 1000";
	private final String SQL_GET_BY_ID = "SELECT nombre, password FROM usuario WHERE id = ? LIMIT 1000";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, contrasena = ? WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO usuario (nombre, password) VALUES (?, ?);";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (pojo != null) {

				ps.setString(1, pojo.getNombre());
				ps.setString(2, pojo.getContrasena());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					resul = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				usuarios.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario getById(String id) {

		return null;
	}

	@Override
	public boolean update(Usuario pojo) {
		boolean resul = false;
		return resul;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		return false;
	}

	private Usuario rowMapper(ResultSet rs) throws Exception {
		Usuario u = new Usuario();
		if (rs != null) {
			u.setId(rs.getLong("id"));
			u.setNombre(rs.getString("codigo"));
			u.setContrasena(rs.getString("nombre"));
		}
		return u;
	}

}
