package org.libvirt;

import java.util.List;

public class DomainStatsRecord {
    private Domain domain;
    private List<TypedParameter> params;

    DomainStatsRecord(Domain d, List<TypedParameter> p) {
        domain = d;
        params = p;
    }

    public Domain getDomain() {
        return domain;
    }

    public List<TypedParameter> getParams() {
        return params;
    }
}
