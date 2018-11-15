/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.pool;

import java.sql.SQLException;
import java.util.Properties;

/**
 * An interface to allow for exception evaluation.
 *
 * https://github.com/alibaba/druid/wiki/ExceptionSorter_cn
 *
 * ExceptionSorter: 剔除不可用连接的机制
 * 作用：在数据库服务器重启，网络抖动，连接被服务器闭关等异常情况下，连接发生了不可恢复异常时，将连接从连接池中移除，保证连接池在异常发生情况下可以正常工作。
 *
 * ExceptionSorter是连接池稳定的关键特性，没有它的连接池，不能认为是有稳定性保障的连接池
 */
public interface ExceptionSorter {

    /**
     * Returns true or false whether or not the exception is fatal.
     * 
     * @param e the exception
     * @return true or false if the exception is fatal.
     */
    boolean isExceptionFatal(SQLException e);
    
    void configFromProperties(Properties properties);
}
