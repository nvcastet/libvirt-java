package org.libvirt;

import java.util.Arrays;

import org.libvirt.jna.Libvirt;
import org.libvirt.jna.virTypedParameter;
import org.libvirt.jna.virTypedParameterValue;

import com.sun.jna.Native;

/**
 * The abstract parent of the actual TypedParameter classes
 *
 * @author stoty
 *
 */
public abstract class TypedParameter {

    public static TypedParameter create(virTypedParameter vParam) {
        TypedParameter returnValue = null;
        if (vParam != null) {
            switch (vParam.type) {
                case (6):
                    returnValue = new TypedBooleanParameter(vParam.value.b);
                    break;
            }
            returnValue.field = Native.toString(vParam.field);
        }
        return returnValue;
    }

    public static virTypedParameter toNative(TypedParameter param) {
        virTypedParameter returnValue = new virTypedParameter();
        returnValue.value = new virTypedParameterValue();
        returnValue.field = copyOf(param.field.getBytes(), Libvirt.VIR_DOMAIN_SCHED_FIELD_LENGTH);
        returnValue.type = param.getType();
        switch (param.getType()) {
            case (6):
                returnValue.value.b = (byte) (((TypedBooleanParameter) param).value ? 1 : 0);
                returnValue.value.setType(byte.class);
                break;

        }
        return returnValue;
    }

    public static virTypedParameter toNative(String param) {
        virTypedParameter returnValue = new virTypedParameter();
        returnValue.value = new virTypedParameterValue();
        returnValue.field = copyOf(param.getBytes(), Libvirt.VIR_DOMAIN_SCHED_FIELD_LENGTH);
        returnValue.type = 6;
        returnValue.value.b = (byte) 1;
        returnValue.value.setType(byte.class);
        return returnValue;
    }

    public static byte[] copyOf(byte[] original, int length) {
        byte[] returnValue = new byte[length];
        int originalLength = original.length ;
        Arrays.fill(returnValue, (byte)0);
        for (int x = 0 ; x < originalLength ; x++) {
            returnValue[x] = original[x] ;
        }
        return returnValue ;
    }

    /**
     * Parameter name
     */
    public String field;

    /**
     * The type of the parameter
     *
     * @return the Type of the parameter
     */
    public abstract int getType();

    /**
     * Utility function for displaying the type
     *
     * @return the Type of the parameter as string
     */
    public abstract String getTypeAsString();

    /**
     * Utility function for displaying the value
     *
     * @return the value of the parameter in String form
     */
    public abstract String getValueAsString();
}
