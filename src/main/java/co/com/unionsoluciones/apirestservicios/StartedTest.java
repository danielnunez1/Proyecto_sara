package co.com.unionsoluciones.apirestservicios;

import co.com.unionsoluciones.apirestservicios.services.ServiceUsuario;
import co.com.unionsoluciones.apirestservicios.services.ServicioSara;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rblanco on 14/05/22
 **/
//@Component
public class StartedTest implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ServiceUsuario serviceUsuario;

    @Autowired
    private ServicioSara servicioSara;

    @Override
    public void run(String... args) throws Exception {

        List lista = servicioSara.consultarNomina();
        logger.info("Tamanio Nomima = " + lista.size() );
        logger.info( serviceUsuario.getUsuario(1).toString() );

    }
}
