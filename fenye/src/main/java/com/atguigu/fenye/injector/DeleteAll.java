package com.atguigu.fenye.injector;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class DeleteAll extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        // <script></script>
        System.out.println("==========================");
        System.out.println(tableInfo);
        System.out.println("++++++++====================");

        String sql;
        MySqlMethod mySqlMethod = MySqlMethod.DELETE_ALL;
        if (tableInfo.isLogicDelete()) {
            sql = String.format(mySqlMethod.getSql(), tableInfo.getTableName(),  tableInfo,
                    sqlWhereEntityWrapper(true, tableInfo));
        } else {
            mySqlMethod = MySqlMethod.DELETE_ALL;
            sql = String.format(mySqlMethod.getSql(), tableInfo.getTableName(),
                    sqlWhereEntityWrapper(true, tableInfo));
        }
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return addUpdateMappedStatement(mapperClass, modelClass, mySqlMethod.getMethod(), sqlSource);
    }
}
