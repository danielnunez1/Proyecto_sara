package co.com.unionsoluciones.apirestservicios.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.com.unionsoluciones.apirestservicios.models.RolModel;

public interface RolMapper {

	List<RolModel> getRoles();
}
