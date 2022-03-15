package com.solid.algolearning.javacode.algorithms.prep_problems;

import java.util.*;

public class TrainSchedules {
//    Implement an algorithm that returns a boolean whether someone can attend a meeting starting XX:XX in city Y

    static class Schedule {
        String dCity;
        String dTime;
        String aCity;
        String aTime;


        public Schedule(String dCity, String dTime, String aCity, String aTime) {
            this.dCity = dCity;
            this.dTime = dTime;
            this.aCity = aCity;
            this.aTime = aTime;
        }
    }


    public static void main(String args[]) {
        ArrayList<Schedule> trainSchedules = new ArrayList<>();

        trainSchedules.add(new Schedule("BOS", "9:30", "MTV", "16:00"));
        trainSchedules.add(new Schedule("BOS", "10:00", "NYC", "16:00"));
        trainSchedules.add(new Schedule("NYC", "13:30", "DC", "16:30"));
        trainSchedules.add(new Schedule("NYC", "14:30", "DC", "18:00"));
        trainSchedules.add(new Schedule("DC", "15:00", "NYC", "18:00"));
        trainSchedules.add(new Schedule("DC", "16:00", "ATL", "22:00"));
        trainSchedules.add(new Schedule("NYC", "13:00", "BOS", "21:00"));

        System.out.println(checkLink("BOS", "MTV", trainSchedules, "15:00"));
    }


    //this method checks if there is a link between the departure city and the arrival city
    static boolean checkLink(String deptCity, String arrivalCity, ArrayList<Schedule> trainSchedules, String meetTime) {
        if(deptCity.isEmpty() || arrivalCity.isEmpty()) return false;

        Map<String, Map<String, String>> adj = new HashMap<>();
        Set<String> visited = new HashSet<>();

        //get int equivalent for meeting time.
        int[] meetingTime = getTimeIntEquivalent(meetTime);
        int hr = meetingTime[0];
        int min = meetingTime[1];


        //get all the arrival cities for each departure city and add them in a map
        for (Schedule schedule : trainSchedules) {
            Map<String, String> map = adj.getOrDefault(schedule.dCity, new HashMap<>());
            map.put(schedule.aCity, schedule.aTime);   //storing departure city, arrival city and arrival time

            adj.put(schedule.dCity, map);
        }

        //We are trying to first know if there is a connection at all.
        Stack<String> stack = new Stack<>();

        //check for value in hashMap and push to the stack
        if (adj.containsKey(deptCity)) {
            stack.push(deptCity);
            visited.add(deptCity);
        }

        Map<String, String> map = null;
        while (!stack.isEmpty()) {
            String current = stack.pop();

            int[] currMeet;
            if(current.equals(arrivalCity)){
                if(!(map == null) && map.containsKey(current)){
                    currMeet = getTimeIntEquivalent(map.get(current));
                    int hrPart = currMeet[0];
                    int minPart = currMeet[1];

                    if(hr > hrPart) return true;
                    else return hr == hrPart && min > minPart;
                }
            }


            if(adj.containsKey(current)){
                map = adj.get(current);
                for (String s : map.keySet()) {
                    if(!visited.contains(s)){
                        stack.push(s);
                        visited.add(s);
                    }
                }
            }
        }

        return false;
    }

    static int[] getTimeIntEquivalent(String meetTime){
        StringBuilder sb = new StringBuilder();
        int[] res = new int[2];

        for(int i = 0, j = 0; i < meetTime.length(); i++){
            if(meetTime.charAt(i) == ':'|| i == meetTime.length() - 1){
                if(i == meetTime.length() - 1){
                    sb.append(meetTime.charAt(i));
                    res[j++] = Integer.parseInt(sb.toString());
                }else if(meetTime.charAt(i) == ':'){
                    res[j++] = Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
            }else sb.append(meetTime.charAt(i));
        }
        return res;
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i : nums1){
            set.add(i);
        }


        int j = 0;
        for(int i = 0; i < set.size(); i++){
            if(set.contains(nums2[i]) && !visited.contains(nums2[i])){
                list.add(nums2[i]);
                visited.add(nums2[i]);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;
    }

}
