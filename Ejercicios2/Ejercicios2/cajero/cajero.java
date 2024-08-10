package cajero;

import java.util.InputMismatchException;//solo solicta q8e sean datos de nuemeros
import java.util.Scanner;//ola

public class cajero {
    public static void main(String[] args) {
        int[][] cuentas = {
                {1000001, 400},
                {1000002, 200},
                {1000004, 500},
                {1000006, 600},
                {1000008, 700},
                {10000010, 800},
                {10000012, 900},
                {10000014, 1000},
                {10000016, 1200},
                {10000018, 1400},
                {10000020, 1800},
                {11111111, 0000},
        };
        Scanner scanner = new Scanner(System.in);
        int numeroCuentaBancaria = 0;
        boolean cuentaValida = false;
        while (!cuentaValida) {
            try {System.out.println("Ingrese el número de cuenta bancaria:");
                numeroCuentaBancaria = scanner.nextInt();
                cuentaValida = true;
            } catch (InputMismatchException e) {System.out.println("Por favor, ingrese el número de cuenta válido.");
                scanner.next();}}
        boolean cuentaVerificada = false;
        int saldoCuenta = -1;
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i][0] == numeroCuentaBancaria) {
                cuentaVerificada = true;
                saldoCuenta = i;
                break;}}
        if (cuentaVerificada) {
            System.out.println("Bienvenido al banco FCB Cajero .");
            boolean salir = false;
            while (!salir) {
                System.out.println("\nSeleccione una de las opciones:");
                System.out.println("1. Consulta de saldo");
                System.out.println("2. Retiro de fondos");
                System.out.println("3. Consignaciones");
                System.out.println("4. Transferencias");
                System.out.println("5. Salir");
                int opcion = 0;
                boolean opcionValida = false;
                while (!opcionValida) {
                    try {opcion = scanner.nextInt();
                        opcionValida = true;
                    } catch (InputMismatchException e) {System.out.println("Por favor, seleccione una opción válida.");
                        scanner.next();
                    }
                }

                switch (opcion) {
                    case 1: System.out.println("El saldo actual de su cuenta " + numeroCuentaBancaria + " es de $" + cuentas[saldoCuenta][1]);
                        break;
                    case 2: System.out.println("Ingrese la cantidad a retirar:");
                        int retiro = 0;
                        boolean retiroValido = false;
                        while (!retiroValido) {
                            try {retiro = scanner.nextInt();
                                retiroValido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Por favor, ingrese una cantidad válida.");
                                scanner.next();}}
                        if (retiro <= cuentas[saldoCuenta][1]) {
                            cuentas[saldoCuenta][1] -= retiro;
                            System.out.println("El saldo actual de la cuenta " + numeroCuentaBancaria + " es de $" + cuentas[saldoCuenta][1]);
                        } else {
                            System.out.println("Fondos insuficientes.");
                        }
                        break;
                    case 3: System.out.println("Ingrese la cantidad a consignar:");
                        int consignacion = 0;
                        boolean consignacionValida = false;
                        while (!consignacionValida) {
                            try {consignacion = scanner.nextInt();
                                consignacionValida = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Por favor, ingrese una cantidad válida.");
                                scanner.next();
                            }}
                        cuentas[saldoCuenta][1] += consignacion;
                        System.out.println("El saldo actual de la cuenta " + numeroCuentaBancaria + " es de $" + cuentas[saldoCuenta][1]);
                        break;
                    case 4: System.out.println("Ingrese el número de cuenta destino:");
                        int cuentaDestino = 0;
                        boolean cuentaDestinoValida = false;
                        while (!cuentaDestinoValida) {
                            try {cuentaDestino = scanner.nextInt();
                                cuentaDestinoValida = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Por favor, ingrese un número de cuenta válido.");
                                scanner.next();
                            }}
                        System.out.println("Ingrese la cantidad a transferir:");
                        int transferencia = 0;
                        boolean transferenciaValida = false;
                        while (!transferenciaValida) {
                            try {transferencia = scanner.nextInt();
                                transferenciaValida = true;
                            } catch (InputMismatchException e) {System.out.println("Por favor, ingrese una cantidad válida.");
                                scanner.next();}
                        }boolean cuentaDestinoEncontrada = false;
                        for (int i = 0; i < cuentas.length; i++) {
                            if (cuentas[i][0] == cuentaDestino) {
                                cuentaDestinoEncontrada = true;
                                if (transferencia <= cuentas[saldoCuenta][1]) {cuentas[saldoCuenta][1] -= transferencia;
                                    cuentas[i][1] += transferencia;
                                    System.out.println("El saldo actual de la cuenta " + numeroCuentaBancaria + " es de $" + cuentas[saldoCuenta][1]);
                                } else {
                                    System.out.println("Fondos insuficientes.");
                                }
                                break;}
                        }if (!cuentaDestinoEncontrada) {
                            System.out.println("Cuenta destino no encontrada.");}
                        break;
                    case 5: salir = true;
                        System.out.println("Gracias por usar el banco FCB su cajero de confianza.");
                        break;
                    default: System.out.println("Opción no válida. Por favor, intente de nuevo o mas trade.");
                }}
        } else {
            System.out.println("Su Cuenta no se encontrada. Por favor, intente de nuevo o mas tarde .");
        }scanner.close();
    }}