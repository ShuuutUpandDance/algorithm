package lego;

import java.util.Random;

public class Lego {
    static int L = 8;
    static Point[][] points;
    static int LEGO_NUM = 0;

    public static void main(String[] args) {
        points = new Point[L][L];

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                points[i][j] = new Point();
                Point point = points[i][j];
                point.x = i;
                point.y = j;
                point.legoNum = -1;
            }
        }

        Random random = new Random();
        int randomX = random.nextInt(L);
        int randomY = random.nextInt(L);
        System.out.println(randomX + " "+randomY);
        System.out.println("=================");
        Point spot = points[randomX][randomY];
        spot.legoNum = LEGO_NUM++;

        lego(L, spot, points[0][0]);

        boolean flag = true;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                Point point = points[i][j];
                if (point.legoNum < 0) {
                    flag = false;
                    System.out.println(i +" "+j);
                }
            }
        }
        System.out.println(flag);

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                Point point = points[i][j];
                System.out.printf("%-7s", point.legoNum);
                if (j == L - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

    private static class Point {
        int x;
        int y;
//        boolean covered;
        int legoNum;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;
            Point temp = (Point) obj;
            return (this.x == temp.x) && (this.y == temp.y);
        }
    }

    private static void lego(int l, Point spot, Point start) {
        if (l > 1) {
            int temp = spot.legoNum;

            // 初始化 2x2 的覆盖矩阵
            Point[][] coverPoints = new Point[2][2];
            coverPoints[0][0] = points[start.x + l / 2 - 1][start.y + l / 2 - 1];  // 0,0
            coverPoints[0][0].legoNum = LEGO_NUM;
            coverPoints[0][1] = points[start.x + l / 2 - 1][start.y + l / 2];      // 0,1
            coverPoints[0][1].legoNum = LEGO_NUM;
            coverPoints[1][0] = points[start.x + l / 2][start.y + l / 2 - 1];     // 1,0
            coverPoints[1][0].legoNum = LEGO_NUM;
            coverPoints[1][1] = points[start.x + l / 2][start.y + l / 2];          // 1,1
            coverPoints[1][1].legoNum = LEGO_NUM;

            LEGO_NUM++;
            // 计算spot所属区域的压缩编码
            int coveredAreaX = (spot.x - start.x) / (l / 2);
            int coveredAreaY = (spot.y - start.y) / (l / 2);
            // 如果二者指的不是同一个点，就同时修改引用和legoNum；否则，只改回legoNum即可
            if (!(coverPoints[coveredAreaX][coveredAreaY].equals(spot))) {
                coverPoints[coveredAreaX][coveredAreaY].legoNum = -1;
                coverPoints[coveredAreaX][coveredAreaY] = spot;
            } else {
                coverPoints[coveredAreaX][coveredAreaY].legoNum = temp;
            }

            //摆放完毕，分而治之
            lego(l / 2, coverPoints[0][0], start); // 0,0
            lego(l / 2, coverPoints[0][1], points[start.x][start.y + l / 2]); // 0,1
            lego(l / 2, coverPoints[1][0], points[start.x + l / 2][start.y]); // 1,0
            lego(l / 2, coverPoints[1][1], points[start.x + l / 2][start.y + l / 2]); // 1,1
        }
    }
}
