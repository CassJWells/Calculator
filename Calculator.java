import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Calculator {
    private static final Set<Character> OPERATORS = Set.of('+', '-', '*', '/');

    public static void main(String[] args) {
        List<String> tokens = new ArrayList<>();

        String argument = args[0].replaceAll("\\s+","");

        for (int i = 0; i < argument.length(); i++) {
            if (OPERATORS.contains(argument.charAt(i))) {
                tokens.add(String.valueOf(argument.charAt(i)));
            } else if (Character.isDigit(argument.charAt(i))) {
                for (int j = i; j <= argument.length(); j++) {
                    if (j == argument.length() || !Character.isDigit(argument.charAt(j))) {
                        tokens.add(argument.substring(i, j));
                        i = j - 1;
                        break;
                    }
                }
            }
        }

        ParserState state = new ParserState();
        state.tokens = tokens;

        ExprNode root = Parser.parseExpression(state);

        
        root.printTree(0);
    }
}
