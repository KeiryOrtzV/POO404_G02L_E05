import java.util.Dictionary;

public class Empleado {
    public String nombre;
    double salarioBase;





    public Empleado(String nombre, Double salarioBase) {
            this.nombre = nombre;
            this.salarioBase = salarioBase;

    }


    public double calcularSalario(){
        return salarioBase;
    }

    public void mostrarInfo(){
        System.out.print(nombre + " Su salario es de: " + salarioBase);
    }

    public static class Gerente extends Empleado{
        private double bono;


        public Gerente(String nombre, Double salarioBase, Double bono) {
            super(nombre, salarioBase);
            this.bono = bono;
        }

        public double calcularSalario(){
            return salarioBase + bono;
        }

        public void mostrarInfo(){
            System.out.println("Nombre: "+nombre+ " su salario es: "+salarioBase+ " cuenta con un bono de: "+bono+" , Su salario total es de: "+calcularSalario());
        }



    }


    }












