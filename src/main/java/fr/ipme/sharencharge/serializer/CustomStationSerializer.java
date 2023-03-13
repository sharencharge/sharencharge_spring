package fr.ipme.sharencharge.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fr.ipme.sharencharge.pojos.Station;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomStationSerializer extends StdSerializer<List<Station>> {

    public CustomStationSerializer() {
        this(null);
    }

    public CustomStationSerializer(Class<List<Station>> t) {
        super(t);
    }

    @Override
    public void serialize(
            List<Station> stations,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        List<Station> stats = new ArrayList<>();
        for (Station station : stations) {
            station.setUser(null);
            stats.add(station);
        }
        generator.writeObject(stats);
    }
}
