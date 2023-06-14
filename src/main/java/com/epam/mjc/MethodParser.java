package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        //throw new UnsupportedOperationException("You should implement this method.");

        String arg = signatureString.substring(signatureString.indexOf("(") + 1, signatureString.lastIndexOf(")"));
        String[] list = arg.replace(",", "").split(" ");
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        if (list.length > 1) {
            for (int i = 0; i < list.length; i += 2) {
                arguments.add(new MethodSignature.Argument(list[i], list[i + 1]));
            }
        }

        String[] signature = signatureString.replace("(", " ").replace(")", " ").split(" ");
        String modifier = "", type, name;
        if (signature[0].equals("public") || signature[0].equals("private") || signature[0].equals("protected")) {
            modifier = signature[0];
            type = signature[1];
            name = signature[2];
        } else {
            type = signature[0];
            name = signature[1];
        }

        MethodSignature obj = new MethodSignature(name, arguments);
        if (!modifier.equals("")) {
            obj.setAccessModifier(modifier);
        }
        obj.setReturnType(type);
        return obj;
    }
}
