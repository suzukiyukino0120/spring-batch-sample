package com.example;

import java.util.ArrayList;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemoTasklet implements Tasklet {
	
	@Autowired
	JdbcBatchItemWriter <Memo> writer;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		ArrayList<Memo> list = new ArrayList<Memo>();
		list.add(new Memo("aa"));
		list.add(new Memo("bb"));
		list.add(new Memo("cc"));
		
		
		writer.write(list);
		
		return RepeatStatus.FINISHED;
	}

}
