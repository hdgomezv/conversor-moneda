package com.aluracursos.conversorapp.principal;
import com.aluracursos.conversorapp.modelos.Convertidor;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner entradaTeclado = new Scanner(System.in);
        Convertidor convertidor = new Convertidor();

        String menu = """
                **************************************************
                Bienvenido al Conversor de Modeda con uso de API
                                
                1) Dólar a Peso Argentino
                2) Peso Argentino a Dólar
                3) Dólar a Real Brasileño
                4) Real Brasileño a Dólar
                5) Dólar a Peso Colombiano
                6) Peso Colombiano a Dólar
                7) Salir
                                
                Elija una opción válida
                **************************************************
                """;


        while (true) {
            System.out.println(menu);

            int opcion = entradaTeclado.nextInt();

            if (opcion == 7) {
                System.out.println("Saliendo del Programa...");
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");

            double monto = entradaTeclado.nextDouble();
            double resultadoConvertido = 0.0;

            switch (opcion) {
                case 1:
                    resultadoConvertido = Convertidor.convertidorUnidades(monto,"USD","ARS");
                    break;
                case 2:
                    resultadoConvertido = Convertidor.convertidorUnidades(monto,"ARS","USD");
                    break;
                case 3:
                    resultadoConvertido = Convertidor.convertidorUnidades(monto,"USD","BRL");
                    break;
                case 4:
                    resultadoConvertido = Convertidor.convertidorUnidades(monto,"BRL","USD");
                    break;
                case 5:
                    resultadoConvertido = Convertidor.convertidorUnidades(monto,"USD","COP");
                    break;
                case 6:
                    resultadoConvertido = Convertidor.convertidorUnidades(monto,"COP","USD");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }

            System.out.println("Resultado: " + resultadoConvertido);
            System.out.println();
        }

        entradaTeclado.close();
    }
}
