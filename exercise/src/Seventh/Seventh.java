package Seventh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.FileReader;

public class Seventh {
    // MySQL 连接信息
	private static final String URL = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
    private static final String PASSWORD = "1111111111";

    public static void main(String[] args) {
        try {
            // 1. 连接数据库
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            // 2. 创建数据库
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS testdb");
            stmt.executeUpdate("USE testdb");

            // 3. 创建学生表 student
            String createTable = "CREATE TABLE IF NOT EXISTS student ("
                    + "id INT PRIMARY KEY,"
                    + "name VARCHAR(20),"
                    + "score INT)";
            stmt.executeUpdate(createTable);
            System.out.println(" 学生表创建成功！");

            // 4. 读取文本文件并插入数据
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\a'su's\\eclipse-workspace\\test1\\src\\Seventh\\student.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int score = Integer.parseInt(data[2]);

                String insert = "REPLACE INTO student VALUES(" + id + ",'" + name + "'," + score + ")";
                stmt.executeUpdate(insert);
            }
            br.close();
            System.out.println("✅ 文本数据已插入数据库！");

            // 5. 查询并打印所有学生成绩
            System.out.println("\n===== 所有学生成绩 =====");
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int score = rs.getInt("score");
                System.out.println("学号：" + id + "，姓名：" + name + "，成绩：" + score);
            }

            // 6. 计算平均分
            ResultSet avgRs = stmt.executeQuery("SELECT AVG(score) AS avg FROM student");
            if (avgRs.next()) {
                double avg = avgRs.getDouble("avg");
                System.out.println("\nJava 成绩平均分：" + String.format("%.2f", avg));
            }

            // 关闭资源
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}