package cn.jianml.mybatis.entity;

import lombok.Data;

/**
 * @author wujian
 * @time 2020/1/9
 */
@Data
public class QueryRequest {

    // 当前页面数据量
    private int pageSize = 10;
    // 当前页码
    private int pageNum = 1;
    // 排序字段
    private String field;
    // 排序规则，asc升序，desc降序
    private String order;
}
