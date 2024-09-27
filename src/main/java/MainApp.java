import api.IntegrationAPI;
import dto.ConvertDto;
import dto.ConvertUnit;
import java.util.Scanner;

public class MainApp {

  public static void main(String[] args) {
    IntegrationAPI api = new IntegrationAPI();
    Scanner console = new Scanner(System.in);
    boolean active = false;

    while (!active) {
      try {
        int opcion = menu(console);
        active = execOpcions(opcion, console, api);
      } catch (Exception e) {
        System.out.println("Ocurrio un error: " + e.getMessage());
      }
    }
  }

  private static boolean execOpcions(int opcion, Scanner console, IntegrationAPI api) {
    boolean active = false;

    switch (opcion) {
      case 1 -> {
        System.out.print("Ingrese la cantidad a convertir: ");
        Double amount = console.nextDouble();
        ConvertDto response = api.getCurrencyConverter(ConvertUnit.EUR, ConvertUnit.ARS, amount);
        responseTemplate(ConvertUnit.EUR, ConvertUnit.ARS, response, amount);

      }
      case 2 -> {
        System.out.print("Ingrese la cantidad a convertir: ");
        Double amount = console.nextDouble();
        ConvertDto response = api.getCurrencyConverter(ConvertUnit.USD, ConvertUnit.COP, amount);
        responseTemplate(ConvertUnit.USD, ConvertUnit.COP, response, amount);
      }
      case 3 -> {
        System.out.print("Ingrese la cantidad a convertir: ");
        Double amount = console.nextDouble();
        ConvertDto response = api.getCurrencyConverter(ConvertUnit.PEN, ConvertUnit.BRL, amount);
        responseTemplate(ConvertUnit.PEN, ConvertUnit.BRL, response, amount);
      }
      case 4 -> {
        System.out.print("Ingrese la cantidad a convertir: ");
        Double amount = console.nextDouble();
        ConvertDto response = api.getCurrencyConverter(ConvertUnit.EUR, ConvertUnit.COP, amount);
        responseTemplate(ConvertUnit.EUR, ConvertUnit.COP, response, amount);
      }
      case 5 -> {
        System.out.print("Ingrese la cantidad a convertir: ");
        Double amount = console.nextDouble();
        ConvertDto response = api.getCurrencyConverter(ConvertUnit.PEN, ConvertUnit.USD, amount);
        responseTemplate(ConvertUnit.PEN, ConvertUnit.USD, response, amount);
      }
      case 6 -> {
        System.out.print("Ingrese la cantidad a convertir: ");
        Double amount = console.nextDouble();
        ConvertDto response = api.getCurrencyConverter(ConvertUnit.EUR, ConvertUnit.USD, amount);
        responseTemplate(ConvertUnit.EUR, ConvertUnit.USD, response, amount);
      }
      case 7 -> {
        System.out.println("*** Saliendo de la App***");
        System.out.println("Hasta Pronto!!!");
        active = true;
      }
      default -> System.out.println("Opcion Invalida escoja otra");
    }

    return active;
  }

  private static void responseTemplate(ConvertUnit unit, ConvertUnit target, ConvertDto response,
      Double amount) {
    System.out.println("Tasa de Cambio de " + unit.getName() + " de " + target.getName() + " es : "
        + response.conversion_rate());
    System.out.println(amount + " " + unit.getName() + " son " + response.conversion_result() + " "
        + target.getName());
  }

  private static int menu(Scanner console) {
    System.out.print("""
        *** Sistema de Estudiantes ***
        1. Convertir de Euro a Peso Argentino
        2. Convertir de Dolar a Peso Colombiano
        3. Convertir de Soles Peruanos a Real Brasileño
        4. Convertir de Euro a Peso Colombiano
        5. Convertir de Soles a Dolares
        6. Convertir de Euro a Dolares
        7. Salir
        Elige una opcion:\s""");

    return console.nextInt();
  }
}

