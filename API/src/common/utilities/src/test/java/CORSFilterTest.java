import com.ucab.cmcapp.common.util.CORSFilter;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilterTest {

    @Test
    public void testCORSFilter() throws IOException, ServletException {
        // Crear un objeto CORSFilter
        CORSFilter filter = new CORSFilter();

        // Crear objetos mock para ServletRequest, ServletResponse y FilterChain
        ServletRequest request = Mockito.mock(ServletRequest.class);
        ServletResponse response = Mockito.mock(HttpServletResponse.class);
        FilterChain chain = Mockito.mock(FilterChain.class);

        // Crear un objeto FilterConfig mock
        FilterConfig config = Mockito.mock(FilterConfig.class);

        // Inicializar el filtro
        filter.init(config);

        // Llamar el método doFilter con los objetos mock
        filter.doFilter(request, response, chain);

        // Verificar que se hayan configurado correctamente los encabezados CORS
        Mockito.verify((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
        Mockito.verify((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        Mockito.verify((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        // Destruir el filtro
        filter.destroy();
    }
}
