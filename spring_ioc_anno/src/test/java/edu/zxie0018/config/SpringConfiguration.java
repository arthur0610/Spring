package edu.zxie0018.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//标志该类是Spring的核心配置类
@Configuration
//<!--    configure component scanner-->
//<context:component-scan base-package="edu.zxie0018"/>
@ComponentScan("edu.zxie0018")

@Import({DataSourseConfiguration.class, })
public class SpringConfiguration {


}
