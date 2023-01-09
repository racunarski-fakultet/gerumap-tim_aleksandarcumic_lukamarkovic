package main.java.dsw.gerumap.app.serializer;

import com.google.gson.*;
import main.java.dsw.gerumap.app.repository.composite.MapNode;

import java.lang.reflect.Type;

public class AbstractElementAdapter implements JsonSerializer<MapNode>, JsonDeserializer<MapNode> {


    @Override
    public JsonElement serialize(MapNode mapNode, Type typeJson, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(mapNode.getClass().getSimpleName()));
        result.add("properties", context.serialize(mapNode, mapNode.getClass()));

        return result;
    }

    @Override
    public MapNode deserialize(JsonElement jsonElement, Type typeJson, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonElement element = jsonObject.get("properties");

        try {
            String naziv = jsonObject.get("name").getAsString();


            return context.deserialize(element, Class.forName("dsw.gerumap.app.gui.swing.maprepository.implementation." + naziv.substring(0, 7)));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type", cnfe);
        }
    }
}


