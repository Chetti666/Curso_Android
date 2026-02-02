import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class CuentaTest {
    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        // Se ejecuta antes de cada test para tener una cuenta limpia
        cuenta = new Cuenta(123, "Test User", 1000.0);
    }

    @Test
    void testDepositar() {
        cuenta.depositar(500.0);
        // Comprobamos que 1000 + 500 = 1500
        assertEquals(1500.0, cuenta.getSaldo(), "El depósito no sumó correctamente");
    }

    @Test
    void testRetirarExitoso() {
        cuenta.retirar(300.0);
        // Comprobamos que 1000 - 300 = 700
        assertEquals(700.0, cuenta.getSaldo(), "El retiro no restó correctamente");
    }

    @Test
    void testRetirarSinFondos() {
        cuenta.retirar(2000.0); // Intento retirar más de lo que hay
        // El saldo debería seguir siendo 1000.0
        assertEquals(1000.0, cuenta.getSaldo(), "El saldo cambió a pesar de no tener fondos");
    }

    @Test
    void testDepositarNegativo() {
        cuenta.depositar(-500.0);
        // El saldo no debería cambiar
        assertEquals(1000.0, cuenta.getSaldo(), "Se aceptó un depósito negativo");
    }
}