package com.sachet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static Locations locations = new Locations();
    static class Read{
        BufferedReader br;
        StringTokenizer st;
        public Read(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String nxL(){
            try{return br.readLine();}catch(Exception e){return null;}
        }
        int nint(){
            while(st==null||!st.hasMoreElements()){
                try{st = new StringTokenizer(br.readLine());}catch(Exception e){}
            }
            return Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("EAST", "E");
        map.put("WEST", "W");
        map.put("NORTH", "N");
        map.put("SOUTH", "S");
        map.put("SOUTHEAST", "SE");
        map.put("SOUTHWEST", "SW");
        map.put("NORTHEAST", "NE");
        map.put("NORTHWEST", "NW");
        map.put("UP", "U");
        map.put("DOWN", "D");
        map.put("QUIT", "Q");
        Read in = new Read();
        int loc = 1;
        String dir;
        String[] containDir;
        while (true) {
            System.out.println("-->" + locations.get(loc).getDescription());
            if (loc == 0) break;
            System.out.println("Available Exits are:");
            for (String k : locations.get(loc).getExits().keySet()) {
                System.out.print(k + ", ");
            }
            dir = in.nxL().toUpperCase();
            if(dir.length()>1){
                containDir = dir.split(" ");
                for(String key:containDir){
                    if(map.containsKey(key)) {
                        dir = map.get(key);
                        break;
                    }
                }
            }
            try{
                loc = locations.get(loc).getExits().get(dir.toUpperCase());
            }catch(NullPointerException e){
                System.out.println("The entered location doesn't exist");
            }
        }
    }
}
