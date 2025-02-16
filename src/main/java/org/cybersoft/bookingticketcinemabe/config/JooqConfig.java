package org.cybersoft.bookingticketcinemabe.config;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
public class JooqConfig {
    private final DataSource dataSource;

    @Bean
    public DSLContext dslContext() {
        return new DefaultDSLContext(jooqConfiguration());
    }

    @Bean
    public DefaultConfiguration jooqConfiguration() {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.set(SQLDialect.MYSQL);
        configuration.set(new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource)));
        configuration.set(new DefaultExecuteListenerProvider(new SqlLoggingListener()));
        return configuration;
    }
}
