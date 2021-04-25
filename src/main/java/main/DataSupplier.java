package main;

public class DataSupplier {
    public static String[] getFlightEntities() {
        return new String[] {"{\n" +
                "    \"flightId\": 0,\n" +
                "    \"flightNumber\": 4295,\n" +
                "    \"departureAirportIATACode\": \"YYZ\",\n" +
                "    \"arrivalAirportIATACode\": \"MIT\",\n" +
                "    \"departureDate\": \"2016-09-06T10:22:29\"\n" +
                "  }",
                "  {" +
                "    \"flightId\": 1,\n" +
                "    \"flightNumber\": 4666,\n" +
                "    \"departureAirportIATACode\": \"ANC\",\n" +
                "    \"arrivalAirportIATACode\": \"GDN\",\n" +
                "    \"departureDate\": \"2019-08-06T03:28:39\"\n" +
                "  }",
                "  {" +
                "    \"flightId\": 2,\n" +
                "    \"flightNumber\": 5607,\n" +
                "    \"departureAirportIATACode\": \"SEA\",\n" +
                "    \"arrivalAirportIATACode\": \"PPX\",\n" +
                "    \"departureDate\": \"2015-06-27T09:12:35\"\n" +
                "  }",
                "  {" +
                "    \"flightId\": 3,\n" +
                "    \"flightNumber\": 5952,\n" +
                "    \"departureAirportIATACode\": \"YYZ\",\n" +
                "    \"arrivalAirportIATACode\": \"GDN\",\n" +
                "    \"departureDate\": \"2015-03-02T06:16:18\"\n" +
                "  }",
                "  {" +
                "    \"flightId\": 4,\n" +
                "    \"flightNumber\": 1649,\n" +
                "    \"departureAirportIATACode\": \"YYT\",\n" +
                "    \"arrivalAirportIATACode\": \"GDN\",\n" +
                "    \"departureDate\": \"2019-08-21T09:23:19\"\n" +
                "  }"};
    }

