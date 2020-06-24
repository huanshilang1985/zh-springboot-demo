package com.zh;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.alibaba.fastjson.JSON;
import org.slf4j.helpers.MessageFormatter;

import java.util.stream.Stream;

/**
 * 日志输出格式转换器
 *
 * @author he.zhang
 * @since 2020/6/24 14:19
 */
public class LogMessageConverter extends MessageConverter {

    @Override
    public String convert(ILoggingEvent event) {
        try {
            return MessageFormatter.arrayFormat(event.getMessage(), Stream.of(event.getArgumentArray())
                    .map(JSON::toJSONString).toArray()).getMessage();
        } catch (Exception e) {
            return event.getMessage();
        }
    }
}
