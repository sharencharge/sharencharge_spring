package fr.ipme.sharencharge.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fr.ipme.sharencharge.pojos.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomUserSerializer extends StdSerializer<User> {

    public CustomUserSerializer() {
        this(null);
    }

    public CustomUserSerializer(Class<User> t) {
        super(t);
    }

    @Override
    public void serialize(
            User user,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        user.setStations(null);
        user.setRents(null);

        generator.writeObject(user);
    }
}
