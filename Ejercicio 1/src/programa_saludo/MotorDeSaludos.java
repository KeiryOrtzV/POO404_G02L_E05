package programa_saludo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MotorDeSaludos {
    public static void main(String[] args) {            //seria como el punto de entrada del programa
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su sexo (masculino/femenino): ");
        String sexo = scanner.nextLine();

        String fechaNacimiento;
        do {
            System.out.print("Ingrese su fecha de nacimiento (dd-MM-yyyy): ");
            fechaNacimiento = scanner.nextLine();
        } while (!validarFecha(fechaNacimiento));

        int edad = calcularEdad(fechaNacimiento); // se utiliza esTA FUNCION para calcular la edad



        // Saludo según edad y sexo

        String saludo;
        if (edad >= 30) {
            saludo = "Buenos días " + (sexo.equalsIgnoreCase("masculino") ? "Mr." : "Ms.") + " " + apellido + ".";
        } else {
            saludo = "Hola amigo/a " + nombre + ".";
        }

        System.out.println(saludo + " Actualmente tienes " + edad + " años.");
    }


    private static boolean validarFecha(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false); // Desactivar la interpretación flexible de fechas

        try {
            Date fechaDate = sdf.parse(fecha);
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // edad
    private static int calcularEdad(String fechaNacimiento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fechaNac = sdf.parse(fechaNacimiento);
            Date hoy = new Date();

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(fechaNac);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(hoy);

            int edad = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
            if (cal2.get(Calendar.MONTH) < cal1.get(Calendar.MONTH)
                    || (cal2.get(Calendar.MONTH) == cal1.get(Calendar.MONTH) && cal2.get(Calendar.DATE) < cal1.get(Calendar.DATE))) {
                edad--;
            }
            return edad;
        } catch (ParseException e) {
            return -1; // Error al calcular la edad jaja
        }
    }
}