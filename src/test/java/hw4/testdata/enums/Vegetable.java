package hw4.testdata.enums;

public enum Vegetable {

    CUCUMBER {
        @Override
        public String toString() {
            return "Cucumber";
        }
    },

    TOMATO {
        @Override
        public String toString() {
            return "Tomato";
        }
    },

    VEGETABLES {
        @Override
        public String toString() {
            return "Vegetables";
        }
    },

    ONION {
        @Override
        public String toString() {
            return "Onion";
        }
    }
}
