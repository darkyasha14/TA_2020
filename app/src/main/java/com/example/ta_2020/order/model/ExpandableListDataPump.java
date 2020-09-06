package com.example.ta_2020.order.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> bni= new ArrayList<String>();
        bni.add("096055543");

        List<String> mandiri = new ArrayList<String>();
        mandiri.add("0987666767");

        List<String> gopay = new ArrayList<String>();
        gopay.add("08126744266");

        List<String> ovo = new ArrayList<String>();
        ovo.add("08126744266");

        List<String> dana = new ArrayList<String>();
        dana.add("08126744266s");

        expandableListDetail.put("BNI", bni);
        expandableListDetail.put("mandiri", mandiri);
        expandableListDetail.put("gopay", gopay);
        expandableListDetail.put("OVO", ovo);
        expandableListDetail.put("DANA", dana);
        return expandableListDetail;
    }
}
