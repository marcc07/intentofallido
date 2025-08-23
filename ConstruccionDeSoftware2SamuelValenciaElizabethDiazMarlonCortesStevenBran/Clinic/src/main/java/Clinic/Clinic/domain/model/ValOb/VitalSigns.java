package Clinic.Clinic.domain.model.ValOb;



import java.math.BigDecimal;

public class VitalSigns {
    private final String bloodPressure;
    private final BigDecimal temperatureC;
    private final int pulse;
    private final int oxygenSat;
    

    private VitalSigns(String bloodPressure, BigDecimal temperatureC, int pulse, int oxygenSat) {
        this.bloodPressure = bloodPressure;
        this.temperatureC = temperatureC;
        this.pulse = pulse;
        this.oxygenSat = oxygenSat;
    }
    
    
    public static VitalSigns of(String bloodPressure, double temperature, int pulse, int oxygenSat) {
        if (bloodPressure == null) {
            throw new IllegalArgumentException("La presión arterial es requerida");
        }
        return new VitalSigns(bloodPressure, BigDecimal.valueOf(temperature), pulse, oxygenSat);
    }
    
    
    public static VitalSigns of(String bloodPressure, BigDecimal temperatureC, int pulse, int oxygenSat) {
        if (bloodPressure == null || temperatureC == null) {
            throw new IllegalArgumentException("Parámetros requeridos");
        }
        return new VitalSigns(bloodPressure, temperatureC, pulse, oxygenSat);
    }
    
    public boolean isPlausible() {
        return temperatureC.compareTo(new BigDecimal("34.0")) >= 0 &&
               temperatureC.compareTo(new BigDecimal("42.0")) <= 0 &&
               pulse >= 40 && pulse <= 200 &&
               oxygenSat >= 70 && oxygenSat <= 100;
    }
    
    // Getters
    public String getBloodPressure() { return bloodPressure; }
    public BigDecimal getTemperatureC() { return temperatureC; }
    public int getPulse() { return pulse; }
    public int getOxygenSat() { return oxygenSat; }
}