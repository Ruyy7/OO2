import ar.edu.unlp.info.oo2.*;
import ar.edu.unlp.info.oo2.estados.Aceptado;
import ar.edu.unlp.info.oo2.estados.Finalizado;
import ar.edu.unlp.info.oo2.prestamos.Prestamo;
import ar.edu.unlp.info.oo2.prestamos.Simple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParcialTest {
    Banco banco;
    Cliente ramon;
    Prestamo prestamo;

    @BeforeEach
    void setUp(){
        banco = new Banco(1.05);
        ramon = banco.registrarCliente("Ramon",5000);
    }

    @Test
    public void TestConsigna(){
        prestamo = ramon.solcitarPrestamoSimple(100,10,banco);
        assertTrue(prestamo.getState() instanceof Aceptado);
        prestamo.pagarCuotaPrestamo();
        assertEquals(9,prestamo.calcularCuotasRestantes());
        assertEquals(10.5,prestamo.calcularValorCuota());
        for (int i = 0; i<9;i++){
            prestamo.pagarCuotaPrestamo();
        }
        assertTrue(prestamo.getState() instanceof Finalizado);
        assertEquals(0,prestamo.gastosCancelacion());
    }
}
