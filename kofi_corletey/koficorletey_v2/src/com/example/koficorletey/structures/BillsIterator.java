package com.example.koficorletey.structures;

import com.example.koficorletey.models.Bill;
import com.example.koficorletey.models.IssuedProduct;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BillsIterator implements Iterable<Bill> {
    private List<Bill> list;

    // Empty initial list
    public BillsIterator(){
        list = new LinkedList<>();
    }

    // add item
    public void addBill(Bill bill){
        if (bill != null){
            list.add(bill);
        }
    }

    //find bill
    public Bill find(int id){
        for (Bill bill : list)
            if (id == bill.getId())
                return bill;

        return null;
    }


    // generate iterator from list
    public Iterator<Bill> iterator()
    {
        return list.iterator();
    }


}
