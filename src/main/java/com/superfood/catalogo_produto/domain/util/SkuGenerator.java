package com.superfood.catalogo_produto.domain.util;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

public class SkuGenerator {

    private static final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int SIZE = 8;

    public static String gerarSku() {
        return NanoIdUtils.randomNanoId(
                NanoIdUtils.DEFAULT_NUMBER_GENERATOR,
                ALPHABET,
                SIZE
        );
    }
}