    public static String[] getCargoEntities() {
        return new String[] {"{\n" +
                "    \"flightId\": 0,\n" +
                "    \"baggage\": [\n" +
                "      {\n" +
                "        \"id\": 0,\n" +
                "        \"weight\": 287,\n" +
                "        \"weightUnit\": \"kg\",\n" +
                "        \"pieces\": 700\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"weight\": 628,\n" +
                "        \"weightUnit\": \"kg\",\n" +
                "        \"pieces\": 879\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2,\n" +
                "        \"weight\": 913,\n" +
                "        \"weightUnit\": \"kg\",\n" +
                "        \"pieces\": 424\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 3,\n" +
                "        \"weight\": 53,\n" +
                "        \"weightUnit\": \"lb\",\n" +
                "        \"pieces\": 12\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 4,\n" +
                "        \"weight\": 41,\n" +
                "        \"weightUnit\": \"lb\",\n" +
                "        \"pieces\": 358\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 5,\n" +
                "        \"weight\": 997,\n" +
                "        \"weightUnit\": \"lb\",\n" +
                "        \"pieces\": 134\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 6,\n" +
                "        \"weight\": 927,\n" +
                "        \"weightUnit\": \"lb\",\n" +
                "        \"pieces\": 365\n" +
                "      }\n" +
                "    ],\n" +
                "    \"cargo\": [\n" +
                "      {\n" +
                "        \"id\": 0,\n" +
                "        \"weight\": 508,\n" +
                "        \"weightUnit\": \"kg\",\n" +
                "        \"pieces\": 598\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"weight\": 715,\n" +
                "        \"weightUnit\": \"kg\",\n" +
                "        \"pieces\": 930\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2,\n" +
                "        \"weight\": 430,\n" +
                "        \"weightUnit\": \"lb\",\n" +
                "        \"pieces\": 805\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 3,\n" +
                "        \"weight\": 808,\n" +
                "        \"weightUnit\": \"lb\",\n" +
                "        \"pieces\": 517\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 4,\n" +
                "        \"weight\": 785,\n" +
                "        \"weightUnit\": \"lb\",\n" +
                "        \"pieces\": 888\n" +
                "      }\n" +
                "    ]\n" +
                "  }",
                "  {\n" +
                        "    \"flightId\": 1,\n" +
                        "    \"baggage\": [\n" +
                        "      {\n" +
                        "        \"id\": 0,\n" +
                        "        \"weight\": 234,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 863\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"weight\": 858,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 292\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"weight\": 86,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 504\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 3,\n" +
                        "        \"weight\": 21,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 981\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 4,\n" +
                        "        \"weight\": 179,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 248\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 5,\n" +
                        "        \"weight\": 60,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 149\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 6,\n" +
                        "        \"weight\": 537,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 301\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 7,\n" +
                        "        \"weight\": 496,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 504\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"cargo\": [\n" +
                        "      {\n" +
                        "        \"id\": 0,\n" +
                        "        \"weight\": 185,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 282\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"weight\": 911,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 486\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"weight\": 30,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 279\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }",
                "  {\n" +
                        "    \"flightId\": 2,\n" +
                        "    \"baggage\": [\n" +
                        "      {\n" +
                        "        \"id\": 0,\n" +
                        "        \"weight\": 299,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 577\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"weight\": 713,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 355\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"weight\": 873,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 923\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 3,\n" +
                        "        \"weight\": 210,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 894\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"cargo\": [\n" +
                        "      {\n" +
                        "        \"id\": 0,\n" +
                        "        \"weight\": 762,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 390\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"weight\": 124,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 65\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"weight\": 852,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 763\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }",
                "  {\n" +
                        "    \"flightId\": 3,\n" +
                        "    \"baggage\": [\n" +
                        "      {\n" +
                        "        \"id\": 0,\n" +
                        "        \"weight\": 638,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 438\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"weight\": 723,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 506\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"weight\": 69,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 8\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 3,\n" +
                        "        \"weight\": 846,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 897\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"cargo\": [\n" +
                        "      {\n" +
                        "        \"id\": 0,\n" +
                        "        \"weight\": 423,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 998\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"weight\": 995,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 265\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"weight\": 795,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 474\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }",
                "  {\n" +
                        "    \"flightId\": 4,\n" +
                        "    \"baggage\": [\n" +
                        "      {\n" +
                        "        \"id\": 0,\n" +
                        "        \"weight\": 987,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 788\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"weight\": 218,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 47\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"weight\": 830,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 182\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 3,\n" +
                        "        \"weight\": 473,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 27\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"cargo\": [\n" +
                        "      {\n" +
                        "        \"id\": 0,\n" +
                        "        \"weight\": 769,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 299\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"weight\": 309,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 360\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"weight\": 784,\n" +
                        "        \"weightUnit\": \"kg\",\n" +
                        "        \"pieces\": 397\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 3,\n" +
                        "        \"weight\": 288,\n" +
                        "        \"weightUnit\": \"lb\",\n" +
                        "        \"pieces\": 422\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }"};
    }
    static String test = "[\n" +
            "  {\n" +
            "    \"flightId\": 0,\n" +
            "    \"flightNumber\": 3103,\n" +
            "    \"departureAirportIATACode\": \"YYT\",\n" +
            "    \"arrivalAirportIATACode\": \"KRK\",\n" +
            "    \"departureDate\": \"2019-03-18T12:29:40-01:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"flightId\": 1,\n" +
            "    \"flightNumber\": 5966,\n" +
            "    \"departureAirportIATACode\": \"YYT\",\n" +
            "    \"arrivalAirportIATACode\": \"LEW\",\n" +
            "    \"departureDate\": \"2016-08-04T06:11:37-02:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"flightId\": 2,\n" +
            "    \"flightNumber\": 2493,\n" +
            "    \"departureAirportIATACode\": \"YYZ\",\n" +
            "    \"arrivalAirportIATACode\": \"LEW\",\n" +
            "    \"departureDate\": \"2019-07-05T03:08:00-02:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"flightId\": 3,\n" +
            "    \"flightNumber\": 6209,\n" +
            "    \"departureAirportIATACode\": \"LAX\",\n" +
            "    \"arrivalAirportIATACode\": \"PPX\",\n" +
            "    \"departureDate\": \"2019-11-16T11:06:24-01:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"flightId\": 4,\n" +
            "    \"flightNumber\": 4708,\n" +
            "    \"departureAirportIATACode\": \"LAX\",\n" +
            "    \"arrivalAirportIATACode\": \"MIT\",\n" +
            "    \"departureDate\": \"2015-01-30T05:39:06-01:00\"\n" +
            "  }\n" +
            "]";
}
