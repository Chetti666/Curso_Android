import java.util.Scanner;

public class GestionBilletera {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Cuenta billetera1 = null;
        int opcion = 0;
        double tasaDolar = 900.0; // Valor base

        do {
            System.out.println("\n===== WALLET MULTIMONEDA =====");
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Ver Saldo (CLP/USD)");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Calculadora de Conversión");
            System.out.println("6. Salir");
            System.out.print("Seleccione: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1: // Para cuenta nueva o ya creada
                    System.out.print("Titular: ");
                    teclado.nextLine(); 
                    String nombre = teclado.nextLine();
                    System.out.print("Saldo inicial (CLP): ");
                    double saldoIni = teclado.nextDouble();
                    billetera1 = new Cuenta(123456, nombre, saldoIni);
                    break;
                case 2: // Muestra el saldo
                    if (billetera1 != null) billetera1.mostrarEstado();
                    else System.out.println("Cree una cuenta primero.");
                    break;
                    
                case 3:
                    if (billetera1 != null) {
                        System.out.print("Monto a depositar: ");
                        double dep = teclado.nextDouble();
                        billetera1.depositar(dep);
                    } else {
                        System.out.println("Error: No hay cuenta activa.");
                    }
                    break;

                case 4:
                    if (billetera1 != null) {
                        System.out.print("Monto a retirar: ");
                        double ret = teclado.nextDouble();
                        billetera1.retirar(ret);
                    } else {
                        System.out.println("Error: No hay cuenta activa.");
                    }
                    break;
                case 5:
                    // Lógica de conversión rápida
                    System.out.println("\n--- CALCULADORA ---");
                    System.out.println("1. CLP a USD");
                    System.out.println("2. USD a CLP");
                    int subOp = teclado.nextInt();
                    System.out.print("Monto a convertir: ");
                    double monto = teclado.nextDouble();
                    
                    if(subOp == 1) {
                        System.out.printf("Resultado: $%.2f USD%n", (monto / tasaDolar));
                    } else {
                        System.out.printf("Resultado: $%.0f CLP%n", (monto * tasaDolar));
                    }
                    break;
                case 6:
                    System.out.println("Cerrando Wallet...");
                    break;
            }
        } while (opcion != 6);
        teclado.close();
    }
}