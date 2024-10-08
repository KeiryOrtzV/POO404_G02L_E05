package www.udb.edu.sv.beans;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PersonaBean { Connection conexion = null;
    ResultSet rs = null;
    PreparedStatement st = null;
    private String operacion;
    private int idPersona;
    private String nombrePersona;
    private int edadPersona;
    private String telefonoPersona;
    private String sexoPersona;
    private int idOcupacion;
    private OcupacionBean ocupacion;
    private String fechaNac;
    private String usuario;
    private String password;
    private List<PersonaBean> listaPersonas;
    public PersonaBean() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion
                    =DriverManager.getConnection("jdbc:mysql://localhost/personabdd","root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombrePersona() {
        return nombrePersona;
    }
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
    public int getEdadPersona() {
        return edadPersona;
    }
    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }
    public String getTelefonoPersona() {
        return telefonoPersona;
    }
    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }
    public String getSexoPersona() {
        return sexoPersona;
    }
    public void setSexoPersona(String sexoPersona) {
        this.sexoPersona = sexoPersona;
    }
    public int getIdOcupacion() {
        return idOcupacion;
    }
    public void setIdOcupacion(int idOcupacion) {
        this.idOcupacion = idOcupacion;
    }
    public OcupacionBean getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(OcupacionBean ocupacion) {
        this.ocupacion = ocupacion;
    }
    public String getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<PersonaBean> getListaPersonas() {
        try {
            st = conexion.prepareStatement("SELECT * FROM persona a INNER JOIN ocupaciones o ON a.id_ocupacion = o.id_ocupacion");
                    rs = st.executeQuery();
            List<PersonaBean> list = new ArrayList<>();
            while (rs.next()) {
                PersonaBean persona = new PersonaBean();
                OcupacionBean ocupacion = new OcupacionBean();
                persona.setIdPersona(rs.getInt("id_persona"));
                persona.setNombrePersona(rs.getString("nombre_persona"));
                persona.setEdadPersona(rs.getInt("edad_persona"));
                persona.setTelefonoPersona(rs.getString("telefono_persona"));
                persona.setSexoPersona(rs.getString("sexo_persona"));
                persona.setFechaNac(rs.getString("fecha_nac"));
                ocupacion.setIdOcupacion(rs.getInt("id_ocupacion"));
                ocupacion.setOcupacion(rs.getString("ocupacion"));
                persona.setOcupacion(ocupacion);
                list.add(persona);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public String getNombreOcupacion(){
        try{
            st = conexion.prepareStatement("SELECT * FROM ocupaciones WHERE id_ocupacion=?");
            st.setInt(1, this.idOcupacion);
            rs = st.executeQuery();
            rs.next();
            return rs.getString("ocupacion");
        }catch (SQLException throwables){
            throwables.printStackTrace();
            return null;
        }
    }
}