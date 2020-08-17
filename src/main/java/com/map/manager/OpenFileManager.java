package com.map.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenFileManager {
    private Map<String, String> map = new HashMap<>();

    public void add(String extension, String software) {
        if (!map.containsKey(extension)) {
            map.put(extension, software);
        }
    }

    public String find(String extension) {
        return map.get(extension);
    }

    public void remove(String extension) {
        map.remove(extension);

    }

    public List<String> getAllExtensions() {
        return new ArrayList<>(map.keySet());
    }

    public List<String> getAllSoftware() {
        return new ArrayList<>(map.values());
    }
}
