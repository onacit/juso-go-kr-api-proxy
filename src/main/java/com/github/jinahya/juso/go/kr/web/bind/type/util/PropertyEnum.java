package com.github.jinahya.juso.go.kr.web.bind.type.util;

import java.util.Objects;

public interface PropertyEnum<E extends Enum<E> & PropertyEnum<E, P>, P> {

    static <E extends Enum<E> & PropertyEnum<E, P>, P> E valueOfProeprtyValue(
            final Class<E> enumClass, final P propertyValue) {
        for (final var enumConstant : enumClass.getEnumConstants()) {
            if (Objects.equals(enumConstant.getPropertyValue(), propertyValue)) {
                return enumConstant;
            }
        }
        throw new IllegalArgumentException(
                "no enum constant in " + enumClass + " for property value: " + propertyValue
        );
    }

    interface OfString<E extends Enum<E> & OfString<E>>
            extends PropertyEnum<E, String> {

        static <E extends Enum<E> & OfString<E>> E valueOfProeprtyValue(
                final Class<E> enumClass, final String propertyValue) {
            return PropertyEnum.valueOfProeprtyValue(enumClass, propertyValue);
        }
    }

    interface OfInt<E extends Enum<E> & OfInt<E>> {

        static <E extends Enum<E> & OfInt<E>> E valueOfProeprtyValue(
                final Class<E> enumClass, final int propertyValue) {
            for (final var enumConstant : enumClass.getEnumConstants()) {
                if (enumConstant.getPropertyValue() == propertyValue) {
                    return enumConstant;
                }
            }
            throw new IllegalArgumentException(
                    "no enum constant in " + enumClass + " for property value: " + propertyValue
            );
        }

        int getPropertyValue();
    }

    interface OfLong<E extends Enum<E> & OfLong<E>> {

        static <E extends Enum<E> & OfLong<E>> E valueOfProeprtyValue(
                final Class<E> enumClass, final long propertyValue) {
            for (final var enumConstant : enumClass.getEnumConstants()) {
                if (enumConstant.getPropertyValue() == propertyValue) {
                    return enumConstant;
                }
            }
            throw new IllegalArgumentException(
                    "no enum constant in " + enumClass + " for property value: " + propertyValue
            );
        }

        long getPropertyValue();
    }

    // -----------------------------------------------------------------------------------------------------------------
    P getPropertyValue();
}
