package co.com.unionsoluciones.apirestservicios.multdatasources;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author rblanco on 14/05/22
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
