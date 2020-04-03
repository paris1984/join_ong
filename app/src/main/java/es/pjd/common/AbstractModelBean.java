package es.pjd.common;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public abstract class AbstractModelBean implements Serializable {

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
