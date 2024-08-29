package sv.edu.udb.beans;
public class PersonaBeans {
    int idPersona;
    String nombrePersona;
    int edadPersona;
    String telefonoPersona;
    String sexoPersona;
    int idOcupacion;
    String fechaNacimiento;
    public PersonaBeans(int idPersona, String nombrePersona, int edadPersona,
                        String telefonoPersona, String sexoPersona, int idOcupacion, String
                                fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.edadPersona = edadPersona;
        this.telefonoPersona = telefonoPersona;
        this.sexoPersona = sexoPersona;
        this.idOcupacion = idOcupacion;
        this.fechaNacimiento = fechaNacimiento;
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
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}