/* -- TAREA CAJERO AUTOMÁTICO
    * Versión con menú de opciones
    * y repetición hasta salir -- */

package org.example;

import java.util.Scanner;

public class CajeroAutomatico {

    // Saldo actual en la cuenta
    private double saldo;

    public CajeroAutomatico() {

        // Inicializar el saldo en 0
        saldo = 0.0;
    }

    public void ingresar(double cantidad) {

        // Sumar la cantidad ingresada al saldo actual
        saldo += cantidad;
    }

    public void retirar(double cantidad) {

        // Verificar si hay saldo suficiente para el retiro
        if (saldo >= cantidad) {

            // Restar la cantidad especificada al saldo actual
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Saldo restante: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

    public double consultarSaldo() {

        // Devolver el saldo actual
        return saldo;
    }

    public static void main(String[] args) {

        // Instancia de CajeroAutomatico
        CajeroAutomatico cajero = new CajeroAutomatico();

        // Scanner para leer la entrada de datos
        Scanner scanner = new Scanner(System.in);

        // Variable para almacenar la opción ingresada
        String opcion;

        System.out.println("Bienvenido al Cajero Automático");

        do {
            // Mostrar opciones
            System.out.println("\nIngrese una opción: ");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Consultar Saldo");
            System.out.println("0. Salir");

            // Leer la opción ingresada
            opcion = scanner.nextLine();

            switch (opcion) {

                // Ingresar dinero
                case "1" -> {
                    System.out.print("Ingrese el monto a depositar: ");

                    // Leer el monto a depositar
                    double montoIngreso = scanner.nextDouble();

                    // Llamar al método ingresar del cajero
                    cajero.ingresar(montoIngreso);
                }

                // Retirar dinero
                case "2" -> {
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetiro = scanner.nextDouble();

                    // Llamar al método retirar
                    cajero.retirar(montoRetiro);
                }

                // Consultar saldo
                case "3" -> {

                    // Obtener el saldo actual del cajero
                    double saldoActual = cajero.consultarSaldo();
                    System.out.println("Saldo actual: " + saldoActual);
                }

                // Salir
                case "0" -> System.out.println("Saliendo del Cajero Automático...");

                // Si se ingresa otro número
                default -> System.out.println("Opción no válida.");
            }

            // Limpiar el almacenamiento de scanner después de cada lectura
            scanner.nextLine();

            // Seguir mostrando el menú hasta que se ingrese la opción de salir
        } while (!opcion.equals("0"));
    }
}

