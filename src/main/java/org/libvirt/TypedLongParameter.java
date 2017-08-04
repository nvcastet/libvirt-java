package org.libvirt;

/**
 * Class for representing a long int typed parameter
 *
 * @author stoty
 *
 */
public final class TypedLongParameter extends TypedParameter {
    /**
     * The parameter value
     */
    public long value;

    public TypedLongParameter() {

    }

    public TypedLongParameter(long value) {
        this.value = value;
    }

    public int getType() {
        return 3;
    }

    public String getTypeAsString() {
        return "VIR_TYPED_PARAM_LLONG";
    }

    public String getValueAsString() {
        return Long.toString(value);
    }

}
