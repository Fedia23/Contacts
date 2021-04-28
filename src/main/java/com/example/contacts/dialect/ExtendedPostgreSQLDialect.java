package com.example.contacts.dialect;

import org.hibernate.dialect.PostgreSQL95Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class ExtendedPostgreSQLDialect extends PostgreSQL95Dialect {
    public ExtendedPostgreSQLDialect() {
        registerFunction("regexp_like", new SQLFunctionTemplate(StandardBasicTypes.BOOLEAN, "?1 !~ ?2"));

    }
}