package org.example;

import java.util.*;

public class SharedMemory {
    private final Queue<Token> tokens;
    public SharedMemory(int n) {
        List<Token> allTokens = new ArrayList<>(n * n * n);
        for (int i = 1; i <= n * n * n; i++) {
            allTokens.add(new Token(i));
        }
        Collections.shuffle(allTokens);
        tokens = new LinkedList<>(allTokens);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>(howMany);
        for (int i = 0; i < howMany; i++) {
            Token token = tokens.poll();
            if (token == null) {
                break;
            }
            extracted.add(token);
        }
        return extracted;
    }
}
