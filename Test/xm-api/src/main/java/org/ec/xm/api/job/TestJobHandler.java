package org.ec.xm.api.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import kotlin.jvm.Throws;
import kotlin.jvm.internal.Intrinsics;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0204Service;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@JobHandler("TestJobHandler")
@Component
public final class TestJobHandler extends IJobHandler {
    private final XM0204Service xm0204Service;
    public TestJobHandler(XM0204Service xm0204Service) {
        this.xm0204Service = xm0204Service;
    }

    @NotNull
    @Throws(exceptionClasses = Exception.class)
    public ReturnT<String> execute(@NotNull String param) {
        Integer[] num = xm0204Service.getAllOrganizationId();
        String[] task = param.split(",");
        long current = System.currentTimeMillis();
        Date begin = new Date(current);
        current += 15 * 24 * 60 * 60 * 1000;
        Date finish = new Date(current);
        for(int i=0;i<num.length;i++){
            XmTask xmTask = new XmTask();
            xmTask.setProjectId(Integer.valueOf(task[0]));
            xmTask.setName(task[2]);
            xmTask.setType("一般");
            xmTask.setDataTemplateId(Integer.valueOf(task[1]));
            xmTask.setBeginAt(begin);
            xmTask.setFinishAt(finish);
            xmTask.setTaskMode("定时任务");
            xmTask.setEnable(false);
            xmTask.setStatus("待下发");
            xmTask.setOrganizationId(num[i]);
            xmTask.setEnable(true);
            xmTask.setCreatedOrganizationId(1);
            xmTask.setSuperiorOrganizationId(1);
            xm0204Service.insert(xmTask);
        }
        return IJobHandler.SUCCESS;
    }
}
