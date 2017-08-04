package org.libvirt;

/**
 * Parameter to hold an int.
 */
public final class TypedIntParameter extends TypedParameter {
    public int value;

    public TypedIntParameter() {

    }

    public TypedIntParameter(int value) {
        this.value = value;
    }

    public int getType() {
        return 1;
    }

    public String getTypeAsString() {
        return "VIR_TYPED_PARAM_INT";
    }

    public String getValueAsString() {
        return Integer.toString(value);
    }
}
