package com.example;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class MemoConfig {
	
	@Autowired
	private  JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
	
	@Bean
	public JdbcBatchItemWriter<Memo> writer(DataSource dataSource) {
	  return new JdbcBatchItemWriterBuilder<Memo>()
	    .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	    .sql("INSERT INTO memo (content) VALUES (:content)")
	    .dataSource(dataSource)
	    .build();
	}
	
	@Bean
    public MemoTasklet tasklet() {
        return new MemoTasklet();

    }
	
	@Bean
	public Step memoStep() {
		return stepBuilderFactory.get("memoStep")//Step名を指定
				.tasklet(tasklet())//実行するTaskletを指定
				.build();
	}
	
	@Bean
	public Job memoJob(Step memoStep) {
		return jobBuilderFactory.get("memoJob") //Job名を指定
				.incrementer(new RunIdIncrementer())
				.flow(memoStep) //実行するStepを指定
				.end()
				.build();
	}
	
}
