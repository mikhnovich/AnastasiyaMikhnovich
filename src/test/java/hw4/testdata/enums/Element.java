package hw4.testdata.enums;

import org.apache.commons.lang3.StringUtils;

public enum Element {

    DEFAULT {
        @Override
        public String toString() {
            return StringUtils.EMPTY;
        }
    },

    WATER {
        @Override
        public String toString() {
            return "Water";
        }
    },

    EARTH {
        @Override
        public String toString() {
            return "Earth";
        }
    },

    WIND {
        @Override
        public String toString() {
            return "Wind";
        }
    },

    FIRE {
        @Override
        public String toString() {
            return "Fire";
        }
    }
}
