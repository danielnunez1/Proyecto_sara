package co.com.unionsoluciones.apirestservicios.multdatasources;

import co.com.unionsoluciones.apirestservicios.StringUtilities;
import co.com.unionsoluciones.apirestservicios.anotaciones.DataSourceByToken;
import co.com.unionsoluciones.apirestservicios.security.JwtProvider;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author rblanco on 14/05/22
 **/
@Component
@Aspect
public class DataSourceAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JwtProvider jwtProvider;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* co.com.unionsoluciones.apirestservicios.mybatis.mapper..*(..))" +
            " && @annotation(co.com.unionsoluciones.apirestservicios.anotaciones.DataSourceByToken)")
    public void dataSourcerPuntoDeCorte(){
    }

    @Around("dataSourcerPuntoDeCorte()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint){

        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();

        DataSourceByToken anotation = method.getAnnotation(DataSourceByToken.class);
        if(anotation == null){
            NullPointerException nulo = new NullPointerException("La anotacion @DataSourceByToken debe estar declarada en el metodo: "+method.getName());
            logger.error(nulo.getMessage(), nulo);
            throw nulo;
        }

        DataSourcesEnums dataEnum = anotation.value();
        if(dataEnum.equals( DataSourcesEnums.ANY )){

            boolean tokenValido = false;
            if(request != null){
                String token = StringUtilities.getInstance().getToken( request );
                if(token != null){
                    if(jwtProvider.validateToke(token)){
                        String conexion = jwtProvider.getClaimValueFromKey(token, "conexion");
                        if("sara".equals(conexion)){
                            DataSourceContextHolder.setDataSource(DataSourcesEnums.SARA);
                            tokenValido = true;
                        }else if("sofia".equals(conexion)){
                            DataSourceContextHolder.setDataSource(DataSourcesEnums.SOFIA);
                            tokenValido = true;
                        }
                    }
                }
            }
            if(!tokenValido){
                NullPointerException nulo = new NullPointerException("Si no quiere nada para que lo pide, en el metodo: "+method.getName());
                logger.error(nulo.getMessage(), nulo);
                throw nulo;
            }
        }else if(dataEnum.equals( DataSourcesEnums.SEGURIDAD )){
            DataSourceContextHolder.setDataSource(DataSourcesEnums.SEGURIDAD);
        }else if(dataEnum.equals( DataSourcesEnums.SOFIA )){
            DataSourceContextHolder.setDataSource(DataSourcesEnums.SOFIA);
        }else if(dataEnum.equals( DataSourcesEnums.SARA )){
            DataSourceContextHolder.setDataSource(DataSourcesEnums.SARA);
        }

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            DataSourceContextHolder.resetDataSource();
        }
        return result;
    }

}
