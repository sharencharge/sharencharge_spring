package fr.ipme.sharencharge.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fr.ipme.sharencharge.pojos.Availability;
import fr.ipme.sharencharge.pojos.Station;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomAvailibilitySerializer extends StdSerializer<List<Availability>> {

    public CustomAvailibilitySerializer() {
        this(null);
    }

    public CustomAvailibilitySerializer(Class<List<Availability>> t) {
        super(t);
    }

    @Override
    public void serialize(
            List<Availability> availabilities,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        List<Availability> avail = new ArrayList<>();
        for (Availability availibility : availabilities) {
            availibility.setStation(null);
            avail.add(availibility);
        }
        generator.writeObject(avail);
    }
}