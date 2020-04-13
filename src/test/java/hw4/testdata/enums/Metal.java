package hw4.testdata.enums;

public enum Metal {

    METALS {
        @Override
        public String toString() {
            return "Metals";
        }
    },

    GOLD {
        @Override
        public String toString() {
            return "Gold";
        }
    },

    SILVER {
        @Override
        public String toString() {
            return "Silver";
        }
    },

    BRONZE {
        @Override
        public String toString() {
            return "Bronze";
        }
    },

    SELEN {
        @Override
        public String toString() {
            return "Selen";
        }
    }
}
