package test;
import java.sql.*;
import java.io.*;

public class Task6 {
    public static void main(String[] args) throws Exception {
        // 配置信息合并声明
        String url = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
        String user = "root", pwd = "1111111111";
        String filePath = "C:\\Users\\a'su's\\eclipse-workspace\\test1\\src\\Seventh\\student.txt";

        // try-with-resources：所有资源自动关闭，无需手动写close
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             Statement stmt = conn.createStatement();
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // 1. 建库 + 切库 + 建表，三步合并
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS testdb");
            stmt.execute("USE testdb");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS student(id INT PRIMARY KEY,name VARCHAR(20),score INT)");

            // 2. 逐行读文件，直接插入数据库
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                stmt.executeUpdate(String.format("REPLACE INTO student VALUES(%s,'%s',%s)", d[0], d[1], d[2]));
            }

            // 3. 查询并打印所有学生
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            while (rs.next())
                System.out.printf("学号：%d 姓名：%s 成绩：%d%n", rs.getInt(1), rs.getString(2), rs.getInt(3));

            // 4. 计算并打印平均分
            rs = stmt.executeQuery("SELECT AVG(score) FROM student");
            if (rs.next()) System.out.printf("平均分：%.2f%n", rs.getDouble(1));
        }
    }
}