package Clinic.Clinic.domain.model.ValOb;

public class Adress {
    private final String line;
    
    private Adress(String line) {
        this.line = line;
    }
    
    public static Adress of(String line) {
        if (line == null || line.trim().isEmpty() || line.length() > 30) {
            throw new IllegalArgumentException("Dirección inválida (máximo 30 caracteres)");
        }
        return new Adress(line.trim());
    }
    
    public int length() { return line.length(); }
    public String getLine() { return line; }
}