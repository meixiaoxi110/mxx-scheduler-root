package com.meixiaoxi.scheduler.task;

import com.meixiaoxi.scheduler.AppContext;
import com.meixiaoxi.scheduler.core.processor.TaskProcessor;
import org.redisson.api.RedissonClient;

import java.util.*;

/**
 * Copyright: Copyright (c) 2018 meixiaoxi
 *
 * @ClassName: ConsumerTaskContext
 * @Description:
 * @version: v1.0.0
 * @author: meixiaoxi
 * @date: 2019-04-25 16:35:33
 * Modification History:
 * Date          Author          Version          Description
 * -----------------------------------------------------------
 * 2019-04-25    meixiaoxi       v1.0.0           创建
 */
public class TaskAppContext extends AppContext {

    public Map<String, String> taskExecuteHandlerMap = new HashMap<>();
    public List<String> executeHandlerAlisList = new ArrayList<>();

    public TaskAppContext(Properties config) {
        super(config);
    }

    public TaskAppContext(Properties config, RedissonClient redissonClient, TaskProcessor taskProcessor) {
        super(config, redissonClient, taskProcessor);
    }

    public void putTaskExecuteHandler(String alis, String fullClassName) {
        taskExecuteHandlerMap.put(alis, fullClassName);
        executeHandlerAlisList.add(alis);
    }

    public String removeTaskExecuteHandler(String alis) {
        String fullClassName = taskExecuteHandlerMap.remove(alis);
        executeHandlerAlisList.remove(alis);
        return fullClassName;
    }
}
