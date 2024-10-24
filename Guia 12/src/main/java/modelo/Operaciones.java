package modelo;
import java.sql.*;
import javabeans.*;
import java.util.*;
public class Operaciones {
    public Connection getConnection(){
        Connection cn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            // Se obtiene una conexión con la base de datos. Cambie los parámetros por sus datos
            cn = DriverManager.getConnection (
                    "jdbc:mysql://localhost/mensajes","root", "");
        }
        catch(Exception e){e.printStackTrace();}
        return cn;
    }
    public ArrayList<MensajeBean> obtenerMensajes(String destino){
        Connection cn=null;
        ArrayList<MensajeBean> mensaje=null;
        Statement st;
        ResultSet rs;
        try {
            cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from mensajes where destinatario='"+destino+"'";
            rs=st.executeQuery(tsql);
            mensaje=new ArrayList<MensajeBean>();
            while (rs.next()) {
                MensajeBean m=new
                        MensajeBean(rs.getString("remitente"),rs.getString("destinatario"),
                        rs.getString("texto"));
                mensaje.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return(mensaje);
    }
    public boolean grabaMensaje(MensajeBean m){
        Connection cn;
        Statement st;
        ResultSet rs;
        boolean result = false;
        try {
            cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="Insert into mensajes values(null,'";tsql+=m.getRemite()+"','"+ m.getDestino()+"','"+
                    m.getTexto()+"')";
            st.execute(tsql);
            cn.close();
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}
