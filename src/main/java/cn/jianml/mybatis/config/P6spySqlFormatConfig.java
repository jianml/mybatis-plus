package cn.jianml.mybatis.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.time.LocalDateTime;

/**
 * 自定义 p6spy sql输出格式
 * @author wujian
 * @time 2020/1/12
 */
public class P6spySqlFormatConfig implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return !"".equals(sql.trim()) ? "[ " + LocalDateTime.now() + " ] --- | took "
                + elapsed + "ms | " + category + " | connection " + connectionId + "\n "
                + sql + ";" : "";
    }
}
