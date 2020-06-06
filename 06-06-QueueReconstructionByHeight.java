class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new comp());
        int row = people.length;
        if (row == 0) return people;
        int col = people[0].length;
        boolean filled[] = new boolean[row];
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            int[] p = people[i];
            int idx = p[1];
            int count = 0;
            for (int j = 0; j < row; j++) {
                if (filled[j]) continue;
                if (idx == count) {
                    ans[j] = p;
                    filled[j] = true;
                    if (i + 1 < row && people[i + 1][0] == p[0]) {
                        p = people[i + 1];
                        idx = p[1];
                        i++;
                    } else {
                        break;
                    }
                }
                count++;
            }
        }

        return ans;
    }

    public class comp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        }
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, new comp());

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
            // for(int[] p: res){ System.out.println(Arrays.toString(p));}
            // System.out.println();
        }

        return list.toArray(new int[people.length][2]);
    }
}

public class comp implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return a[1] - b[1];
        } else {
            return b[0] - a[0];
        }
    }
}