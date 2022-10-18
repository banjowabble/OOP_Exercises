public class Test {
    public static void main(String[] args) {
        /*Board board = new Board();
        Bishop b1 = new Bishop(2, 2);
        Bishop b2 = new Bishop(4, 4, "black");

        board.addPiece(b1);
        board.addPiece(b2);

        System.out.println(b1.canMove(board, 4, 4));

        Game game = new Game(board);
        game.movePiece(b1, 4, 4);
        System.out.println(game.getMoveHistory());
        game.movePiece(b1, 5, 5);
        System.out.println(game.getMoveHistory());*/
        String str = "package com.nordstrom.common.base;\n" +
                "\n" +
                "import java.lang.reflect.InvocationTargetException;\n" +
                "import java.util.Arrays;\n" +
                "import java.util.Collections;\n" +
                "import java.util.HashSet;\n" +
                "import java.util.Set;\n" +
                "\n" +
                "public class ExceptionUnwrapper {\n" +
                "\n" +
                "    private static final Set<Class<? extends Exception>> unwrappable = \n" +
                "            Collections.unmodifiableSet(new HashSet<>(Arrays.asList(RuntimeException.class, InvocationTargetException.class)));\n" +
                "\n" +
                "    private ExceptionUnwrapper() {\n" +
                "        throw new AssertionError(\"ExceptionUnwrapper is a static utility class that cannot be instantiated.\");\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * Unwrap the specified exception.<br>\n" +
                "     * <br>\n" +
                "     * <b>NOTE</b>: This method unwraps the exception chain until it encounters either a non-wrapper exception or an\n" +
                "     * exception with no specified cause. The unwrapped exception is returned.\n" +
                "     * \n" +
                "     * @param throwable exception to be unwrapped\n" +
                "     * @return unwrapped exception\n" +
                "     */\n" +
                "    public static Throwable unwrap(Throwable throwable) {\n" +
                "        return unwrap(throwable, null);\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * Unwrap the specified exception, optionally retaining wrapper messages.<br>\n" +
                "     * <br>\n" +
                "     * <b>NOTE</b>: This method unwraps the exception chain until it encounters either a non-wrapper exception or an\n" +
                "     * exception with no specified cause. The unwrapped exception is returned.\n" +
                "     * \n" +
                "     * @param throwable exception to be unwrapped\n" +
                "     * @param builder to compile wrapper messages (may be 'null')\n" +
                "     * @return unwrapped exception\n" +
                "     */\n" +
                "    public static Throwable unwrap(Throwable throwable, StringBuilder builder) {\n" +
                "        Throwable thrown = throwable;\n" +
                "        if (thrown != null) {\n" +
                "            while (unwrappable.contains(thrown.getClass())) {\n" +
                "                Throwable unwrapped = thrown.getCause();\n" +
                "                if (unwrapped == null) break;\n" +
                "                if (builder != null) builder.append(thrown.getMessage()).append(\" -> \");\n" +
                "                thrown = unwrapped;\n" +
                "            }\n" +
                "        }\n" +
                "        return thrown;\n" +
                "    }\n" +
                "\n" +
                "}";
        Week10 week10 = new Week10();
        System.out.println(week10.getAllFunctions(str));
    }
}
