package com.Vrglab.Utils;

import com.Vrglab.ExtremeRubyMod;
import net.minecraft.resources.ResourceLocation;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Utils {

    public static ResourceLocation createLocation(String obj) {
        return new ResourceLocation(ExtremeRubyMod.MOD_ID, obj);
    }

    /**
     * Creates an instance of a class using reflection, with the given constructor arguments.
     *
     * @param clazz           Class object of the class to instantiate.
     * @param constructorArgs Arguments to pass to the constructor.
     * @return An instance of the class.
     */
    public static Object createInstance(Class<?> clazz, Object... constructorArgs) {
        try {
            Class<?>[] argTypes = new Class<?>[constructorArgs.length];
            for (int i = 0; i < constructorArgs.length; i++) {
                if (constructorArgs[i] != null) {
                    argTypes[i] = constructorArgs[i].getClass();
                } else {
                    throw new IllegalArgumentException("Constructor argument cannot be null.");
                }
            }

            // Find the constructor that matches the argument types or their subclasses
            Constructor<?>[] constructors = clazz.getConstructors();
            Constructor<?> foundConstructor = null;

            outerLoop:
            for (Constructor<?> constructor : constructors) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == argTypes.length) {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (!parameterTypes[i].isAssignableFrom(argTypes[i])) {
                            continue outerLoop; // Skip to the next constructor
                        }
                    }
                    foundConstructor = constructor;
                    break;
                }
            }

            if (foundConstructor == null) {
                throw new NoSuchMethodException("No constructor found with matching parameter types.");
            }

            return foundConstructor.newInstance(constructorArgs);
        } catch (Throwable t){
            return null;
        }
    }
}
