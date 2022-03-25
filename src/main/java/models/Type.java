package models;

public enum Type {
    LODGING {
        @Override
        public String toString() {
            return "LODGING";
        }
    },
    FOOD {
        @Override
        public String toString() {
            return "FOOD";
        }
    },
    TRAVEL {
        @Override
        public String toString() {
            return "TRAVEL";
        }
    }
}
