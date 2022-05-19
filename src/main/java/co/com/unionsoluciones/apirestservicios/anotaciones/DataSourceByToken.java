package co.com.unionsoluciones.apirestservicios.anotaciones;

import co.com.unionsoluciones.apirestservicios.multdatasources.DataSourcesEnums;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rblanco on 14/05/22
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSourceByToken {

    DataSourcesEnums value() default DataSourcesEnums.ANY;

}
