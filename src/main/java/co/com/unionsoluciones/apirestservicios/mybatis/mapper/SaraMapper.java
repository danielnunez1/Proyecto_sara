package co.com.unionsoluciones.apirestservicios.mybatis.mapper;

import co.com.unionsoluciones.apirestservicios.anotaciones.DataSourceByToken;
import co.com.unionsoluciones.apirestservicios.dtos.NominaEmpleadoDTO;
import co.com.unionsoluciones.apirestservicios.multdatasources.DataSourcesEnums;

import java.util.List;

/**
 * @author rblanco on 14/05/22
 **/
public interface SaraMapper {

    @DataSourceByToken
    List<NominaEmpleadoDTO> consultarNomina();

}
