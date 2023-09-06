package edu.hillel.lesson9;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        Apple[] applesArray = new Apple[2];
        Orange[] orangesArray = new Orange[3];
        for (int i = 0; i < applesArray.length; i++) {
            applesArray[i] = new Apple();
        }
        for (int i = 0; i < orangesArray.length; i++) {
            orangesArray[i] = new Orange();
        }

        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox2.add(applesArray);

        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox2.add(orangesArray);

        System.out.println("1st apples box weight: " + appleBox1.getWeight());
        System.out.println("2nd apples box weight: " + appleBox2.getWeight());
        System.out.println("1st oranges box weight: " + orangeBox1.getWeight());
        System.out.println("2nd oranges box weight: " + orangeBox2.getWeight());

        System.out.println("Is 1st apples box equal to 2nd apples box: " + appleBox1.compare(appleBox2));
        System.out.println("Is 1st oranges box equal to 2nd oranges box: " + orangeBox1.compare(orangeBox2));
        System.out.println("Is 1st apples box equal to 1st oranges box: " + appleBox1.compare(orangeBox1));

        appleBox1.merge(appleBox2);
        orangeBox1.merge(orangeBox2);

        System.out.println("1st apples box weight after merging: " + appleBox1.getWeight());
        System.out.println("2nd apples box weight after merging: " + appleBox2.getWeight());
        System.out.println("1st oranges box weight after merging: " + orangeBox1.getWeight());
        System.out.println("2nd oranges box weight after merging: " + orangeBox2.getWeight());
    }
}
