/************************************************************************************************************
 * Class Name :  InitConfiguration.java
 * Description:  This class initialize the application's root configurations.
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.zig.pso.utility.PropertyReader;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zig.pso")
@PropertySource("classpath:application.properties")
public class InitConfiguration extends WebMvcConfigurerAdapter
{
    private static final String EMAIL_HOST = "emailHost";
    private static final String EMAIL_SMTP_AUTH = "emailSMTPauth";
    private static final String MAIL_DEBUG = "mailDebug";
    private static final String TRANSPORT_PROTOCOL = "transportProtocol";
    
    @Autowired
    private Environment env;

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException
    {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();

        // Set the maximum allowed size (in bytes) for each individual file.
        resolver.setMaxUploadSizePerFile(5242880);// 5MB

        // You may also set other available properties.

        return resolver;
    }
    
    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
 
        Properties prop = PropertyReader.getAppProperties();
        
        mailSender.setHost(String.valueOf(prop.get(EMAIL_HOST)));
       /* mailSender.setPort(587);*/
        /*mailSender.setUsername("your-email");
        mailSender.setPassword("your-password");*/
 
        Properties javaMailProperties = new Properties();
        //javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", prop.get(EMAIL_SMTP_AUTH));
        javaMailProperties.put("mail.transport.protocol", prop.get(TRANSPORT_PROTOCOL));
        javaMailProperties.put("mail.debug", prop.get(MAIL_DEBUG));
 
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry)
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
