package 树.searchtree;

import 树.file.Files;
import 树.printer.BinaryTrees;

import java.util.Comparator;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();

        BinarySearchTree<Person> personTree = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        int[] arr = new int[]{12, 7, 21, 11, 5, 33, 9, 24, 43};
        for (int i = 0; i < arr.length; i++) {
            tree1.add(arr[i]);
        }

        BinaryTrees.println(tree1);
        tree1.getHeight();
        tree1.levelOrderTraverse();
        tree1.qianxu(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element+"---");
                return element == 11 ? true : false;
            }
        });
//        String str = BinaryTrees.printString(tree1);
//        str = str + "\n";
//        Files.writeToFile("D:/tree.txt", str);
        //传入person对象进行查找
        Random ran = new Random();
        for (int i = 0; i < 15; i++) {
            personTree.add(new Person(ran.nextInt(70)));
        }
//        BinaryTrees.println(personTree);

    }
}

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "age = " + age;
    }
}
