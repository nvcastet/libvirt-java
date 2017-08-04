package org.libvirt;

/**
 * Class for representing a double typed parameter
 *
 * @author stoty
 *
 */
public final class TypedDoubleParameter extends TypedParameter {
    /**
     * The parameter value
     */
    public double value;

    public TypedDoubleParameter() {

    }

    public TypedDoubleParameter(double value) {
        this.value = value;
    }

    public int getType() {
        return 5;
    }

    public String getTypeAsString() {
        return "VIR_TYPED_PARAM_DOUBLE";
    }

    public String getValueAsString() {
        return Double.toString(value);
    }
}
