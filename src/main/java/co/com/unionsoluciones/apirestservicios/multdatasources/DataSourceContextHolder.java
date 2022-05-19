package co.com.unionsoluciones.apirestservicios.multdatasources;

/**
 * @author rblanco on 14/05/22
 **/
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourcesEnums> CONTEXT_HOLDER = new ThreadLocal<DataSourcesEnums>(){
        @Override
        protected DataSourcesEnums initialValue() {
            return DataSourcesEnums.SARA;
        }
    };

    public static void setDataSource(DataSourcesEnums tipo){
        CONTEXT_HOLDER.set(tipo);
    }
    public static DataSourcesEnums getDataSource(){
        return CONTEXT_HOLDER.get();
    }
    public static void resetDataSource(){
        CONTEXT_HOLDER.set(DataSourcesEnums.SEGURIDAD);
    }
}
