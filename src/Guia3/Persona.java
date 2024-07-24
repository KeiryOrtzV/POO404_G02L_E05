
package Guia3;


import javax.swing.*;

public class Persona {
    //Atributos
    private String nombre;
    private String apellido;
    private String edad;
    //Constructor por sin parametros
    //Se utiliza al instaciar el oojeto
    public Persona(){
                nombre="Rafael";
        apellido="Torres";
        edad="23";
    }
    //Constructor con parametros
    public Persona(String nombre,String apellido,String edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }
    //Permite definir datos a los atributos
    public void ingresoDatos()
    {
        nombre= JOptionPane.showInputDialog("Ingrese el Nombre");
        apellido=JOptionPane.showInputDialog("Ingrese el Apellido");
        edad=JOptionPane.showInputDialog("Ingrese su edad");
    }
    //Permite imprimir los valores de los atributos
    public void mostrarDatos(){
        System.out.println("Su nombre es: "+nombre);
        System.out.println("Su Apellido es: "+apellido);
        System.out.println("Su edad es: "+edad);
        System.out.println("****************************");
    }
    public static void main(String args[]) {
        Persona obj1=new Persona();//Instacia del objeto obj1
        //Instancia del objeto p2
        Persona obj2=new Persona("Manuel", "Valdez", "25");
        //LLamamos a el método mostrar datos de obj1
        obj1.mostrarDatos();
        //Cambiamor valor a los atributos de obj1
        obj1.ingresoDatos();
        //LLamamos a el método mostrardatos de obj1
        obj1.mostrarDatos();
        //LLamamos a el metodomostrardatos de obj2
        obj2.mostrarDatos();
        obj1.apellido="Sanchez";
        obj1.mostrarDatos();
    }
}

