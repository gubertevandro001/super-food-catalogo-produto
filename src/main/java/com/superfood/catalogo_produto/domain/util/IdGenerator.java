package com.superfood.catalogo_produto.domain.util;

import java.util.UUID;

public final class IdGenerator {

    private IdGenerator() {}

    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

