import java.util.*;

public class countStrings {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < q; t++) {
            String[] line = sc.nextLine().split(" ");
            String regex = line[0];
            int L = Integer.parseInt(line[1]);

            NFA nfa = new RegexParser(regex).parse();
            DFA dfa = new DFA(nfa);
            System.out.println(dfa.countAcceptedStrings(L));
        }
        sc.close();
    }

    static class RegexParser {
        String regex;
        int index;

        RegexParser(String regex) {
            this.regex = regex;
            this.index = 0;
        }

        NFA parse() {
            return expression();
        }

        NFA expression() {
            NFA term = term();
            if (index < regex.length() && regex.charAt(index) == '|') {
                index++;
                return NFA.union(term, expression());
            }
            return term;
        }

        NFA term() {
            NFA factor = factor();
            while (index < regex.length() && regex.charAt(index) != ')' && regex.charAt(index) != '|') {
                factor = NFA.concat(factor, factor());
            }
            return factor;
        }

        NFA factor() {
            NFA base = base();
            while (index < regex.length() && regex.charAt(index) == '*') {
                base = NFA.kleene(base);
                index++;
            }
            return base;
        }

        NFA base() {
            char c = regex.charAt(index);
            if (c == '(') {
                index++;
                NFA nfa = expression();
                index++; 
                return nfa;
            } else {
                index++;
                return NFA.symbol(c);
            }
        }
    }

    static class NFA {
        static int idCounter = 0;
        int start, end;
        Map<Integer, List<Edge>> transitions = new HashMap<>();

        NFA(int start, int end) {
            this.start = start;
            this.end = end;
        }

        static NFA symbol(char c) {
            int s = idCounter++;
            int e = idCounter++;
            NFA nfa = new NFA(s, e);
            nfa.addTransition(s, e, c);
            return nfa;
        }

        static NFA concat(NFA a, NFA b) {
            a.addTransition(a.end, b.start, 0);
            NFA result = new NFA(a.start, b.end);
            result.transitions.putAll(a.transitions);
            for (var entry : b.transitions.entrySet()) {
                result.transitions.merge(entry.getKey(), entry.getValue(), (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                });
            }
            return result;
        }

        static NFA union(NFA a, NFA b) {
            int s = idCounter++;
            int e = idCounter++;
            NFA nfa = new NFA(s, e);
            nfa.addTransition(s, a.start, 0);
            nfa.addTransition(s, b.start, 0);
            nfa.addTransition(a.end, e, 0);
            nfa.addTransition(b.end, e, 0);
            nfa.transitions.putAll(a.transitions);
            for (var entry : b.transitions.entrySet()) {
                nfa.transitions.merge(entry.getKey(), entry.getValue(), (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                });
            }
            return nfa;
        }

        static NFA kleene(NFA a) {
            int s = idCounter++;
            int e = idCounter++;
            NFA nfa = new NFA(s, e);
            nfa.addTransition(s, a.start, 0);
            nfa.addTransition(a.end, a.start, 0);
            nfa.addTransition(s, e, 0);
            nfa.addTransition(a.end, e, 0);
            nfa.transitions.putAll(a.transitions);
            return nfa;
        }

        void addTransition(int from, int to, int ch) {
            transitions.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, ch));
        }

        static class Edge {
            int to, ch;
            Edge(int to, int ch) {
                this.to = to;
                this.ch = ch;
            }
        }
    }

    static class DFA {
        Map<Set<Integer>, Integer> stateMap = new HashMap<>();
        List<Map<Character, Integer>> transitions = new ArrayList<>();
        Set<Integer> acceptStates = new HashSet<>();
        int startState;

        DFA(NFA nfa) {
            Queue<Set<Integer>> queue = new LinkedList<>();
            startState = 0;
            Set<Integer> startSet = epsilonClosure(Set.of(nfa.start), nfa);
            stateMap.put(startSet, startState);
            transitions.add(new HashMap<>());
            queue.add(startSet);

            while (!queue.isEmpty()) {
                Set<Integer> current = queue.poll();
                int stateId = stateMap.get(current);
                for (char ch : List.of('a', 'b')) {
                    Set<Integer> next = move(current, ch, nfa);
                    if (!stateMap.containsKey(next)) {
                        stateMap.put(next, transitions.size());
                        transitions.add(new HashMap<>());
                        queue.add(next);
                    }
                    transitions.get(stateId).put(ch, stateMap.get(next));
                }
                if (current.contains(nfa.end)) {
                    acceptStates.add(stateId);
                }
            }
        }

        Set<Integer> epsilonClosure(Set<Integer> states, NFA nfa) {
            Set<Integer> closure = new HashSet<>(states);
            Stack<Integer> stack = new Stack<>();
            stack.addAll(states);
            while (!stack.isEmpty()) {
                int s = stack.pop();
                for (NFA.Edge edge : nfa.transitions.getOrDefault(s, List.of())) {
                    if (edge.ch == 0 && !closure.contains(edge.to)) {
                        closure.add(edge.to);
                        stack.push(edge.to);
                    }
                }
            }
            return closure;
        }

        Set<Integer> move(Set<Integer> states, char ch, NFA nfa) {
            Set<Integer> next = new HashSet<>();
            for (int s : states) {
                for (NFA.Edge edge : nfa.transitions.getOrDefault(s, List.of())) {
                    if (edge.ch == ch) {
                        next.add(edge.to);
                    }
                }
            }
            return epsilonClosure(next, nfa);
        }

        int countAcceptedStrings(int L) {
            int n = transitions.size();
            long[][] dp = new long[L + 1][n];
            dp[0][startState] = 1;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] == 0) continue;
                    for (char ch : List.of('a', 'b')) {
                        int next = transitions.get(j).get(ch);
                        dp[i + 1][next] = (dp[i + 1][next] + dp[i][j]) % MOD;
                    }
                }
            }

            long total = 0;
            for (int i : acceptStates) {
                total = (total + dp[L][i]) % MOD;
            }
            return (int) total;
        }
    }
}
