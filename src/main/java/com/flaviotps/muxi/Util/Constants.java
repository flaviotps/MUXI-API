package com.flaviotps.muxi.Util;

public class Constants {


    //HASH MAP KEY
    public static final String PROPERTY_LOGIC = "logic";
    public static final String PROPERTY_SERIAL = "serial";
    public static final String PROPERTY_MODEL = "model";
    public static final String PROPERTY_SAM = "sam";
    public static final String PROPERTY_PTID = "ptid";
    public static final String PROPERTY_PLAT = "plat";
    public static final String PROPERTY_VERSION = "version";
    public static final String PROPERTY_MXR = "mxr";
    public static final String PROPERTY_MXF = "mxf";
    public static final String PROPERTY_VERFM = "VERFM";


    //PAYLOAD PARSE INDEX
    public static final int INDEX_LOGIC = 0;
    public static final int INDEX_SERIAL = 1;
    public static final int INDEX_MODEL = 2;
    public static final int INDEX_SAM = 3;
    public static final int INDEX_PTID = 4;
    public static final int INDEX_PLAT = 5;
    public static final int INDEX_VERSION = 6;
    public static final int INDEX_MXR = 7;
    public static final int INDEX_MXF = 8;
    public static final int INDEX_VERFM = 9;
    public static final String PAYLOAD_DIVIDER = ";";

    //ERROR
    public static final String ENTITY_DUPLICATED = "An entity with the same logic attribute already exists";
    public static final String ENTITY_NOT_FOUND = "An entity with this attribute <logic> cannot be found";
    public static final String PARSE_ERROR = "invalid payload, wrong format";
    public static final String UNKNOWN = "unknown error";
    public static final String INVALID_PAYLOAD = "invalid payload, wrong format";
    public static final String INVALID_JSON_SCHEMA = "your payload doesn't match the json schema";

    //SCHEMA
    public static final String JSON_SCHEMA = "{\n" +
            "  \"title\": \"Terminal\",\n" +
            "  \"type\": \"object\",\n" +
            "  \"properties\": {\n" +
            "    \"logic\": {\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"serial\": {\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"sam\": {\n" +
            "      \"type\": \"integer\",\n" +
            "      \"minimum\": 0\n" +
            "    },\n" +
            "    \"ptid\": {\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"plat\": {\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"version\": {\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"mxr\": {\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"VERFM\": {\n" +
            "      \"type\": \"string\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"required\": [\n" +
            "    \"logic\",\n" +
            "    \"serial\",\n" +
            "    \"model\",\n" +
            "    \"version\"\n" +
            "  ]\n" +
            "}";
}
