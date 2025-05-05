package at.spengergasse;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ Entity
@Table(name = "w_weather_data")
public class Weather_Data {
    @Id
    @Column(name = "w_temperature")
    private float temperature;





}
