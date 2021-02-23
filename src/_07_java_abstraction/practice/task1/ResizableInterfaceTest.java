package _07_java_abstraction.practice.task1;

public class ResizableInterfaceTest {
    public static void main(String[] args) {

        //Create an array of Resizable variables.
        Resizable[] resizableShapes = new Resizable[3];

        //Fill up the array with shapes.
        resizableShapes[0] = new Circle("orange", true, 5);
        resizableShapes[1] = new Rectangle("black", false, 4, 5);
        resizableShapes[2] = new Square("white", false, 6);

        System.out.println("Pre-resized");
        for (Resizable s : resizableShapes) {
            System.out.println(s.toString());
        }

        //Resize dimensions of shapes.
        for (int i = 0; i < resizableShapes.length; i++) {
            resizableShapes[i].resize((i + 1) * 10);
        }

        System.out.println("-----------------------------------");
        System.out.println("After-resized:");
        for (Resizable s : resizableShapes) {
            System.out.println(s.toString());
        }
    }
}
