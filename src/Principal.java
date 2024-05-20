import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int option = 0;
        String menu = """
                **************************************************
                Bienvenido al Conversor de Moneda con uso de API by David Gomez
                                
                1) Dólar americano a Peso argentino
                2) Peso argentino a Dólar americano
                3) Dólar americano a Real brasileño
                4) Real brasileño a Dólar americano
                5) Dólar americano a Peso colombiano
                6) Peso colombiano a Dólar americano
                7) Salir
                                
                Elija una opción válida:
                **************************************************
                """;
        String base_code, target_code;
        double amount;
        Search mySearch = new Search();

        while (option != 7) {
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if (option == 7) {
                System.out.println("Finalizando la ejecución");
                continue;
            } else if (option < 1 || option > 7) {
                System.out.println("Opción no válida\n");
                continue;
            }
            System.out.println("Ingrese el valor que desea convertir:");
            try {
                amount = scanner.nextDouble();
                if (amount < 0) {
                    System.out.println("Ingrese un valor númerico válido\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor númerico válido\n");
                continue;
            }

            switch (option) {
                case 1:
                    base_code = "USD";
                    target_code = "ARS";
                    mySearch.showResult(base_code, target_code, amount);
                    break;
                case 2:
                    base_code = "ARS";
                    target_code = "USD";
                    mySearch.showResult(base_code, target_code, amount);
                    break;
                case 3:
                    base_code = "USD";
                    target_code = "BRL";
                    mySearch.showResult(base_code, target_code, amount);
                    break;
                case 4:
                    base_code = "BRL";
                    target_code = "USD";
                    mySearch.showResult(base_code, target_code, amount);
                    break;
                case 5:
                    base_code = "USD";
                    target_code = "COP";
                    mySearch.showResult(base_code, target_code, amount);
                    break;
                case 6:
                    base_code = "COP";
                    target_code = "USD";
                    mySearch.showResult(base_code, target_code, amount);
                    break;
            }
        }

    }
}

