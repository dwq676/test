package com.quantil.common;

/**
 * Notes
 *
 * @author <a href="mailto:wenqing.dai@quantil.com">daiwenqing</a>
 * @date 2017/4/13
 */
public class Notes {

    public static final String RESPONSE_HEAD = "### Response example \n " +
            "#### Code \n" +
            "\n ```json \n" +
            " - 200 = OK \n" +
            " - 501 = server error \n" +
            " - 404 = not found \n" +
            " - 401 = unauthorized \n ```";

    public static final String IPS_REQUEST =
            "\n### Request example \n```java \n{\n" +
                    "  \"data\": [\n" +
                    "    \"8.8.8.8\",\"3.3.3.3\"\n" +
                    "  ]\n" +
                    "} \n ``` \n ---\n";
    public static final String IPS_RESPONSE =
            "\n```json \n{\n" +
                    "\"code\":200,\n" +
                    "\"data\": [\n" +
                    "    {\n" +
                    "      \"IPS\": {\n" +
                    "       \"CV\": \"*\",\n" +
                    "       \"ID\": \"11657\",\n" +
                    "       \"IPHEAD\": 134744064,\n" +
                    "       \"IPHEADA\": \"8.8.8.0\",\n" +
                    "       \"IPTAIL\": 134744319,\n" +
                    "       \"IPTAILA\":\"8.8.8.255\",\n" +
                    "       \"VIEW_ID\": \"cbe866bce79ebffe5dfc9cc15d48001a\"\n" +
                    "      },\n" +
                    "      \"IP\": \"8.8.8.8\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    " \"message\": \"ok\" \n" +
                    " \"success\": true\n" +
                    "}\n```\n";

    public static final String IPS_DETECTION_RESPONSE =
            "\n```json \n{\n" +
                    "  \"code\": \"200\",\n" +
                    "  \"data\": [\n" +
                    "    {\n" +
                    "      \"IP\": \"8.8.8.8\",\n" +
                    "      \"IPS\": {\n" +
                    "        \"RES\": \"1\",\n" +
                    "        \"RCV_TIME\": \"2017-04-18 16:54:02\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"message\": \"ok\"\n" +
                    "  \"success\": true\n" +
                    "}\n``` ";

    public static final String IPS_2_POP_REQUEST =
            "\n### Request example \n ```java \n {\n" +
                    "  \"data\": {\n" +
                    "     \"IPS_ID\":[\n" +
                    "        3238,11657\n" +
                    "     ],\n" +
                    "    \"POP_ID\":[\n" +
                    "        4\n" +
                    "     ]\n" +
                    "  }\n" +
                    "} \n ```\n";

    public static final String QOS_MPING_REQUEST = "\n### Request example \n \n```json  \ncbe866bce79ebffe5dfc9cc15d48001a  \n``` ";
    public static final String QOS_MPING_RESPONSE =
            "\n```json \n{\n" +
                    " \"code\": \"200\",\n" +
                    " \"data\": [\n" +
                    "    {\n" +
                    "      \"VPQOS_CURRENT\": 22,\n" +
                    "      \"POP_IPMS\": \"220.243.226.0/24\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    " \"message\": \"ok\"\n" +
                    " \"success\": true\n" +
                    "} \n ```\n";

    public static final String QOS_MPING_RESPONSE_WITH_IP =
            "\n```json \n{\n" +
                    "  \"code\": \"200\",\n" +
                    "  \"data\": [\n" +
                    "    {\n" +
                    "      \"IP\": \"8.8.8.8\",\n" +
                    "      \"VIEW2POP\": [\n" +
                    "        {\n" +
                    "          \"VPQOS_CURRENT\": 177,\n" +
                    "          \"POP_IPMS\": \"207.226.247.0/24\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"IP\": \"3.3.3.3\",\n" +
                    "      \"VIEW2POP\": []\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"message\": \"ok\",\n" +
                    "  \"success\": true\n" +
                    "} \n ```\n";

    public static final String DELETED = "deleted";
    public static final String CREATED_AT = "created_at";
    public static final String CREATED_BY = "created_by";
    public static final String UPDATED_AT = "updated_at";
    public static final String UPDATED_BY = "updated_by";
}
