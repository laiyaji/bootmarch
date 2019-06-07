/*package spring.boot.example.bootmarch.config;
//写好springboot 的application.properties配置文件，springboot自动注入数据源
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value = { "classpath:jdbc.properties" })
@ComponentScan(basePackages = "spring.boot.example.bootmarch")
//@ImportResource(value = "classpath:dubbo/dubbo-consumer.xml")
@SpringBootApplication
public class DataSourceConfig {
	//extends SpringBootServletInitializer
	@Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;
    
    @Value("${druid.pool.size.init}")
    private int initialSize;
    
    @Value("${druid.pool.size.min}")
    private int minIdle;
    
    @Value("${druid.pool.size.max}")
    private int maxActive;
    

    @Bean(initMethod="init",destroyMethod = "close")
    public DataSource dataSource() throws SQLException {
    	DruidDataSource druidDataSource = new DruidDataSource();
    	druidDataSource.setDriverClassName(jdbcDriverClassName);
    	druidDataSource.setUrl(jdbcUrl);
    	druidDataSource.setUsername(jdbcUsername);
    	druidDataSource.setPassword(jdbcUsername);
    	// 配置初始化大小
    	druidDataSource.setInitialSize(initialSize);
    	// 最小
    	druidDataSource.setMinIdle(minIdle);
    	// 最大
    	druidDataSource.setMaxActive(maxActive);
    	// 配置监控统计拦截的filters，wall用于防止sql注入，stat用于统计分析 
    	druidDataSource.setFilters("wall,stat");
    	
        return druidDataSource;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DataSourceConfig.class);
    }
}
*/