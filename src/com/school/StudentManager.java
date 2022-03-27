package com.school;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            {
                System.out.println("---学生管理系统---");
                System.out.println("1 添加学生");
                System.out.println("2 删除学生");
                System.out.println("3 修改学生");
                System.out.println("4 查看所有学生");
                System.out.println("5 退出系统");
                System.out.printf("请输入你的选择:");


                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();
                switch (line) {
                    case "1":
                        System.out.println("添加学生");
                        addStudent(array);
                        break;
                    case "2":
                        System.out.println("删除学生");
                        deleteStudent(array);
                        break;
                    case "3":
                        System.out.println("修改学生");
                        changeStudent(array);
                        break;
                    case "4":
                        System.out.println("查看所有学生");
                        findAllStudent(array);
                        break;
                    case "5":
                        System.out.println("退出系统成功，谢谢使用");
                        return;
                }
            }
        }
    }//学籍管理系统主界面

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
            System.out.printf("请输入学生学号：");
            sid = sc.nextLine();
            boolean flag = sidUsde(array, sid);
            if (flag) {
                System.out.println("您输入的学号已经存在，请重新输入");
            } else {
                break;
            }
        }
        System.out.printf("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.printf("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.printf("请输入学生居住地：");
        String address = sc.nextLine();
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加学生成功！");
    }//添加学生

    public static void findAllStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查看！");
        } else {
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println("学号：" + s.getSid() + "\t" + "姓名：" + s.getName() + "\t" + "年龄：" + s.getAge() + "岁\t" + "居住地：" + s.getAddress());
            }
        }
    }//查看所有学生

    public static void deleteStudent(ArrayList<Student> array) {
        int index = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除学生的学号");
        String sid = sc.nextLine();
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该学号不存在，请重新输入");
        } else {
            array.remove(index);
            System.out.println("删除学生成功");
        }
    }//删除学生

    public static void changeStudent(ArrayList<Student> array) {
        int index = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的学号");
        String sid = sc.nextLine();
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该学号不存在，请重新输入");
        } else {
            System.out.println("请输入学生新姓名");
            String name = sc.nextLine();
            System.out.println("请输入学生新年龄");
            String age = sc.nextLine();
            System.out.println("请输入学生新居住地");
            String address = sc.nextLine();
            Student s = new Student();
            s.setSid(sid);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);
            for (int i = 0; i < array.size(); i++) {
                Student student = array.get(i);
                if (student.getSid().equals(sid)) {
                    array.set(i, s);
                    break;
                }
            }
            System.out.println("修改学生成功");
        }
    }//修改学生

    public static boolean sidUsde(ArrayList<Student> array, String sid) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}