import java.io.*;
import java.util.*;

public class InitFileLoader {

    public static void loadInventory(String filePath, Inventory inventory) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;
            if (line.startsWith("Inventory.items")) {
                line = line.substring(line.indexOf("{") + 1, line.indexOf("}")).trim();
                String[] entries = line.split(",");
                for (String entry : entries) {
                    String[] parts = entry.trim().replace("", "").split(":");
                    if (parts.length == 3) {
                        String item = parts[0].trim();
                        int qty = Integer.parseInt(parts[1].trim());
                        inventory.addItem(item, qty);
                        inventory.setCost(item, Double.parseDouble(parts[2].trim()));
                    }
                }
            }
        }
        reader.close();
    }

    public static void loadPlatter(String filePath, Map<String, Platter> platterMap) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        Platter current = null;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;

            if (line.startsWith("Platter.")) {
                String[] parts = line.split("=", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();

                String[] tokens = key.split("\\.");
                String objName = tokens[1];
                String field = tokens[2];

                if (!platterMap.containsKey(objName)) {
                    platterMap.put(objName, new Platter());
                }
                current = platterMap.get(objName);

                switch (field) {
                    case "name":
                        current.setName(value.replace("", ""));
                        break;
                    case "ingredients":
                        String cleaned = value.replace("[", "").replace("]", "").replace("\"", "");
                        current.setIngredients(Arrays.asList(cleaned.split(",")));
                        break;
                    case "cookingTime":
                        current.setCookingTime(Integer.parseInt(value));
                        break;
                    case "appliance":
                        current.setAppliance(value.replace("", ""));
                        break;
                    case "locations":
                        String locs = value.replace("[", "").replace("]", "").replace("\"", "");
                        current.setLocations(Arrays.asList(locs.split(",")));
                        break;
                    case "cost":
                        current.setCost(Double.parseDouble(value));
                        break;
                }
            }
        }
        reader.close();
    }
}