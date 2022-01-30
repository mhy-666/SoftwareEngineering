package Service.module.support.quartz.task.test;

import Service.common.domain.ITask;
import Service.util.SmartDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * [  ]
 *
 * @author yandanyang
 * @version 1.0
 * @company 1024lab.net
 * @copyright (c) 2018 1024lab.netInc. All rights reserved.
 * @date 2019/4/13 0013 下午 14:26
 * @since JDK1.8
 */
@Slf4j
@Component("exampleTask")
public class Example implements ITask {

    @Override
    public void execute(String paramJson) throws Exception {
        log.warn("{}-今天搬了{}块砖,paramJson:{}", SmartDateUtil.formatYMDHMS(new Date()),System.currentTimeMillis(),paramJson );
    }
}
