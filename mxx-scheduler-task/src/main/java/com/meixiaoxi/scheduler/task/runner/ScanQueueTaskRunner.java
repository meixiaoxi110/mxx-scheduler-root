package com.meixiaoxi.scheduler.task.runner;


import com.meixiaoxi.scheduler.core.handler.TaskExecuteHandler;
import com.meixiaoxi.scheduler.task.TaskAppContext;
import com.meixiaoxi.scheduler.annotation.EnabledTaskHandler;

import java.util.ServiceLoader;

/**
 * Copyright: Copyright (c) 2018 meixiaoxi
 *
 * @ClassName: TaskRunner
 * @Description:
 * @version: v1.0.0
 * @author: meixiaoxi
 * @date: 2019-04-25 14:29:43
 * Modification History:
 * Date          Author          Version          Description
 * -----------------------------------------------------------
 * 2019-04-25    meixiaoxi       v1.0.0           创建
 */
public class ScanQueueTaskRunner extends TaskRunner<TaskAppContext> {

    public ScanQueueTaskRunner(TaskAppContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        runNext();
    }

    private void registerTaskHandler(TaskAppContext context) {
        ServiceLoader<TaskExecuteHandler> loader = ServiceLoader.load(TaskExecuteHandler.class);
        loader.forEach(taskExecuteHandler -> {
            boolean hasAnnotation = taskExecuteHandler.getClass().isAnnotationPresent(EnabledTaskHandler.class);
            if (hasAnnotation) {
                EnabledTaskHandler clazzAnnotation = taskExecuteHandler.getClass().getAnnotation(EnabledTaskHandler.class);
                String taskGroup = clazzAnnotation.taskGroup();
                context.putTaskExecuteHandler(taskGroup, taskExecuteHandler.getClass().getName());
            }
        });
    }

}