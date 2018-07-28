package com.sachet;
import java.util.*;
import java.io.*;
public class Locations implements Map<Integer,Location>{
    static Map<Integer,Location> location = new HashMap<>();
    static{
//        Scanner scan = null;
//        try{
//            scan = new Scanner(new BufferedReader(new FileReader("locations_big.txt")));
//            scan.useDelimiter(",");
//            while(scan.hasNextLine()){
//                int loc = scan.nextInt();
//                scan.skip(scan.delimiter());
//                String description = scan.nextLine();
//                Location locd = new Location(loc,description);
//                location.put(loc,locd);
//                System.out.println(locd.getLocationId()+", "+locd.getDescription());
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }finally{
//            if(scan!=null)scan.close();
//        }
//        try{
//            scan = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
//            scan.useDelimiter(",");
//            while(scan.hasNextLine()){
//                int loc = scan.nextInt();
//                scan.skip(scan.delimiter());
//                String direction = scan.next();
//                scan.skip(scan.delimiter());
//                String dest = scan.nextLine();
//                int destination = Integer.parseInt(dest);
//                System.out.println(loc+","+direction+","+destination);
//                Location locd = location.get(loc);
//                locd.addExits(direction,destination);
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }finally{
//            if(scan!=null)scan.close();
//        }
        /*We may do it as above or as below*/
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader("locations_big.txt")));
        Scanner dir = new Scanner(new BufferedReader(new FileReader("directions_big.txt")))){
            scan.useDelimiter(",");
            while(scan.hasNextLine()){
                String[] y = scan.nextLine().split(",");
                int loc = Integer.parseInt(y[0]);
                String description = y[1];
                System.out.println(loc+","+description);
                Location load = new Location(loc,description);
                location.put(loc,load);
            }
            dir.useDelimiter(",");
            while(dir.hasNextLine()){
                String[]j = dir.nextLine().split(",");
                int loc = Integer.parseInt(j[0]);
                String direction = j[1];
                int destination = Integer.parseInt(j[2]);
                Location load = location.get(loc);
                System.out.println(loc+","+direction+","+destination);
                load.addExits(direction, destination);
            }
        }catch(IOException e){}
    }

    @Override
    public int size() {
        return location.size();
    }
    @Override
    public boolean isEmpty() {
        return location.isEmpty();
    }
    @Override
    public boolean containsKey(Object key) {
        return location.containsKey(key);
    }
    @Override
    public boolean containsValue(Object value) {
        return location.containsValue(value);
    }
    @Override
    public Location get(Object key) {
        return location.get(key);
    }
    @Override
    public Location put(Integer key, Location value) {
        return location.put(key,value);
    }
    @Override
    public Location remove(Object key) {
        return location.remove(key);
    }
    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }
    @Override
    public void clear() {
        location.clear();
    }
    @Override
    public Set<Integer> keySet() {
        return location.keySet();
    }
    @Override
    public Collection<Location> values() {
        return location.values();
    }
    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return location.entrySet();
    }
}
