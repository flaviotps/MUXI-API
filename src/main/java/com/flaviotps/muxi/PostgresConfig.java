package com.flaviotps.muxi;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class PostgresConfig {


    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI("postgres://vskobfrvqwdhuf:0dd2f1c9324554c2d7cfba425d1ac4f8da2168dcc6c75f539aed2a749c7a6ec2@ec2-107-22-162-8.compute-1.amazonaws.com:5432/detsec47qo4c22");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }


}
