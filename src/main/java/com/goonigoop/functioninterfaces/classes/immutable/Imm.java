package com.goonigoop.functioninterfaces.classes.immutable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.collections4.ListUtils.emptyIfNull;

public final class Imm {

    private final String name;
    private final List<String> names;
    private final BigDecimal price;

    public Imm(String name, List<String> names, BigDecimal price) {
        this.name = name;
        this.names = new ArrayList<>(emptyIfNull(names));
        this.price = Optional.ofNullable(price)
                .map(BigDecimal::toString)
                .map(BigDecimal::new)
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public List<String> getNames() {
        return new ArrayList<>(names);
    }

    public BigDecimal getPrice() {
        return new BigDecimal(String.valueOf(price));
    }


}
