package utilities;

import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import com.ucab.cmcapp.logic.dtos.utilities.calcularDistanciaSeparacionDto;
import org.junit.Assert;
import org.junit.Test;

public class calcularDistanciaSeparacionDtoTest {

    @Test
    public void testCalcularDistanciaSeperacion() {
        calcularDistanciaSeparacionDto dto = new calcularDistanciaSeparacionDto();

        Historico_UsuarioDto usuario1 = new Historico_UsuarioDto();
        usuario1.set_latitud(10.0);
        usuario1.set_longitud(20.0);

        Historico_UsuarioDto usuario2 = new Historico_UsuarioDto();
        usuario2.set_latitud(30.0);
        usuario2.set_longitud(40.0);

        double distancia = dto.calcularDistanciaSeperacion(usuario1, usuario2);

        // Verificar que la distancia calculada sea mayor a cero
        Assert.assertTrue(distancia > 0);
    }
}
