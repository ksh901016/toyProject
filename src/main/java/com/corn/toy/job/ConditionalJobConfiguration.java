package com.corn.toy.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ConditionalJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job stepConditionalJob(){
        return jobBuilderFactory.get("stepConditionalJob")
                    .start(jobStep1())
                        .on("FAILED")
                        .to(jobStep3())
                        .on("*")
                        .end()
                    .from(jobStep1())
                        .on("*")
                        .to(jobStep2())
                        .next(jobStep3())
                        .on("*")
                        .end()
                    .end()
                    .build();
    }

    @Bean
    public Step jobStep1(){
        return stepBuilderFactory.get("jobStep1")
                    .tasklet((stepContribution, chunkContext) -> {
                        log.info(">>>> jobStep1 >>>");
                        /**
                         * ExitStatus를 FAILED로 지정
                         * 해당 status판단하여 flow 진행
                         */
                        //stepContribution.setExitStatus(ExitStatus.FAILED);
                        return RepeatStatus.FINISHED;
                    })
                    .build();
    }

    @Bean
    public Step jobStep2(){
        return stepBuilderFactory.get("jobStep2")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">>>> jobStep2 >>>");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step jobStep3(){
        return stepBuilderFactory.get("jobStep3")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info(">>>> jobStep3 >>>");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
