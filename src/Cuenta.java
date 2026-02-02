public class Cuenta implements IOperaciones {
    private int numeroCuenta;
    private String titular;
    private double saldo; // Saldo en Pesos Chilenos (CLP)
    
    // Definimos un valor del dólar aproximado
    private static final double VALOR_DOLAR = 900.0; 

    public Cuenta(int numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    // Métodos de transacción
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println(">>> Depósito exitoso.");
        }
    }
    
    // Métodos para retirar o girar
    public void retirar(double monto) {
        if (monto <= saldo && monto > 0) {
            this.saldo -= monto;
            System.out.println(">>> Retiro exitoso.");
        } else {
            System.out.println("Error: Fondos insuficientes.");
        }
    }
    
    // Métodos para mostrar el saldo
    public void mostrarEstado() {
        double saldoUSD = this.saldo / VALOR_DOLAR;
        System.out.println("\n--- ESTADO DE CUENTA ---");
        System.out.println("N° de Cuenta: " + this.numeroCuenta); 
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo CLP: $" + (int)this.saldo);
        System.out.printf("Saldo USD: $%.2f%n", saldoUSD);
        System.out.println("------------------------");
    }
    
    public double getSaldo() {
        return this.saldo;
    }
}