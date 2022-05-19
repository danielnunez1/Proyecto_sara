package co.com.unionsoluciones.apirestservicios.mybatis.mapper;

import co.com.unionsoluciones.apirestservicios.anotaciones.DataSourceByToken;
import co.com.unionsoluciones.apirestservicios.models.UsuarioModel;
import co.com.unionsoluciones.apirestservicios.multdatasources.DataSourcesEnums;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author rblanco on 29/04/22
 **/
public interface UsuarioMapper {

    @DataSourceByToken(value = DataSourcesEnums.SEGURIDAD)
    @Select("SELECT * FROM usuario")
    List<UsuarioModel> getUsuarios();

    @DataSourceByToken(value = DataSourcesEnums.SEGURIDAD)
    @Select("SELECT * FROM usuario WHERE id = #{idd}")
    UsuarioModel getUsuario(@Param("idd") Integer idd2);

    @DataSourceByToken(value = DataSourcesEnums.SEGURIDAD)
    UsuarioModel myQueryByNombre(@Param("nombreParametro") String nombre);

    @DataSourceByToken(value = DataSourcesEnums.SEGURIDAD)
    Integer lastIdUsuario();

    @DataSourceByToken(value = DataSourcesEnums.SEGURIDAD)
    void insert(
            @Param("id") Integer idPk,
            @Param("nombre") String nombre,
            @Param("apellido") String apellidos,
            @Param("empresa") String empresa,
            @Param("usuario") String usuario,
            @Param("clave") String clave,
            @Param("roles") String roles,
            @Param("estado") String estado,
            @Param("conexion") String conexion
    );

    @DataSourceByToken(value = DataSourcesEnums.SEGURIDAD)
    UsuarioModel myQueryByUsuario(@Param("usuarioParametro") String usuario);

    @DataSourceByToken(value = DataSourcesEnums.SEGURIDAD)
    List<UsuarioModel> myQueryByIdUsuarioHijo(Integer limInferior, Integer limSuperior);

}
