import java.util.*;

public class determiningDNAhealth {
    static class Node {
        Map<Character, Node> children = new HashMap<>();
        Node suffixLink;
        List<Integer> indexes = new ArrayList<>();
    }

    static class AhoCorasick {
        Node root = new Node();
        List<String> genes;
        List<Integer> health;

        public AhoCorasick(List<String> genes, List<Integer> health) {
            this.genes = genes;
            this.health = health;
        }

        public void build() {
            for (int i = 0; i < genes.size(); i++) {
                insert(genes.get(i), i);
            }
            buildLinks();
        }

        private void insert(String gene, int index) {
            Node node = root;
            for (char ch : gene.toCharArray()) {
                node = node.children.computeIfAbsent(ch, k -> new Node());
            }
            node.indexes.add(index);
        }

        private void buildLinks() {
            Queue<Node> queue = new LinkedList<>();
            root.suffixLink = root;

            for (Node child : root.children.values()) {
                child.suffixLink = root;
                queue.add(child);
            }

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                for (Map.Entry<Character, Node> entry : current.children.entrySet()) {
                    char ch = entry.getKey();
                    Node child = entry.getValue();

                    Node fallback = current.suffixLink;
                    while (fallback != root && !fallback.children.containsKey(ch)) {
                        fallback = fallback.suffixLink;
                    }

                    if (fallback.children.containsKey(ch) && fallback.children.get(ch) != child) {
                        fallback = fallback.children.get(ch);
                    }

                    child.suffixLink = fallback;
                    child.indexes.addAll(fallback.indexes);
                    queue.add(child);
                }
            }
        }

        public long search(String dna, int first, int last) {
            Node node = root;
            long total = 0;

            for (char ch : dna.toCharArray()) {
                while (node != root && !node.children.containsKey(ch)) {
                    node = node.suffixLink;
                }
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                }

                for (int index : node.indexes) {
                    if (index >= first && index <= last) {
                        total += health.get(index);
                    }
                }
            }

            return total;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<String> genes = Arrays.asList(sc.nextLine().split(" "));
        List<Integer> health = new ArrayList<>();
        for (String h : sc.nextLine().split(" ")) {
            health.add(Integer.parseInt(h));
        }

        int s = Integer.parseInt(sc.nextLine());

        AhoCorasick ac = new AhoCorasick(genes, health);
        ac.build();

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < s; i++) {
            String[] parts = sc.nextLine().split(" ");
            int first = Integer.parseInt(parts[0]);
            int last = Integer.parseInt(parts[1]);
            String d = parts[2];

            long result = ac.search(d, first, last);
            min = Math.min(min, result);
            max = Math.max(max, result);
        }

        System.out.println(min + " " + max);
    }
}
