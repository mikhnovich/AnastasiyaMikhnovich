package hw4.testdata.enums;

public enum Colour {

    COLORS {
        @Override
        public String toString() {
            return "Colors";
        }
    },

    RED {
        @Override
        public String toString() {
            return "Red";
        }
    },

    GREEN {
        @Override
        public String toString() {
            return "Green";
        }
    },

    BLUE {
        @Override
        public String toString() {
            return "Blue";
        }
    },

    YELLOW {
        @Override
        public String toString() {
            return "Yellow";
        }
    }
}
