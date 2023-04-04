package school;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class RightTriangleDemo {
    public static void main(String[] args) {
        RightTriangle rt = new RightTriangle(3, 4);

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED); // 给直角三角形填充颜色
                g.drawLine(0, 0, (int) (rt.getLeg1() * 50), 0); // 画第一条直角边
                g.drawLine(0, 0, 0, (int) (rt.getLeg2() * 50)); // 画第二条直角边
                g.drawLine((int) (rt.getLeg1() * 50), 0, 0, (int) (rt.getLeg2() * 50)); // 画斜边
                int[] x = {0, 0, (int) (rt.getLeg1() * 50)};
                int[] y = {(int) (rt.getLeg2() * 50), 0, 0};
                g.fillPolygon(x, y, 3);// 填充直角三角形
            }

        };

        frame.add(panel);
        frame.setVisible(true);

        System.out.println("直角三角形的周长：" + rt.getPerimeter());
        System.out.println("直角三角形的面积：" + rt.getArea());
    }
}

class RightTriangle {
    private double leg1; // 直角三角形的第一条直角边
    private double leg2; // 直角三角形的第二条直角边

    public RightTriangle(double leg1, double leg2) {
        this.leg1 = leg1;
        this.leg2 = leg2;
    }

    public double getLeg1() {
        return leg1;
    }

    public void setLeg1(double leg1) {
        this.leg1 = leg1;
    }

    public double getLeg2() {
        return leg2;
    }

    public void setLeg2(double leg2) {
        this.leg2 = leg2;
    }

    public double getHypotenuse() {
        return Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2)); // 用勾股定理计算斜边长
    }

    public double getPerimeter() {
        return leg1 + leg2 + getHypotenuse(); // 计算周长
    }

    public double getArea() {
        return leg1 * leg2 / 2; // 计算面积
    }
}
