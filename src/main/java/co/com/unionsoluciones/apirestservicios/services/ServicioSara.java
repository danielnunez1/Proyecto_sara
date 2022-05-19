package co.com.unionsoluciones.apirestservicios.services;

import co.com.unionsoluciones.apirestservicios.dtos.NominaEmpleadoDTO;
import co.com.unionsoluciones.apirestservicios.mybatis.mapper.SaraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rblanco on 14/05/22
 **/
@Service
public class ServicioSara {

    @Autowired(required = false)
    private SaraMapper saraMapper;

    public List<NominaEmpleadoDTO> consultarNomina(){
        return saraMapper.consultarNomina();
    }
}
