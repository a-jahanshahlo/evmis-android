package ir.jahanshahloo.evmis.Util;

import android.text.TextUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ali on 10/13/16.
 */
public class DotNetDateConverter extends TypeAdapter<Date> {
    @Override
    public Date read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        Date result = null;
        String str = reader.nextString();
        str = str.replaceAll("[^0-9]", "");
        if (!TextUtils.isEmpty(str)) {
            try {
                result = new Date(Long.parseLong(str));
            } catch (NumberFormatException e) {
            }
        }
        return result;
    }
    @Override
    public void write(JsonWriter writer, Date value) throws IOException {
        // Nah..
    }


}
