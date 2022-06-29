package io.redick.quarkus.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * @author Redick01
 */
@ApplicationScoped
@Startup
public class MybatisConfig {

    @Inject
    SqlSessionFactory sqlSessionFactory;

    void startup(@Observes StartupEvent event) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
    }
}
