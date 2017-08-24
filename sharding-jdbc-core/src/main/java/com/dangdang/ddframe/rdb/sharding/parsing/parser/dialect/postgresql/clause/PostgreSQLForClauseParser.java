/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
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
 * </p>
 */

package com.dangdang.ddframe.rdb.sharding.parsing.parser.dialect.postgresql.clause;

import com.dangdang.ddframe.rdb.sharding.parsing.lexer.LexerEngine;
import com.dangdang.ddframe.rdb.sharding.parsing.lexer.dialect.postgresql.PostgreSQLKeyword;
import com.dangdang.ddframe.rdb.sharding.parsing.lexer.token.DefaultKeyword;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.clause.SQLClauseParser;
import lombok.RequiredArgsConstructor;

/**
 * PostgreSQL For语句解析器.
 *
 * @author zhangliang
 */
@RequiredArgsConstructor
public final class PostgreSQLForClauseParser implements SQLClauseParser {
    
    private final LexerEngine lexerEngine;
    
    /**
     * 解析For.
     */
    public void parse() {
        if (!lexerEngine.skipIfEqual(DefaultKeyword.FOR)) {
            return;
        }
        lexerEngine.skipIfEqual(DefaultKeyword.UPDATE, PostgreSQLKeyword.SHARE);
        lexerEngine.unsupportedIfEqual(DefaultKeyword.OF);
        lexerEngine.skipIfEqual(PostgreSQLKeyword.NOWAIT);
    }
}
