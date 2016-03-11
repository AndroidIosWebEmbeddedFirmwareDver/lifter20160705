package com.wxl.export.lifter.common.entity.dbparam;

/**
 * @author wxl.sinto.cto
 * @Description: 数据库传递类型
 * @ClassName: DBHandleType
 * @date 2014-9-13 下午5:38:35
 */
public class DBHandleType {

    public static final int WRITE = 1001;// 写数据到数据库
    public static final int READ = 1002;// 从数据库读数据
    public static final int READ_TABLE_COUNT = 1003;// 从数据库查询表行数
    public static final int DELETE = 1004;// 从数据库删除数据
    public static final int UPDATE = 1005;// 从数据库更新数据

}
