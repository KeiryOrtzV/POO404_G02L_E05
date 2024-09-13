package sv.edu.udb.persona;

import java.sql.*;
public class VerPersona {
    public VerPersona()
    {
// Se utiliza un try por los posibles errores de MySQL
        try
        {
//obtenemos el driver de para mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
// Se obtiene una conexión con la base de datos.
            Connection conexion = DriverManager.getConnection (
                    "jdbc:mysql://localhost/personabdd","root", "");
// IMPORTANTE: EL CAMPO PASSWORD POR DEFECTO DEBE IR EN BLANCO,
// DEBE ASIGNAR EL PASSWORD CORRECTO
// Permite ejecutar sentencias SQL sin parámetros
            Statement s = conexion.createStatement();
// Contiene la tabla resultado de la pregunta SQL que se haya realizado
            ResultSet rs = s.executeQuery ("select * from persona");
//Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next())
            {
                System.out.println ("ID: "+rs.getInt("id_persona")+
                        "\nNombre: "+rs.getString("nombre_persona")+
                        "\nEdad: "+rs.getString("edad_persona")+
                        "\nTelefono: "+rs.getString("telefono_persona"));
                System.out.println("**********************************");
            }
// Se cierra la conexión con la base de datos. NUNCA OLVIDE CERRARLA
            conexion.close();
        }
        catch (ClassNotFoundException e1) {
//Error si no puedo leer el driver de MySQL
            System.out.println("ERROR:No encuentro el driver de la BD: "+e1.getMessage());
        }
        catch (SQLException e2) {
//Error SQL: login/passwdó sentencia sqlerronea
            System.out.println("ERROR:Fallo en SQL: "+e2.getMessage());
        }
    }
    /**
     * Método principal, instancia una clase PruebaMySQL
     *
     * @paramargs the command line arguments
     */
    public static void main(String[] args)
    {
        new VerPersona();
    }
}