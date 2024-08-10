package programa_saludo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MotorDeSaludos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su sexo (masculino o femenino): ");
        String sexo = scanner.nextLine();

        String fechaNacimiento;
        do {
            System.out.print("Ingrese su fecha de nacimiento (dd-MM--aaaa): ");
            fechaNacimiento = scanner.nextLine();
        } while (!validarFecha(fechaNacimiento));

        int edad = calcularEdad(fechaNacimiento);

        // Saludo según edad y sexo

        String saludo;
        if (edad >= 30) {
            saludo = "Buenos días " + (sexo.equalsIgnoreCase("masculino") ? "Mr." : "Ms.") + " " + apellido + ".";
        } else {
            saludo = "Hola amigo/a " + nombre + ".";
        }

        System.out.println(saludo + " Actualmente tienes " + edad + " años.");




        if (esBisiesto(fechaNacimiento)) {
            System.out.println("El año en que naciste es bisiesto.");
        } else {
            System.out.println("El año en que naciste no es bisiesto.");
        }


        System.out.println("Naciste en un día " + obtenerDiaSemana(fechaNacimiento) + ".");
    }

    private static boolean validarFecha(String fecha) {

        if (!Pattern.matches("\\d{2}-\\d{2}-\\d{4}", fecha)) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static int calcularEdad(String fechaNacimiento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fechaNac = sdf.parse(fechaNacimiento);
            Calendar calNac = Calendar.getInstance();
            calNac.setTime(fechaNac);

            Calendar hoy = Calendar.getInstance();
            int edad = hoy.get(Calendar.YEAR) - calNac.get(Calendar.YEAR);

            if (hoy.get(Calendar.DAY_OF_YEAR) < calNac.get(Calendar.DAY_OF_YEAR)) {
                edad--;
            }

            return edad;
        } catch (ParseException e) {
            return -1;
        }
    }

    private static boolean esBisiesto(String fechaNacimiento) {
        try {
            int anio = Integer.parseInt(fechaNacimiento.split("-")[2]);
            return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String obtenerDiaSemana(String fechaNacimiento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fechaNac = sdf.parse(fechaNacimiento);
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaNac);
            String[] dias = {"domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado"};
            return dias[cal.get(Calendar.DAY_OF_WEEK) - 1];
        } catch (ParseException e) {
            return "desconocido";
        }
    }
}