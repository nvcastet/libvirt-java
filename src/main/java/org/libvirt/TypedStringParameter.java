package org.libvirt;

import com.sun.jna.Native;

/**
 * Parameter to hold a string.
 */
public final class TypedStringParameter extends TypedParameter {
    public String value;

    public TypedStringParameter() {

    }

    public TypedStringParameter(String value) {
        this.value = value;
    }

    public TypedStringParameter(byte[] value) {
        this.value = Native.toString(value);
    }

    public int getType() {
        return 7;
    }

    public String getTypeAsString() {
        return "VIR_TYPED_PARAM_STRING";
    }

    public String getValueAsString() {
        return value;
    }
}
