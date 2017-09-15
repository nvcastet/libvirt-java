package org.libvirt.jna;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * JNA mapping for the virTypedParameter structure
 */
public class virTypedParameter extends Structure {
    public class ByReference extends virTypedParameter implements Structure.ByReference { }
    public byte field[] = new byte[Libvirt.VIR_DOMAIN_SCHED_FIELD_LENGTH];
    public int type;
    public virTypedParameterValue value;

    private static final List<String> fields = Arrays.asList(
            "field", "type", "value");

    @Override
    protected List<String> getFieldOrder() {
        return fields;
    }
}
