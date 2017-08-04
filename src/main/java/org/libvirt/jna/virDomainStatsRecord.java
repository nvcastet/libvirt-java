package org.libvirt.jna;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * JNA mapping for the virDomainStatsRecord structure
 */
public class virDomainStatsRecord extends Structure {
    public DomainPointer dom;
    public virTypedParameter.ByReference params;
    public int nparams;

    private static final List<String> fields = Arrays.asList(
            "dom", "params", "nparams");

    public virDomainStatsRecord(Pointer nativeArray) {
        super(nativeArray);
    }

    @Override
    protected List<String> getFieldOrder() {
        return fields;
    }
}
