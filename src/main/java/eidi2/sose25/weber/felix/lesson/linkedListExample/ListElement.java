package eidi2.sose25.weber.felix.lesson.linkedListExample;

public class ListElement {

    private ListElement nextElement = null;
    private String value;

    public ListElement(String value) {
        this.value = value;
    }

    public ListElement getNextElement() {
        return this.nextElement;
    }

    public void setNextElement(ListElement nextElement) {
        this.nextElement = nextElement;
    }

    public String getValue() {
        return this.value;
    }
}
