public class Empresa {
    public static void main(String[] args) {
       Empleado empleado = new Empleado("Carmen A", 300.0);
       Empleado.Gerente gerente = new Empleado.Gerente("Jose C", 1500.0, 500.0);

        System.out.println("Informacion del empleado: ");
        empleado.mostrarInfo();

        System.out.println(" Informacion del Gerente: ");
        gerente.mostrarInfo();

    }


}
