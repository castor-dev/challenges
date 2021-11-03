package dev.castor.challenges.misc;

public class Node {

    private String label;
    private Integer value;

    public Node(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "label='" + label + '\'' +
                ", value=" + value +
                '}';
    }
}
