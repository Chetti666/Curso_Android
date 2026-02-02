/**
 * Interface que define las operaciones bancarias básicas
 * que debe implementar cualquier clase de gestión de cuentas
 */
public interface IOperaciones {
    
    /**
     * Deposita un monto en la cuenta
     * @param monto Cantidad de dinero a depositar (debe ser > 0)
     */
    void depositar(double monto);
    
    /**
     * Retira un monto de la cuenta
     * @param monto Cantidad de dinero a retirar (debe ser > 0 y <= saldo)
     */
    void retirar(double monto);
    
    /**
     * Obtiene el saldo actual de la cuenta
     * @return Saldo en CLP (Pesos Chilenos)
     */
    double getSaldo();
    
    /**
     * Muestra el estado actual de la cuenta
     * Incluye: número de cuenta, titular y saldo en CLP/USD
     */
    void mostrarEstado();
}
