package edu.curso.java.spring.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.*;
import org.springframework.stereotype.*;

import edu.curso.java.spring.bo.Producto;

@Repository
public class ProductoDAOImp implements ProductoDAO {

	private SimpleJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public void insertaProducto(Producto producto) {
		String sql = "insert into producto(id, nombre, precio) values "
				+ "(:id,:nombre, :precio)";

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", producto.getId());
		parameters.put("nombre", producto.getNombre());
		parameters.put("precio", producto.getPrecio());
		jdbcTemplate.update(sql, parameters);
	}

	@Override
	public List<Producto> listarProductos() {
		List<Producto> productos = jdbcTemplate.query(
				"select id, nombre, precio from producto",
				new RowMapper<Producto>() {
					public Producto mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Producto producto = new Producto();
						producto.setId(rs.getLong("id"));
						producto.setNombre(rs.getString("nombre"));
						producto.setPrecio(rs.getDouble("precio"));
						return producto;
					}
				});
		return productos;

	}

}