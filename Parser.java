public class Parser {
    static ExprNode parseExpression(ParserState state) {
        ExprNode left = parseTerm(state);
        while (state.index < state.tokens.size()) {
            String op = state.tokens.get(state.index);
            if (!op.equals("+") && !op.equals("-")) break;
            state.index++;
            ExprNode right = parseTerm(state);
            left = new ExprNode(op, left, right);
        }
        return left;
    }

    static ExprNode parseTerm(ParserState state) {
        ExprNode left = parseFactor(state);
        while (state.index < state.tokens.size()) {
            String op = state.tokens.get(state.index);
            if (!op.equals("*") && !op.equals("/")) break;
            state.index++;
            ExprNode right = parseFactor(state);
            left = new ExprNode(op, left, right);
        }
        return left;
    }

    static ExprNode parseFactor(ParserState state) {
        String token = state.tokens.get(state.index);

        if (token.equals("(")) {
            state.index++;
            ExprNode inner = parseExpression(state);
            if (!state.tokens.get(state.index).equals(")")) {
                throw new IllegalArgumentException("Missing closing parenthesis");
            }
            state.index++;
            return inner;
        } else {
            state.index++;
            return new ExprNode(token);
        }
    }
}
