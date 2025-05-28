package eidi2.sose25.weber.felix.lesson.linkedListExample;

public class LinkedListImpl {

    public static void main(String[] args) {
        ListElement listElement1 = new ListElement("Wert 1");
        ListElement listElement2 = new ListElement("Wert 2");
        listElement1.setNextElement(listElement2);
        ListElement listElement3 = new ListElement("Wert 3");
        listElement2.setNextElement(listElement3);

        ListElement start = listElement1;
        while(start != null) {
            System.out.println(start.getValue());
            start = start.getNextElement();
        }
    }

}
