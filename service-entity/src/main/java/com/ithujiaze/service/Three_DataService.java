package com.ithujiaze.service;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Three_Data;

import java.util.List;

public interface Three_DataService {
    public R GetThree_DataById(int id);

    public R GetThree_DataByIdGroupByCount(int id);

    public R insert(Three_Data three_data);

    public R GetThree_DataByAddress(String address);

    public R GetThree_DataByAddressNowDay(String address);

    public R GetThree_DataByAddressSevenDay(String address);

    public R GetThree_DataByAddressOneMonth(String address);

    public R DeleteThree_DataByThreeMonth();
}
