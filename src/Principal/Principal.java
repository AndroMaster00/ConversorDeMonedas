package Principal;

import Clases.Moneda;
import Enums.TiposMoneda;
import Funciones.Convertir;
import ProtocoloHttp.ConsultaCambio;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seleccion = 0;
        Moneda monedaUsuario = new Moneda();
        Moneda monedaSalida = new Moneda();
        ConsultaCambio consulta = new ConsultaCambio();
        Convertir convertir = new Convertir();


        while (seleccion != 7){
            System.out.println("********************\n");
            System.out.println("Elige la conversión a realizar");
            System.out.println("""
                1.- Peso Argentino [ARS] ==> Dólar [USD]
                2.- Dólar [USD] ==> Peso Argentino [ARS]
                3.- Dólar [USD] ==> Peso Chileno [CLP]
                4.- Peso Chileno [CLP] ==> Dólar [USD]
                5.- Peso Colombiano [COP] ==> Peso Chileno [CLP]
                6.- Peso Chileno [CLP] ==> Peso Colombiano [COP]
                7.- Salir 
                """);
            seleccion = scanner.nextInt();
            switch (seleccion){
                case 1:
                    monedaUsuario.setTipo(TiposMoneda.ARS.name());
                    monedaSalida.setTipo(TiposMoneda.USD.name());
                    System.out.println("Ingrese la cantidad a convertir [" + monedaUsuario.getTipo() + "]");
                    monedaUsuario.setValor(scanner.nextDouble());
                    monedaSalida.setValor(convertir.convertir(monedaUsuario.getValor(), consulta.consultaCambio(monedaSalida,monedaUsuario)));
                    break;
                case 2:
                    monedaUsuario.setTipo(TiposMoneda.USD.name());
                    monedaSalida.setTipo(TiposMoneda.ARS.name());
                    System.out.println("Ingrese la cantidad a convertir [" + monedaUsuario.getTipo() + "]");
                    monedaUsuario.setValor(scanner.nextDouble());
                    monedaSalida.setValor(convertir.convertir(monedaUsuario.getValor(), consulta.consultaCambio(monedaSalida,monedaUsuario)));
                    break;
                case 3:
                    monedaUsuario.setTipo(TiposMoneda.USD.name());
                    monedaSalida.setTipo(TiposMoneda.CLP.name());
                    System.out.println("Ingrese la cantidad a convertir [" + monedaUsuario.getTipo() + "]");
                    monedaUsuario.setValor(scanner.nextDouble());
                    monedaSalida.setValor(convertir.convertir(monedaUsuario.getValor(), consulta.consultaCambio(monedaSalida,monedaUsuario)));
                    break;
                case 4:
                    monedaUsuario.setTipo(TiposMoneda.CLP.name());
                    monedaSalida.setTipo(TiposMoneda.USD.name());
                    System.out.println("Ingrese la cantidad a convertir [" + monedaUsuario.getTipo() + "]");
                    monedaUsuario.setValor(scanner.nextDouble());
                    monedaSalida.setValor(convertir.convertir(monedaUsuario.getValor(), consulta.consultaCambio(monedaSalida,monedaUsuario)));
                    break;
                case 5:
                    monedaUsuario.setTipo(TiposMoneda.COP.name());
                    monedaSalida.setTipo(TiposMoneda.CLP.name());
                    System.out.println("Ingrese la cantidad a convertir [" + monedaUsuario.getTipo() + "]");
                    monedaUsuario.setValor(scanner.nextDouble());
                    monedaSalida.setValor(convertir.convertir(monedaUsuario.getValor(), consulta.consultaCambio(monedaSalida,monedaUsuario)));
                    break;
                case 6:
                    monedaUsuario.setTipo(TiposMoneda.CLP.name());
                    monedaSalida.setTipo(TiposMoneda.COP.name());
                    System.out.println("Ingrese la cantidad a convertir [" + monedaUsuario.getTipo() + "]");
                    monedaUsuario.setValor(scanner.nextDouble());
                    monedaSalida.setValor(convertir.convertir(monedaUsuario.getValor(), consulta.consultaCambio(monedaSalida,monedaUsuario)));
                    break;
                case 7:
                    System.out.println("Gracias por utilizar nuestro conversor!");
                    System.out.println("Cerrando conexión...");
                    break;
                default:
                    System.out.println("Elija una opción válida");
            }
            if (seleccion != 7){
                System.out.printf("La conversión de %.2f [%s] a [%s] es: %.2f\n",
                        monedaUsuario.getValor(), monedaUsuario.getTipo(), monedaSalida.getTipo(), monedaSalida.getValor());
            }

        }

    }
}
