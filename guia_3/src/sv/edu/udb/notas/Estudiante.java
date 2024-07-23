package sv.edu.udb.notas;
public class Estudiante {
    String nombre;
    String apellido;
    private double nota1;
    private double nota2;
    private double nota3;
    //Constructor
    Estudiante(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }
    //Definicion de Setters y Getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
//Nota validada
        if(nota1>=0 && nota1 <=10){
            this.nota1 = nota1;
        }else{
            this.nota1 = 0;
            System.out.println("Nota no valida!!! ("+ nota1 +")");
        }
    }
    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
//Nota validada
        if(nota2>=0 && nota2 <=10){
            this.nota2 = nota2;
        }else{
            this.nota2 = 0;
            System.out.println("Nota no valida!!! ("+ nota2 +")");
        }
    }
    public double getNota3() {
        return nota3;
    }
    public void setNota3(double nota3) {
//Nota validada
        if(nota3>=0 && nota3 <=10){
            this.nota3 = nota3;
        }else{
            this.nota3 = 0;
            System.out.println("Nota no valida!!! ("+ nota3 +")");
        }
    }
}