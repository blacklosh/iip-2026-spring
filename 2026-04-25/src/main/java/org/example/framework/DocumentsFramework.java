package org.example.framework;

import java.lang.reflect.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DocumentsFramework {

    public <T> T generate(Class<T> documentClass, Object ... args) {
        List<Class<?>> argumentClasses = new ArrayList<>();
        for(Object arg : args) {
            argumentClasses.add(arg.getClass());
        }
        Class<?>[] argumentClasses2 = new Class<?>[args.length];
        argumentClasses.toArray(argumentClasses2);

        try {
            Constructor<T> constructor = documentClass.getConstructor(argumentClasses2);
            T document = constructor.newInstance(args);
            processDefaultValues(document);
            processPostConstructMethods(document);
            return document;
        } catch (NoSuchMethodException e) {
            System.err.println("Constructor not found for class " + documentClass);
            throw new IllegalArgumentException(e);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            System.err.println("Unable to create instance with constructor");
            throw new RuntimeException(e);
        }
    }

    private <T> void processDefaultValues(T document) {
        Class<?> documentClass = document.getClass();
        Field[] fields = documentClass.getDeclaredFields();

        for(Field field : fields) {
            try {
                field.setAccessible(true);
                if(field.get(document) != null) {
                    continue;
                }
                if(field.isAnnotationPresent(DefaultValue.class)) {
                    DefaultValue defaultValue = field.getAnnotation(DefaultValue.class);
                    String value = defaultValue.value();
                    Class<?> fieldType = field.getType();
                    if(fieldType.equals(String.class)) {
                        // это простая строка
                        field.set(document, value);
                    } else if(fieldType.equals(LocalDate.class)) {
                        // это дата, нужно смаппить
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate localDateValue = LocalDate.parse(value, formatter);
                        field.set(document, localDateValue);
                    }
                }
            } catch (IllegalAccessException e) {
                System.err.println("No access to field " + field);
                throw new IllegalStateException(e);
            }
        }
    }

    private <T> void processPostConstructMethods(T document) {
        Class<?> documentClass = document.getClass();
        Method[] methods = documentClass.getDeclaredMethods();

        for(Method method : methods) {
            if(method.isAnnotationPresent(PostConstruct.class)) {
                if(method.getParameterCount() != 0) {
                    System.err.println("Этот метод PostConstruct неправильный, есть параметры: " + method);
                    throw new IllegalArgumentException();
                }
                if(!method.getReturnType().toString().equals("void")) {
                    System.err.println("Этот метод PostConstruct неправильный, не void: " + method);
                    throw new IllegalArgumentException();
                }
                if(!Modifier.toString(method.getModifiers()).contains("public")) {
                    System.err.println("Этот метод PostConstruct неправильный, не public: " + method);
                    throw new IllegalArgumentException();
                }
                try {
                    method.invoke(document);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    System.err.println("Unable to invoke post construct method: " + method);
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
