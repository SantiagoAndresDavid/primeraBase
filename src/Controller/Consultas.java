package Controller;

import model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas extends Conexccion {

    public void llenar(Producto producto) {
        PreparedStatement ps = null;
        Connection con = null;
        try {
            con = conectar();
            ps = con.prepareStatement("insert into productos (codigo,nombre,tipo,cantidad,stock,ruta) values (?,?,?,?,?,?)");
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipo());
            ps.setInt(4, producto.getCantidad());
            ps.setString(5, producto.getStock());
            ps.setString(6, producto.getImagen());
            ps.executeUpdate();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void modificar(Producto producto, int codigo) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conectar();
            ps = con.prepareStatement("UPDATE productos SET nombre=?, tipo=?,cantidad=?,stock=?,ruta=? WHERE codigo=?");
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTipo());
            ps.setInt(3, producto.getCantidad());
            ps.setString(4, producto.getStock());
            ps.setString(5, producto.getImagen());
            ps.setInt(6, codigo);

            ps.executeUpdate();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Producto buscar(int codigo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            con = conectar();
            ps = con.prepareStatement("SELECT * FROM productos where  codigo = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setTipo(rs.getString("tipo"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setStock(rs.getString("stock"));
                producto.setImagen(rs.getString("ruta"));
                return producto;
            } else {
                System.out.println("no se encontro nada");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void eliminar(int codigo) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conectar();
            ps = con.prepareStatement("DELETE FROM productos where  codigo = ?");
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
