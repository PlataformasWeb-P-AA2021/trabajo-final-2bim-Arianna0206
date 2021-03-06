/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete3;

import java.util.ArrayList;
import java.util.Scanner;
import paquete1.Persona;
import paquete1.PlanCelular;
import paquete1.PlanPostPagoMinutos;
import paquete1.PlanPostPagoMegas;
import paquete1.PlanPostPagoMinutosMegas;
import paquete1.PlanPostPagoMinutosMegasEconomico;
import paquete2.EscrituraArchivoSecuencial;
import paquete2.LecturaArchivoSecuencial;

/**
 *
 * @author macbookair
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<PlanCelular> plan = new ArrayList<>();
        String n = "Planes.data";
        String nombre = "";
        String apellidos = "";
        String identificacion = "";
        String ciudad = "";
        String marcaCelular = "";
        String modeloCelular = "";
        int numeroCelular = 0;
        int var = 0;
        while (var != 5) {
            System.out.println("Ingrese el plan que desea.\n1. Plan postPago minutos\n"
                    + "2. Plan postPago megas\n3. Plan postPago minutos megas\n"
                    + "4. Plan postPago minutos megas economico\n5. Salir");
            var = entrada.nextInt();
            if (var >= 1 && var <= 4) {
                entrada.nextLine();
                System.out.println("Ingrese los nombres del cliente");
                nombre = entrada.nextLine();
                System.out.println("Ingrese los apellidos del cliente");
                apellidos = entrada.nextLine();
                System.out.println("Ingrese su identificación ");
                identificacion = entrada.nextLine();
                System.out.println("Ingrese la ciudad en la que reside");
                ciudad = entrada.nextLine();
                System.out.println("Ingrese la marca del celular");
                marcaCelular = entrada.nextLine();
                System.out.println("Ingrese el modelo del celular");
                modeloCelular = entrada.nextLine();
                System.out.println("Ingrese el número del celular");
                numeroCelular = entrada.nextInt();
            }

            switch (var) {
                case 1:
                    PlanPostPagoMinutos(plan, nombre, apellidos, identificacion,
                            ciudad, marcaCelular, modeloCelular, numeroCelular);
                    break;

                case 2:
                    PlanPostPagoMegas(plan, nombre, apellidos, identificacion,
                            ciudad, marcaCelular, modeloCelular, numeroCelular);
                    break;

                case 3:
                    PlanPostPagoMinutosMegas(plan, nombre, apellidos,
                            identificacion, ciudad, marcaCelular, modeloCelular,
                            numeroCelular);
                    break;

                case 4:
                    PlanPostPagoMinutosEconomico(plan, nombre, apellidos,
                            identificacion, ciudad, marcaCelular, modeloCelular,
                            numeroCelular);
                    break;

                case 5:
                    var = 5;
                    break;
            }
        }

        EscrituraArchivoSecuencial archivo = new EscrituraArchivoSecuencial(n);

        for (int i = 0; i < plan.size(); i++) {
            plan.get(i).calcularPagoMensual();
            archivo.establecerRegistro(plan.get(i));
            archivo.establecerSalida();

        }
        archivo.cerrarArchivo();

        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(n);
        lectura.establecerPlanCelular();

        System.out.println(lectura);
        lectura.cerrarArchivo();

    }

    public static void PlanPostPagoMinutos(ArrayList<PlanCelular> plan,
            String nombre, String apellidos, String identificacion,
            String ciudad, String marcaCelular, String modeloCelular,
            int numeroCelular) {
        Scanner entrada = new Scanner(System.in);
        
        Persona p = new Persona(nombre, apellidos, identificacion, ciudad);

        System.out.println("Ingrese los minutos nacionales");
        double minutosNacionales = entrada.nextDouble();
        System.out.println("Ingrese el costo por minuto nacional");
        double costoMinutosNacionales = entrada.nextDouble();
        System.out.println("Ingrese los minutos internacionales");
        double minutosInternacionales = entrada.nextDouble();
        System.out.println("Ingrese el costo por minuto internacional");
        double costoMinutosInternacionales = entrada.nextDouble();

        PlanPostPagoMinutos planpagoMinutos = new PlanPostPagoMinutos(p,
                marcaCelular, modeloCelular, numeroCelular, minutosNacionales,
                costoMinutosNacionales, minutosInternacionales,
                costoMinutosInternacionales);
        plan.add(planpagoMinutos);

    }

    public static void PlanPostPagoMegas(ArrayList<PlanCelular> plan, String nombre,
            String apellidos, String identificacion, String ciudad, 
            String marcaCelular, String modeloCelular, int numeroCelular) {

        Scanner entrada = new Scanner(System.in);
        Persona p = new Persona(nombre, apellidos, identificacion, ciudad);

        System.out.println("Ingrese las megas expresado en gigas");
        double gigas = entrada.nextDouble();
        System.out.println("Ingrese el costo por cada gigas");
        double costoGigas = entrada.nextDouble();
        System.out.println("Ingrese la tarifa base");
        double tarifaBase = entrada.nextDouble();

        PlanPostPagoMegas planpagomegas = new PlanPostPagoMegas(p, marcaCelular,
                modeloCelular, numeroCelular, gigas, costoGigas, tarifaBase);

        plan.add(planpagomegas);

    }

    public static void PlanPostPagoMinutosMegas(ArrayList<PlanCelular> plan,
            String nombre, String apellidos, String identificacion, String ciudad,
            String marcaCelular, String modeloCelular, int numeroCelular) {

        Scanner entrada = new Scanner(System.in);
        Persona p = new Persona(nombre, apellidos, identificacion, ciudad);

        System.out.println("Ingrese los minutos ");
        double minutos = entrada.nextDouble();
        System.out.println("Ingrese el costo por minutos");
        double costoMinutos = entrada.nextDouble();
        System.out.println("Ingrese las megas expresado en gigas");
        double gigas = entrada.nextDouble();
        System.out.println("Ingrese el costo por cada gigas");
        double costoGigas = entrada.nextDouble();

        PlanPostPagoMinutosMegas planminutosmegas = new PlanPostPagoMinutosMegas(p,
                marcaCelular, modeloCelular, numeroCelular, minutos, costoMinutos,
                gigas, costoGigas);

        plan.add(planminutosmegas);

    }

    public static void PlanPostPagoMinutosEconomico(ArrayList<PlanCelular> plan,
            String nombre, String apellidos, String identificacion, String ciudad,
            String marcaCelular, String modeloCelular, int numeroCelular) {
        
        Scanner entrada = new Scanner(System.in);
        Persona p = new Persona(nombre, apellidos, identificacion, ciudad);

        System.out.println("Ingrese los minutos ");
        double minutos = entrada.nextDouble();
        System.out.println("Ingrese el costo por minutos");
        double costoMinutos = entrada.nextDouble();
        System.out.println("Ingrese las megas expresado en gigas");
        double gigas = entrada.nextDouble();
        System.out.println("Ingrese el costo por cada gigas");
        double costoGigas = entrada.nextDouble();
        System.out.println("Ingrese el porcentaje de descuento");
        double porcentajeDescuento = entrada.nextDouble();

        PlanPostPagoMinutosMegasEconomico planmegaseconomico = 
                new PlanPostPagoMinutosMegasEconomico(p, marcaCelular, modeloCelular,
                numeroCelular, minutos, costoMinutos, gigas, costoGigas,
                porcentajeDescuento);

        plan.add(planmegaseconomico);

    }
}
