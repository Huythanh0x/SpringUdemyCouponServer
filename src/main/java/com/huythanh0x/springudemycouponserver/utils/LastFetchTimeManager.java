package com.huythanh0x.springudemycouponserver.utils;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LastFetchTimeManager {
    public void dumpFetchedTimeJsonToFile() {
        String jsonFilePath = "fetched_time.json";
        var resultJson = new JSONObject();
        resultJson.put("localTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
            fileWriter.write(resultJson.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Long loadLasFetchedTimeInMilliSecond() {
        try {
            String couponsJson = new String(Files.readAllBytes(Paths.get("fetched_time.json")));
            var responseJsonObject = new JSONObject(couponsJson);
            var dateTimeString = responseJsonObject.getString("localTime");
            var formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            var localDateTime = LocalDateTime.parse(dateTimeString, formatter);
            return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        } catch (IOException e) {
            return (long) Integer.MIN_VALUE;
        }
    }
}
