package ru.yandex.market.graphouse.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.market.graphouse.statistics.StatisticsFlushFrequencyConfig;
import ru.yandex.market.graphouse.statistics.StatisticsService;

/**
 * @author Nikolay Firov <a href="mailto:firov@yandex-team.ru"></a>
 * @date 22.12.17
 */
@Configuration
public class StatisticsConfig {
    @Value("${graphouse.statistics.flush.threads}")
    private int numberOfFlushThreads;

    @Value("${graphouse.statistics.metrics_to_flush_frequency}")
    private String metricsFlushFrequency;

    @Bean
    public StatisticsFlushFrequencyConfig statisticsFlushFrequencyConfig() {
        return new StatisticsFlushFrequencyConfig(metricsFlushFrequency);
    }

    @Bean
    public StatisticsService statisticsService() {
        return new StatisticsService(numberOfFlushThreads);
    }
}