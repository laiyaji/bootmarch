package spring.boot.example.bootmarch.config;


import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // @Configuration用于申明一个配置文件，相当于一个xml文件
@AutoConfigureAfter(MyBatisConfig.class) //保证在MyBatisConfig实例化之后再实例化该类
public class MapperScannerConfig {
    
    // mapper接口的扫描器
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // mybatis面向接口编程,给出需要扫描的Dao接口
        mapperScannerConfigurer.setBasePackage("spring.boot.example.bootmarch.dao");
        return mapperScannerConfigurer;
    }


}
