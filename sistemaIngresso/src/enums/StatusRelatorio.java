package enums;

public enum StatusRelatorio {

    Lucro, Estavel, 
    Prejuizo {
        public String toString() {
            return "Prejuízo";
        }
    }

}
