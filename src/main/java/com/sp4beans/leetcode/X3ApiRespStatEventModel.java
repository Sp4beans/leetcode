package com.sp4beans.leetcode;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-08-04
 */
class X3ApiRespStatEventModel {
    private String url; // 接口 eg: /rest/n/xxxx/xxx/xxx
    private int errorLevel; // [0, 3] 取值范围0-3，对应严重程度，0最严重
    private int errorType; // 具体错误类型 对应下面的枚举值
    private String errorInfo; // 具体错误信息 可以详细点
    private String rawRespField; // 接口返回的对应字段 eg: photos[3].name
    private String objRespField; // 客户端反序列化之后的对应字段 eg: photoList[3].title
}

enum X3ApiRespStatEventType {
    UNKNOWN(0), // 未知类型
    FIELD_NOT_FOUND(1), // 没找到对应字段：应该下发的字段没有下发
    FIELD_TYPE_DISMATCH(2), // 字段类型不匹配：类型转换报错
    INVALID_FIELD_VALUE(3), // 非法的value值：value值不在合法范围内
    INVALID_FIELD_SIZE(4), // 非法的字段长度：比如一个32位的字符串只返回了20位，size大于5的list返回了少于5个item等
    ;

    X3ApiRespStatEventType(int val) {
        this.value = val;
    }

    private int value;

    public int getValue() {
        return value;
    }
}
