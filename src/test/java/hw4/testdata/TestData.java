package hw4.testdata;

import hw4.testdata.enums.Colour;
import hw4.testdata.enums.Element;
import hw4.testdata.enums.Metal;
import hw4.testdata.enums.Vegetable;

import java.util.List;

import static java.util.Collections.singletonList;

public class TestData {

    private final String summaryLine1;
    private final String summaryLine2;
    private final Colour colors;
    private final List<Element> elements;
    private final Metal metals;
    private final List<Vegetable> vegetables;

    private TestData(String summaryLine1, String summaryLine2, Colour colors, List<Element> elements, Metal metals, List<Vegetable> vegetables) {
        this.summaryLine1 = summaryLine1;
        this.summaryLine2 = summaryLine2;
        this.colors = colors;
        this.elements = elements;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public String getSummaryLine1() {
        return summaryLine1;
    }

    public String getSummaryLine2() {
        return summaryLine2;
    }

    public Colour getColors() {
        return colors;
    }

    public List<Element> getElements() {
        return elements;
    }

    public Metal getMetals() {
        return metals;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public static class Builder {
        private String summaryLine1 = "1";
        private String summaryLine2 = "2";
        private Colour colors = Colour.COLORS;
        private List<Element> elements = singletonList(Element.DEFAULT);
        private Metal metals = Metal.METALS;
        private List<Vegetable> vegetables = singletonList(Vegetable.VEGETABLES);

        public Builder() {

        }

        public Builder setSummaryLine1(String summaryLine1) {
            this.summaryLine1 = summaryLine1;
            return this;
        }

        public Builder setSummaryLine2(String summaryLine2) {
            this.summaryLine2 = summaryLine2;
            return this;
        }

        public Builder setColors(Colour colors) {
            this.colors = colors;
            return this;
        }

        public Builder setElements(List<Element> elements) {
            this.elements = elements;
            return this;
        }

        public Builder setMetals(Metal metals) {
            this.metals = metals;
            return this;
        }

        public Builder setVegetables(List<Vegetable> vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public TestData build() {
            return new TestData(summaryLine1, summaryLine2, colors, elements, metals, vegetables);
        }
    }
}
