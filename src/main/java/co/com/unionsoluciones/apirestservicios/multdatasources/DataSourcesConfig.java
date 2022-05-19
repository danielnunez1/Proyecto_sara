package co.com.unionsoluciones.apirestservicios.multdatasources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rblanco on 14/05/22
 **/
@Configuration
@MapperScan(basePackages = "co.com.unionsoluciones.apirestservicios.mybatis.mapper")
public class DataSourcesConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Bean(name = "dsSeguridad")
    @ConfigurationProperties("spring.datasource.seguridad")
    DataSource dsSeguridad() {
        DataSource ds = DataSourceBuilder.create().build();
        return ds;
    }

    @Bean(name = "dsSara")
    @ConfigurationProperties("spring.datasource.sara")
    DataSource dsSara() {
        DataSource ds = DataSourceBuilder.create().build();
        return ds;
    }

    @Bean(name = "dsSofia")
    @ConfigurationProperties("spring.datasource.sofia")
    DataSource dsSofia() {
        DataSource ds = DataSourceBuilder.create().build();
        return ds;
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(
            @Qualifier("dsSeguridad") DataSource dataSourceSeguridad,
            @Qualifier("dsSara") DataSource dataSourceSara,
            @Qualifier("dsSofia") DataSource dataSourceSofia
    ) {
        Map<Object, Object> mapaDatasource = new HashMap<>();
        mapaDatasource.put(DataSourcesEnums.SEGURIDAD, dataSourceSeguridad);
        mapaDatasource.put(DataSourcesEnums.SOFIA, dataSourceSofia);
        mapaDatasource.put(DataSourcesEnums.SARA, dataSourceSara);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(mapaDatasource);
        dynamicDataSource.setDefaultTargetDataSource(dataSourceSara);

        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory sessionFactory(
            @Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource
    ) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));

        return sqlSessionFactoryBean.getObject();
    }
}
