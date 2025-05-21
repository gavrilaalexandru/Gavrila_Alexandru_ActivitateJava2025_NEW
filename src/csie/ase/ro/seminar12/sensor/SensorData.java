package csie.ase.ro.seminar12.sensor;

public class SensorData {
    private int humidity;
    private float temperature;

    public SensorData(int humidity, float temperature) {
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SensorData{");
        sb.append("humidity=").append(humidity);
        sb.append(", temperature=").append(temperature);
        sb.append('}');
        return sb.toString();
    }
}
