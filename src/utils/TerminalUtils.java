package utils;

import java.util.Scanner;

public class TerminalUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static <T> T getValueFromTerminal(String prompt, Class<T> type) {
        try {
            System.out.print(prompt);
            if (type == String.class)
                return type.cast(scanner.nextLine());
            if (type == Integer.class)
                return type.cast(scanner.nextInt());
            if (type == Double.class)
                return type.cast(scanner.nextDouble());
            if (type == Long.class)
                return type.cast(scanner.nextLong());
            throw new IllegalArgumentException("Tipo no soportado: " + type.getSimpleName());
        } catch (Exception e) {
            System.out.println("Error en TerminalUtils.getValueFromTerminal: " + e.getMessage());
            throw e;
        } finally {
            if (type != String.class)
                scanner.nextLine();
        }
    }
}
