package fr.ipme.sharencharge.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fr.ipme.sharencharge.pojos.Station;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CustomStationASerializer extends StdSerializer<Station> {

public CustomStationASerializer() {
        this(null);
        }

public CustomStationASerializer(Class<Station> t) {
        super(t);
        }

@Override
public void serialize(
        Station stations,
        JsonGenerator generator,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {

        Station stats = new Station();

            stations.setAvailabilities(null);

         generator.writeObject(stations);
        }
    }