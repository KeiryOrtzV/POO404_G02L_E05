package com.example.dao;

import com.example.model.Pedido;
import com.example.model.DetallePedido;
import com.example.model.Plato;
import com.example.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    public List<Pedido> getTodosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT id, fecha_pedido, estado, forma_pago, comentarios, total, comentarios_empleado, nombre_empleado " +
                "FROM pedidos ORDER BY fecha_pedido DESC";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getTimestamp("fecha_pedido"),
                        rs.getString("estado"),
                        rs.getString("forma_pago"),
                        rs.getString("comentarios"),
                        rs.getDouble("total")
                );
                pedido.setComentariosEmpleado(rs.getString("comentarios_empleado"));
                pedido.setNombreEmpleado(rs.getString("nombre_empleado"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public boolean actualizarEstadoPedido(int idPedido, String nuevoEstado, String comentariosEmpleado, String nombreEmpleado) {
        String sql = "UPDATE pedidos SET estado = ?, comentarios_empleado = ?, nombre_empleado = ? WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoEstado);
            pstmt.setString(2, comentariosEmpleado);
            pstmt.setString(3, nombreEmpleado);
            pstmt.setInt(4, idPedido);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Pedido> getPedidosSimples() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT id, fecha_pedido, estado, forma_pago, comentarios, total " +
                "FROM pedidos ORDER BY fecha_pedido DESC";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getTimestamp("fecha_pedido"),
                        rs.getString("estado"),
                        rs.getString("forma_pago"),
                        rs.getString("comentarios"),
                        rs.getDouble("total")
                );
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public List<Pedido> getPedidosActivos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT p.id, p.fecha_pedido, p.estado, p.forma_pago, p.comentarios, p.total " +
                "FROM pedidos p " +
                "WHERE p.estado != 'COMPLETADO'";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getTimestamp("fecha_pedido"),
                        rs.getString("estado"),
                        rs.getString("forma_pago"),
                        rs.getString("comentarios"),
                        rs.getDouble("total")
                );
                pedido.setDetalles(getDetallesPedido(pedido.getId()));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public Pedido getPedidoPorId(int idPedido) {
        String sql = "SELECT id, fecha_pedido, estado, forma_pago, comentarios, total " +
                "FROM pedidos WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPedido);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Pedido pedido = new Pedido(
                            rs.getInt("id"),
                            rs.getTimestamp("fecha_pedido"),
                            rs.getString("estado"),
                            rs.getString("forma_pago"),
                            rs.getString("comentarios"),
                            rs.getDouble("total")
                    );
                    pedido.setDetalles(getDetallesPedido(idPedido));
                    return pedido;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int insertarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedidos (fecha_pedido, estado, forma_pago, comentarios, total) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setTimestamp(1, new Timestamp(pedido.getFechaPedido().getTime()));
            pstmt.setString(2, pedido.getEstado());
            pstmt.setString(3, pedido.getFormaPago());
            pstmt.setString(4, pedido.getComentarios());
            pstmt.setDouble(5, pedido.getTotal());

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas == 0) {
                throw new SQLException("La creación del pedido falló, no se insertaron filas.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idPedido = generatedKeys.getInt(1);
                    insertarDetallesPedido(idPedido, pedido.getDetalles());
                    return idPedido;
                } else {
                    throw new SQLException("La creación del pedido falló, no se obtuvo el ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void insertarDetallesPedido(int idPedido, List<DetallePedido> detalles) {
        String sql = "INSERT INTO detalles_pedido (id_pedido, id_plato, cantidad, subtotal) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (DetallePedido detalle : detalles) {
                pstmt.setInt(1, idPedido);
                pstmt.setInt(2, detalle.getPlato().getId_plato());
                pstmt.setInt(3, detalle.getCantidad());
                pstmt.setDouble(4, detalle.getSubtotal());
                pstmt.addBatch();
            }

            pstmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<DetallePedido> getDetallesPedido(int idPedido) {
        List<DetallePedido> detalles = new ArrayList<>();
        String sql = "SELECT dp.id_detalle, dp.id_plato, dp.cantidad, dp.subtotal, " +
                "p.nombre_plato, p.descripcion, p.precio " +
                "FROM detalles_pedido dp " +
                "JOIN menu p ON dp.id_plato = p.id_plato " +
                "WHERE dp.id_pedido = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPedido);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Plato plato = new Plato(
                            rs.getInt("id_plato"),
                            rs.getString("nombre_plato"),
                            rs.getString("descripcion"),
                            rs.getDouble("precio"),
                            true  // Asumimos que está disponible
                    );

                    DetallePedido detalle = new DetallePedido(
                            rs.getInt("id_detalle"),
                            plato,
                            rs.getInt("cantidad"),
                            rs.getDouble("subtotal")
                    );

                    detalles.add(detalle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;
    }

    public boolean actualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedidos SET estado = ?, forma_pago = ?, comentarios = ? WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pedido.getEstado());
            pstmt.setString(2, pedido.getFormaPago());
            pstmt.setString(3, pedido.getComentarios());
            pstmt.setInt(4, pedido.getId());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Pedido> getPedidosPorUsuario(int idUsuario) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT p.id, p.fecha_pedido, p.estado, p.forma_pago, p.comentarios, p.total " +
                "FROM pedidos p " +
                "WHERE p.id_usuario = ? " +
                "ORDER BY p.fecha_pedido DESC";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Pedido pedido = new Pedido(
                            rs.getInt("id"),
                            rs.getTimestamp("fecha_pedido"),
                            rs.getString("estado"),
                            rs.getString("forma_pago"),
                            rs.getString("comentarios"),
                            rs.getDouble("total")
                    );
                    pedido.setDetalles(getDetallesPedido(pedido.getId()));
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }
}